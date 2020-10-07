package com.subjectsystem.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

/*
   ## Description
    The interface for the Subject systems API.

   ## Future changes
    I would probably change this to return the entire entity instead of just the reference.
    But the current implementation was enough to solve the task.
 */

public interface ApiInterface extends Remote {
    public UUID createCustomer(String forename, String surname, String email, int birthNumber) throws RemoteException;
    public UUID createInsuranceAgreement(String registrationNumber, String bonus, UUID customerId) throws RemoteException;
    public String updateInsuranceAgreementStatus(UUID insuranceAgreementId, String status) throws RemoteException;
}