package com.pluralsight.thecardealershipapi;

//@Component
public class SalesContract extends Contract {
    int id;
    String contractType;
    double salesTaxAmount;
    double recordingFee;
    double processingFee; //295 for vehicles under 10,000 and $495 for all others
    boolean isFinancing;
    double monthlyPayment = 0; // all loans are 4.25% for 48 months if the price is 10,000 or more; otherwise 5.25% for 24 months

    double endingTotal;

public  SalesContract(){}
//    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment, boolean isFinancing) {
//        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
//        this.salesTaxAmount = 0.05;
//        this.recordingFee = 100;
//        this.isFinancing = isFinancing;
//        this.contractType = "SALE";
//        getMonthlyPayment();
//        getTotalPrice();
//
//    }

    public SalesContract(int contractID, String customerName, int dealerID, String vin) {
        super(customerName,dealerID,vin);
        this.id = contractID;
        System.out.println("Used new one ");
    }

    public SalesContract(int contractID, int dealerID, String vin) {
    }


    @Override
    public void getTotalPrice() {

        System.out.printf("This is the total of after all payments and fees $%.2f "  ,endingTotal );
        System.out.println();


    }
    @Override
    public double getMonthlyPayment() {
        if (isFinancing) {
            if (this.totalPrice >= 10_000) {
                this.processingFee = 495;
                double interestRate = 0.0425;
//                double interestRate = 4.25;
                double monthlyInterestRate = interestRate / 12;

                int monthTerm = 48;

                monthlyPayment = (totalPrice * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -monthTerm));
endingTotal = (monthlyPayment * 48) + this.recordingFee + processingFee * this.salesTaxAmount;


            } else {
                this.processingFee = 495;
                double interestRate = 0.0525;
//                double interestRate = 5.25;
                double monthlyInterestRate = interestRate / 12 ;

                int monthTerm = 24;

                monthlyPayment = (this.totalPrice * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -monthTerm));
                endingTotal = (monthlyPayment * 24) + this.recordingFee + processingFee * this.salesTaxAmount;



            }
        } else {
            monthlyPayment = 0;
            endingTotal =  this.totalPrice + this.recordingFee + processingFee * this.salesTaxAmount;
        }

        System.out.printf("Monthly payment is $%.2f", monthlyPayment);
        System.out.println();
        return 0;
    }
}
