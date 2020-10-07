package com.subjectsystem.entities;

import java.util.Objects;
import java.util.UUID;

/*
   ## Description
    The Customer Entity.
    It contains the unique field ID, which is a UUID. This is a bit overkill, but
    how I would do it if I were to use an actual database.

   ## Future changes
    The current implementation does not validate the inputs past any type checks.
    A name can be an empty string, a birthNumber does not have to be unique etc.

    If I was to extend this, I would create attribute validation and throw an error upon creation and editing
    if an attribute did not pass validation.

 */

public class Customer {
    private final UUID id;
    private String forename;
    private String surname;
    private String email;
    private int birthNumber;

    public Customer(String forename, String surname, String email, int birthNumber) {
        this.id = UUID.randomUUID();
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.birthNumber = birthNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Customer customer = (Customer) obj;
        return Objects.equals(id, customer.id)
                && Objects.equals(birthNumber, customer.birthNumber)
                && Objects.equals(forename, customer.forename)
                && Objects.equals(surname, customer.surname)
                && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, forename, surname, birthNumber, email);
    }

    public UUID getId() {
        return id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBirthNumber() {
        return birthNumber;
    }

    public void setBirthNumber(int birthNumber) {
        this.birthNumber = birthNumber;
    }

    @Override
    public String toString() {
        return "Customer{"
                + "id=" + id
                + ", forename='" + forename + '\''
                + ", surname='" + surname + '\''
                + ", email='" + email + '\''
                + ", birthNumber=" + birthNumber
                + '}';
    }
}
