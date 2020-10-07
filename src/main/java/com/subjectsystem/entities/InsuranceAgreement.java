package com.subjectsystem.entities;

import com.subjectsystem.Status;
import java.util.Objects;
import java.util.UUID;

/*
   ## Description
    The Insurance Agreement entity.
    It contains the unique field ID, which is a UUID. This is a bit overkill, but
    how I would do it if I were to use an actual database.


   ## Future Changes
    Much like I have mentioned on the Customer entity, we are not validating attributes.
 */

public class InsuranceAgreement {
    private final UUID id;
    private String registrationNumber;
    private String bonus;
    private String status;
    private Customer owner;

    public InsuranceAgreement(String registrationNumber, String bonus, Customer owner) {
        this.id = UUID.randomUUID();
        this.registrationNumber = registrationNumber;
        this.bonus = bonus;
        this.owner = owner;
        this.status = Status.processing();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuranceAgreement insuranceAgreement = (InsuranceAgreement) o;
        return getId().equals(insuranceAgreement.getId())
                && Objects.equals(getRegistrationNumber(), insuranceAgreement.getRegistrationNumber())
                && Objects.equals(getBonus(), insuranceAgreement.getBonus())
                && Objects.equals(getOwner(), insuranceAgreement.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRegistrationNumber(), getBonus(), getOwner());
    }

    public UUID getId() {
        return id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void accept() {
        this.status = Status.accepted();
    }

    public void decline() {
        this.status = Status.declined();
    }

    public void processing() {
        this.status = Status.processing();
    }

    @Override
    public String toString() {
        return "Insurance{"
                + "id=" + id
                + ", registrationNumber='" + registrationNumber + '\''
                + ", bonus='" + bonus + '\''
                + ", status ='" + status + '\''
                + '}';
    }
}
