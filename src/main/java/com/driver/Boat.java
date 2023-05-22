package com.driver;

public class Boat implements WaterVehicle{
    String name="";
    int capacity=0;
    Boat(String name,int capacity){
        this.name=name;
        this.capacity=capacity;
    }

    @Override
    public String getVehicleName() {

        return this.name;
    }

    @Override
    public int getVehicleCapacity() {

        return this.capacity;
    }
}
