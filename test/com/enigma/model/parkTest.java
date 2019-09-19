package com.enigma.model;

import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class parkTest {
    @Test
    //hitungan Ruang yang Tersedia Jika ruang 1 saat tidak ada tempat parkir
    public void countAvailableSpace_Should_space1_when_noCarparkget(){

        Integer maxSpace = 1;
        ParkingArea parkingAreaTest = new ParkingArea(maxSpace);
        assertEquals(parkingAreaTest.countAvailableSpace(),maxSpace);
    }
@Test
//hitungan Ruang yang Tersedia harus kembali 2 saat 1 mobil Masuk
    public void countAvailableSpace_should_return2_when_1CarEntryPark(){
        Integer maxSlot = 3;
        Integer expectedAvailableSpace = 2;
        ParkingArea parkingArea =new ParkingArea(maxSlot);
        Car xenia = new Car("B4533 spz");
        parkingArea.entryCar(xenia);
        assertEquals(expectedAvailableSpace,parkingArea.countAvailableSpace());

    }
    @Test
    // jika parkir tidak full dan mobil masuk 1 maka akan false
    public void parking_is_full_when_car_parking_in_Slot_Into_Max(){
        Integer maxSlot=2;
        Boolean exceptedFull = false;
        ParkingArea parkingArea = new ParkingArea(maxSlot);
        Car inova = new Car("B 123 CCC");
        parkingArea.entryCar(inova);
        parkingArea.isFull();
        //assert(ekspetasi, realita)
        assertEquals(exceptedFull,parkingArea.isFull());
    }
    @Test
    // parkir akan full ketika 2 mobil sesuai kapasitas slot yang tersedia
    public void parking_is_full_when_car_parking1_in_Slot_Into_Max(){
        Integer maxSlot=2;
        Boolean exceptedFull = true;
        ParkingArea parkingArea = new ParkingArea(maxSlot);
        Car inova = new Car("B 123 CCC");
        Car dd = new Car("B 123 CCC");
        // mobil parkir 2
        parkingArea.entryCar(dd);
        parkingArea.entryCar(inova);
        parkingArea.isFull();
        assertEquals(exceptedFull,parkingArea.isFull());
    }
    @Test
    //tempat parkir tidak bisa untuk parkir mobil ketika slot parkir penuh
    public void parking_shouldFalse_to_parkCar_When_parkingSlot_isFull(){
    Integer maxSlot = 2 ;
    Boolean exceptedFull = false;
    ParkingArea parkingArea = new ParkingArea(maxSlot);
    Car avanza = new Car("BE 1234 RRR");
    Car inova = new Car("BE 1234 RRR");
    Car xenia = new Car("BE 1234 RRR");
    parkingArea.entryCar(avanza);
    parkingArea.entryCar(inova);
    parkingArea.entryCar(xenia);
    parkingArea.cekPark();
    assertEquals(exceptedFull,parkingArea.cekPark());
    }
    @Test
    //tidak bisa parkir kompilasi ada plat mobil yang sama
    public void canot_compile_parking_there_is_the_same_car_plate(){
        Integer maxSlot = 3;
        Boolean exceptedFull = true;
        ParkingArea parkingArea = new ParkingArea(maxSlot);
        Car mycar = new Car("BE 2134 JJJ");
        Car yourCar = new Car("BE 2134 JJJ");
        parkingArea.entryCar(mycar);
        parkingArea.chekLicense(yourCar);
        assertEquals(exceptedFull,parkingArea.chekLicense(yourCar));
    }
    @Test
    //tidak bisa parkir ketika melewati batas waktu jam 7 sampai jam 21
    public void cannot_park_when_past_the_7_to_21_deadline() {
        Integer startPark = 7;
        Integer endPark = 21;
        Integer maxSlot = 3;
        Integer time = 12;
        Boolean Park = true;
        ParkingArea parkingArea = new ParkingArea(maxSlot);
        Car mycar = new Car("BE 222 HH");
        parkingArea.entryCar(mycar);
        parkingArea.inTime(startPark,endPark);
        parkingArea.cekTime(time);
        assertEquals(Park,parkingArea.cekTime(time));
    }
    @Test
    public void Car_out_When_finish_parking(){
        Integer maxSlot = 2;
        Integer excepted = 2;
        ParkingArea parkingArea = new ParkingArea(maxSlot);
        Car car = new Car("BE 12233 ZZZ");
        parkingArea.entryCar(car);
        parkingArea.carOut(car);
        assertEquals(excepted,parkingArea.countAvailableSpace());
    }


}
