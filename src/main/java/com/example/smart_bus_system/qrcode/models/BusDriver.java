package com.example.smart_bus_system.qrcode.models;

import java.util.ArrayList;

public class BusDriver
{
    private String busNo,busRoot,licenseId,driversName,number,password;
    private ArrayList<Journey> passengerList;

    public ArrayList<Journey> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<Journey> passengerList) {
        this.passengerList = passengerList;
    }

    public BusDriver()
    {

    }
    public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getBusRoot() {
        return busRoot;
    }

    public void setBusRoot(String busRoot) {
        this.busRoot = busRoot;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getDriversName() {
        return driversName;
    }

    public void setDriversName(String driversName) {
        this.driversName = driversName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
