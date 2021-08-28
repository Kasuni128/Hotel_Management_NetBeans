package com.example.smart_bus_system.qrcode.models;

import java.util.ArrayList;
import java.util.List;

public class Passenger
{
    private String username,firstName,lastName,nic,mobileNumber,password;
    private String passengerId;

    private List<Journey> journeyList;

    public String getPassengerId() {
        return passengerId;
    }

    public List<Journey> getJourneyList() {
        return journeyList;
    }

    public void setJourneyList(List<Journey> journeyList) {
        this.journeyList = journeyList;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public Passenger()
    {

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
