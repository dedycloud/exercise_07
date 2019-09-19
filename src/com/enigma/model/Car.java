package com.enigma.model;

import java.util.Objects;

public class Car {
    private String lecensePlate;

    public Car(String LicensePlate) {
        this.lecensePlate=LicensePlate;

    }

    public String getLicensePlate() {
      return   this.lecensePlate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(lecensePlate, car.lecensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lecensePlate);
    }
}
