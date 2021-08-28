package com.example.smart_bus_system.qrcode.models;

public class Journey
{
    private String busNo;
    private String busRoot;
    private double EnteredLatitude,EnteredLongitude;
    private double ExitLatitude,ExitLongitude;
    private String passengerName;
    private String passengerId;
    private String EnteredDate;
    private String ExitDate;
    private String ExitTime;
    private String EnteredTime;
    private String journeyId;

    public String getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(String journeyId) {
        this.journeyId = journeyId;
    }

    public double getEnteredLatitude() {
        return EnteredLatitude;
    }

    public void setEnteredLatitude(double enteredLatitude) {
        EnteredLatitude = enteredLatitude;
    }

    public double getEnteredLongitude() {
        return EnteredLongitude;
    }

    public void setEnteredLongitude(double enteredLongitude) {
        EnteredLongitude = enteredLongitude;
    }

    public double getExitLatitude() {
        return ExitLatitude;
    }

    public void setExitLatitude(double exitLatitude) {
        ExitLatitude = exitLatitude;
    }

    public double getExitLongitude() {
        return ExitLongitude;
    }

    public void setExitLongitude(double exitLongitude) {
        ExitLongitude = exitLongitude;
    }

    public String getEnteredDate() {
        return EnteredDate;
    }

    public void setEnteredDate(String enteredDate) {
        EnteredDate = enteredDate;
    }

    public String getExitDate() {
        return ExitDate;
    }

    public void setExitDate(String exitDate) {
        ExitDate = exitDate;
    }

    public String getExitTime() {
        return ExitTime;
    }

    public void setExitTime(String exitTime) {
        ExitTime = exitTime;
    }

    public String getEnteredTime() {
        return EnteredTime;
    }

    public void setEnteredTime(String enteredTime) {
        EnteredTime = enteredTime;
    }

    public Journey()
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



    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

}
