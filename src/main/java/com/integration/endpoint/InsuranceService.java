package com.integration.endpoint;

import com.integration.InsuranceInformation;
import com.integration.mailer.SMTPMailer;
import com.subjectsystem.interfaces.ApiInterface;
import org.springframework.stereotype.Service;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.UUID;

/*
   ## Description
    The only path in the Integration application is the post-path to /insurance/car.

    This is the meat of the operation and handles communication to and from both the client and the Subject system.
    This currently only receives the bare minimum of information from the Subject system.

   ## Future Changes
    In any realistic scenario, there would be a bunch of reasons for fetching the entire entity as opposed to only
    the entity reference. If this fails, we return a 500 error message. I could probably lean a bit more into this
    by returning errors from the mailer "system" and from the Subject system if entity failed to be created/edited,
    or if mail didn't send.

    With a more developed client application, I should probably improve the API to follow the CRUD model.

    Lastly, we are currently referring to the API interface from the Subject System.
    I was not sure of the best practice when two separate applications are using the same interface.
 */

@Service
@Path("/insurance/car")
public class InsuranceService {
    @POST
    @Produces("application/json")
    public Response createInsurance(InsuranceInformation info) {
        System.out.println("##--- We Received a new post request ---##");
        System.out.println(info);

        try {
            // Connect to Subject System
            Registry registry = LocateRegistry.getRegistry(1888);
            ApiInterface api = (ApiInterface) registry.lookup("SubjectSystem");

            // Create entities
            UUID customerId = api.createCustomer(info.getForename(), info.getSurname(), info.getEmail(), info.getBirthNumber());
            UUID agreementId = api.createInsuranceAgreement(info.getRegistrationNumber(), info.getBonus(), customerId);

            //Send email
            SMTPMailer mailer = new SMTPMailer();
            int responseCode = mailer.sendInsuranceConfirmation(info.getEmail(), agreementId);

            // Update insurance agreement status
            String status = responseCode == mailer.successCode() ? "accepted" : "declined";
            String agreementStatus = api.updateInsuranceAgreementStatus(agreementId, status);

            // Create and send json response
            String response = "{"
                    + "\"insuranceAgreementNumber\":" + "\"" + agreementId + "\""
                    + ", \"status\":" + "\"" + agreementStatus + "\""
                    + "}";

            return Response.status(200).entity(response).build();


        } catch (Exception e) {
            System.out.println("Failed to connect to the Subject System" + e);

            // Error occurred. Return 500, internal server error
            return Response.status(500).build();
        }
    }
}