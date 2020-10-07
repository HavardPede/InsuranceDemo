package com.integration.mailer;

/*
   ## Description
    This class is the implementation of the mocked mail server.
 */

import java.util.UUID;

public class SMTPMailer {
    public SMTPMailer() {}
    private final int ERROR = 500;
    private final int SUCCESS = 211;

    public int sendInsuranceConfirmation(String email, UUID insuranceId) {
        System.out.println("Email Sender: Your insurance agreement has been accepted. Here is the reference: "
                + insuranceId
        );

        return SUCCESS;
    }

    public int sendUnsuccessfulConfirmation(String email, Long insuranceId) {
        return ERROR;
    }

    public int errorCode() { return ERROR; }
    public int successCode() { return SUCCESS; }
}
