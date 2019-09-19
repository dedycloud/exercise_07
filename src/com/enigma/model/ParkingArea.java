package com.enigma.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ParkingArea {
    Integer maxSpace;
    Integer startPark;
    Integer endPark;
    Set<Car> carSlot = new HashSet<>();

    public ParkingArea(Integer maxSpace) {
        this.maxSpace = maxSpace;
    }

    public Boolean chekLicense(Car car) {
        return carSlot.contains(car);
    }

    public Integer countAvailableSpace(){
        return this.maxSpace-carSlot.size() ;
}

    public void entryCar(Car car) {
        carSlot.add(car);
    }

    public Boolean isFull() {
        return this.maxSpace.equals(carSlot.size());
    }

    public Boolean cekPark() {
        if (this.maxSpace >= carSlot.size()){
            return  true;
        }
        return false;
    }

    public void inTime(Integer startPark, Integer endPark) {
        this.startPark=startPark;
        this.endPark=endPark;
    }

    public Boolean cekTime(Integer time) {
        if (time > this.startPark && time < this.endPark ){
            return true;
        }
        return false;

    }

    public void carOut(Car car) {
       carSlot.remove(car);
    }
}
