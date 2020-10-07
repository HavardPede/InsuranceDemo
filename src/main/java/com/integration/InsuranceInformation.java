package com.integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/*
   ## Description
    This is the XML declaration for the data we expect to receive from the Client application.
 */

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "insuranceInformation")
public class InsuranceInformation {
    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "registrationNumber")
    private String registrationNumber;

    @XmlAttribute(name = "bonus")
    private String bonus;

    @XmlAttribute(name = "birthNumber")
    private int birthNumber;

    @XmlAttribute(name = "forename")
    private String forename;

    @XmlAttribute(name = "surname")
    private String surname;

    @XmlAttribute(name = "email")
    private String email;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registration_number) {
        this.registrationNumber = registration_number;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public int getBirthNumber() {
        return birthNumber;
    }

    public void setBirthNumber(int birthNumber) {
        this.birthNumber = birthNumber;
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
    @Override
    public String toString() {
        return "[forename=" + this.getForename()
                + ", surname=" + this.getSurname()
                + ", mailAddress=" + this.getEmail()
                + ", birthNumber=" + this.getBirthNumber()
                + ", bonus=" + this.getBonus()
                + ", registrationNumber=" + this.getRegistrationNumber()
                + "]";
    }
}
