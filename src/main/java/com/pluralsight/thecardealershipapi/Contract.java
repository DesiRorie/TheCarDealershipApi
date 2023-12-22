package com.pluralsight.thecardealershipapi;


public abstract class Contract {
//    String date;
    String customerName;
//    String customerEmail;
//    String vehicleSold;
    double totalPrice;
    double monthlyPayment;
    String vin;

    int leaseID;
    String lesseeName;
    String leaseStartDate;
    String leaseEndDate;
    int dealerID;
    public Contract() {
    }

    public Contract(int leaseID,String lesseeName,String leaseStartDate,String leaseEndDate,String vin,int dealerID){
        this.leaseID = leaseID;
        this.lesseeName = lesseeName;
        this.customerName = lesseeName;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.vin = vin;
        this.dealerID = dealerID;
    }

    public Contract(String customerName, int dealerID, String vin) {
        this.customerName = customerName;
        this.dealerID = dealerID;
        this.vin = vin;
    }

    public Contract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment) {

    }

    public int getDealerID() {
        return dealerID;
    }

    public String getVin() {
        return vin;
    }
//    public String getDate() {
//        return date;
//    }

//    public void setDate(String date) {
//        this.date = date;
//    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }

    public String getLesseeName() {
        return lesseeName;
    }

    public void setLesseeName(String lesseeName) {
        this.lesseeName = lesseeName;
    }

    public String getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(String leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public String getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(String leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public void setDealerID(int dealerID) {
        this.dealerID = dealerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

//    public String getCustomerEmail() {
//        return customerEmail;
//    }

//    public void setCustomerEmail(String customerEmail) {
//        this.customerEmail = customerEmail;
//    }

//    public String getVehicleSold() {
//        return vehicleSold;
//    }


//    public void setVehicleSold(String vehicleSold) {
//        this.vehicleSold = vehicleSold;
//    }
    public abstract void getTotalPrice();
    public abstract double getMonthlyPayment();
}
