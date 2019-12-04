package com.boatingdock.model;

import java.util.Objects;

// Boat Class For manage all about Boat
public class Boat {

    private String registrationNumber;
    private String colour;

    public Boat(String registrationNumber, String colour) {
        this.registrationNumber = registrationNumber;
        this.colour = colour;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boat boat = (Boat) o;
        return this.hashCode() == boat.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
