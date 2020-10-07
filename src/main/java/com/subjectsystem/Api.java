package com.subjectsystem;

import com.subjectsystem.entities.Customer;
import com.subjectsystem.entities.InsuranceAgreement;
import com.subjectsystem.interfaces.ApiInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;

/*
   ## Description
    The implementation of the API of the Subject system.
    This defines all interaction between the Integration layer and the Subject system.
 */

public class Api extends UnicastRemoteObject implements ApiInterface {
    Database database;

    public Api() throws RemoteException {
        this.database = new Database();
    }

    public UUID createCustomer(String forename, String surname, String email, int birthNumber) {
        Customer customer = new Customer(forename, surname, email, birthNumber);
        database.putCustomer(customer);

        return customer.getId();
    }

    public UUID createInsuranceAgreement(String registrationNumber, String bonus, UUID customerId) {
        Customer customer = database.getCustomer(customerId);
        InsuranceAgreement agreement = new InsuranceAgreement(registrationNumber, bonus, customer);

        database.putInsuranceAgreement(agreement);

        return agreement.getId();
    }

    public String updateInsuranceAgreementStatus(UUID insuranceAgreementId, String status) {
        InsuranceAgreement agreement = database.getInsuranceAgreement(insuranceAgreementId);

        if (status.equals("accepted")) {
            agreement.accept();
        } else if (status.equals("processing")) {
            agreement.processing();
        } else {
            agreement.decline();
        }

        database.putInsuranceAgreement(agreement);

        return agreement.getStatus();
    }
}
