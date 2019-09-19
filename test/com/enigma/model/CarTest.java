package com.enigma.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarTest {
    //semua test adalah void
@Test
    public void getLicensePlate_Should_returnB3950SPZ_when_licensePlateSetB3950SPZ(){
    String lecensePlate = "B 3950 SPZ";
    Car carTest = new Car(lecensePlate);
    assertEquals(lecensePlate,carTest.getLicensePlate());
}
@Test
    public void assertFalse_when_LisencePlate_equals_B1234RRR_filled_With_B3950SPZ(){
        String lecensePlate = "B 3950 SPZ";
        String wrongLicensePlate = "B 1234 RRR";
        Car carTest = new Car(lecensePlate);
        assertFalse(carTest.getLicensePlate().equals(wrongLicensePlate));
    }


}