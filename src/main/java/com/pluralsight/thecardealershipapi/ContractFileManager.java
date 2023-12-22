//package com.pluralsight.thecardealershipapi;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//
//public class ContractFileManager {
//    public ContractFileManager() {
////        try{
////            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
////            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv",true));
////
////            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src/main/resources/contracts.csv"));
////            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv",true));
////        }
////        catch(Exception e){
////            e.printStackTrace();
////
////        }
//
//
//    }
//
//
//    //    public Contract readContractCSV(String readContract) {
////        String[] info = readContract.split("\\|");
////
////        if (info.length != 8) {
////            System.out.println("Incomplete Contract: " + readContract);
////            return null;
////        }
////
////        String date  = info[0];
////        String customerName  = info[1];
////        String customerEmail  = info[2];
////        String vehicleSold  = info[3];
////        double totalPrice = Integer.parseInt(info[4]);
////        double monthlyPayment = Integer.parseInt(info[5]);
////
////
////
////        return contract;
////    }
//    public Vehicle readCSV(String readVehicle) {
//        String[] info = readVehicle.split("\\|");
//
//        if (info.length != 8) {
//            System.out.println("Incomplete Vehicle: " + readVehicle);
//            return null;
//        }
//
//        int vin = Integer.parseInt(info[0]);
//        int year = Integer.parseInt(info[1]);
//        String make = info[2];
//        String model = info[3];
//        String vehicleType = info[4];
//        String color = info[5];
//        int odometer = Integer.parseInt(info[6]);
//        double price = Double.parseDouble(info[7]);
//
//
//        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
//        return vehicle;
//    }
//
//    public static void writeSalesContract(SalesContract contract) {
//        try {
//            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
//            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv", true));
//
//            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src/main/resources/contracts.csv"));
//            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv", true));
////            Type of contract | date | customer name | email | VIN | year of car | Model | Make | Vehicle Type | odometer | price| sales Tax | recording Fee | processingFee | isFinancing| Monthly Payment | ending total;
//            bufferedWriter2.write(contract.contractType + "|" + contract.getDate() + "|" + contract.getCustomerName()+ "|" + contract.getCustomerEmail() + "|" + contract.vehicleSold + "|" + String.format("%.2f", contract.totalPrice) + "|" + String.format("%.2f", contract.salesTaxAmount) + "|" + String.format("%.2f", contract.recordingFee) + "|" + String.format("%.2f", contract.processingFee) + "|" + Boolean.toString(contract.isFinancing) + "|" + String.format("%.2f", contract.monthlyPayment) + "|" + String.format("%.2f", contract.endingTotal));
//            bufferedWriter2.newLine();
//            bufferedWriter2.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//
//
//    }
//
//    public static void writeLeaseContract(LeaseContract contract) {
//        try{
//            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
//            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv",true));
//
//            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src/main/resources/contracts.csv"));
//            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv",true));
////            Type of contract | date | customer name | email | VIN | year of car | Model | Make | Vehicle Type | odometer | price| sales Tax | recording Fee | processingFee | isFinancing| Monthly Payment | ending total;
//            bufferedWriter2.write(contract.contractType + "|" + contract.getDate()+ "|"  + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" +contract.vehicleSold + "|" + String.format("%.2f",contract.totalPrice) + "|" + contract.leaseFee + "|" + String.format("%.2f",contract.monthlyPayment) + "|" +  String.format("%.2f", contract.endTotalPrice));
//            bufferedWriter2.newLine();
//            bufferedWriter2.close();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//
//        }
////
////        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv",false))) {
////            for (Transaction transaction : transactionArrayList) {
////                bufferedWriter.write(String.format("%s|%s|%s|%s|%.2f", transaction.getDate(), transaction.getTime(),
////                        transaction.getDescription(), transaction.getVendor(), transaction.getAmount()));
////                bufferedWriter.newLine();
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//
//    }
//}
