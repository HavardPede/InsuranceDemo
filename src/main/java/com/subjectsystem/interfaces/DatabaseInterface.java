package com.subjectsystem.interfaces;

import com.subjectsystem.entities.Customer;
import com.subjectsystem.entities.InsuranceAgreement;
import java.util.UUID;

/*
   ## Description
    The interface for the mock database.
 */

public interface DatabaseInterface {
    public void putCustomer(Customer customer);
    public Customer getCustomer(UUID customerId);

    public void putInsuranceAgreement(InsuranceAgreement insuranceAgreement);
    public InsuranceAgreement getInsuranceAgreement(UUID insuranceAgreementId);
}
