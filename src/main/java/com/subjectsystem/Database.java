package com.subjectsystem;

import com.subjectsystem.entities.InsuranceAgreement;
import com.subjectsystem.interfaces.DatabaseInterface;
import com.subjectsystem.entities.Customer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
   ## Description
    The implementation of the mock database.
    I simply create a map for each "table" where the unique ids map to the entity.


   ## Future implementation
    Pretty obvious, but I'd change this out with an actual database.
 */

public class Database implements DatabaseInterface {
    Map<UUID, Object> customers;
    Map<UUID, Object> insuranceAgreements;

    public Database() {
        customers = new HashMap<UUID, Object>();
        insuranceAgreements = new HashMap<UUID, Object>();
    }
    public void putCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer getCustomer(UUID customerId) {
        return (Customer) customers.get(customerId);
    }

    public void putInsuranceAgreement(InsuranceAgreement insuranceAgreement) {
        insuranceAgreements.put(insuranceAgreement.getId(), insuranceAgreement);
    }
    public InsuranceAgreement getInsuranceAgreement(UUID insuranceAgreementId) {
        return (InsuranceAgreement) insuranceAgreements.get(insuranceAgreementId);
    }
}
