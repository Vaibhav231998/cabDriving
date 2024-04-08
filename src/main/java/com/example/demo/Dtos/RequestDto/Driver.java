package com.example.demo.Dtos.RequestDto;

public class Driver {
    private String name;
    private String gender;
    private int age;
    private String vehicleDetails;
    private int[] currentLocation;
    private boolean available;



    public boolean isAvailable(){
        return available;
    }
    public void setAvailable(boolean available){
        this.available = available;
    }

    public int[] getCurrentLocation() {
        return currentLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public void setCurrentLocation(int[] currentLocation) {
        this.currentLocation = currentLocation;
    }
}