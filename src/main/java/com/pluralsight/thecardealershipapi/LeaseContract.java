package com.pluralsight.thecardealershipapi;

public class LeaseContract extends Contract {
    int id;
    String contractType;
    double expectedEndingValue; // 50% of the original price;
    double leaseFee; //7% of the original price;
    double interestRate = 4;
    int numberOfPayments = 36;
    double endTotalPrice;
    double monthlyPayment;
    public LeaseContract(){}

    //all leases are financed at 4.0% for 36 months
//
//         stmt.setString(1, name);
//            stmt.setString(2, startDate);
//            stmt.setString(3, endDate);
//            stmt.setDouble(4,monthlyPayment);
//            stmt.setString(5,vin);
//            stmt.setInt(6,dealerID);
    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
        this.contractType = "LEASE";
        getMonthlyPayment();
        getTotalPrice();
        setLeaseFee();
    }

    public LeaseContract(int leaseID, String lesseeName, String leaseStartDate, String leaseEndDate,  String vin,int dealerID) {
        super(leaseID,lesseeName,leaseStartDate,leaseEndDate,vin ,dealerID);
    }

    @Override
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public LeaseContract(int leaseID, String lesseeName, String leaseStartDate, String leaseEndDate, int dealerID, String vin, Double monthlyPayment) {
        super(leaseID,lesseeName,leaseStartDate,leaseEndDate,vin ,dealerID);
        this.monthlyPayment = getMonthlyPayment();

    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

//    public String getContractType() {
//        return contractType;
//    }
//
//    public void setContractType(String contractType) {
//        this.contractType = contractType;
//    }
//
//    public void setLeaseFee(double leaseFee) {
//        this.leaseFee = leaseFee;
//    }
//
//    public double getInterestRate() {
//        return interestRate;
//    }
//
//    public void setInterestRate(double interestRate) {
//        this.interestRate = interestRate;
//    }
//
//    public int getNumberOfPayments() {
//        return numberOfPayments;
//    }
//
//    public void setNumberOfPayments(int numberOfPayments) {
//        this.numberOfPayments = numberOfPayments;
//    }
//
//    public double getEndTotalPrice() {
//        return endTotalPrice;
//    }
//
//    public void setEndTotalPrice(double endTotalPrice) {
//        this.endTotalPrice = endTotalPrice;
//    }


//    public double getExpectedEndingValue() {
//        return expectedEndingValue;
//    }

//    public void setExpectedEndingValue(double expectedEndingValue) {
//        this.expectedEndingValue = this.totalPrice / 2;
//    }

    //    public double getLeaseFee() {
//        return leaseFee;
//    }
    public void setLeaseFee() {
        this.leaseFee = this.totalPrice * 0.07;
    }






    @Override
    public void getTotalPrice() {
        System.out.println("Total price paid $" + endTotalPrice);


    }

    public double getMonthlyPayment() {
        //lease fee is totalPrice * 0.07;
        double residualPrice = this.totalPrice / 2;

        double moneyFactor = interestRate/2400;


        double depreciationFee = (this.totalPrice - residualPrice) / 36;


        double financeFee = (this.totalPrice + residualPrice) * moneyFactor;


        monthlyPayment = depreciationFee + financeFee;
        System.out.printf("Monthly payment is $%.2f", monthlyPayment);
        endTotalPrice = monthlyPayment * 36;
        return  monthlyPayment;


    }
}
