package com.pluralsight.thecardealershipapi.DAO;

import com.pluralsight.thecardealershipapi.Controller.LeaseContractController;
import com.pluralsight.thecardealershipapi.LeaseContract;
import com.pluralsight.thecardealershipapi.SalesContract;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
@Component
public class JdbcLeaseContractDao implements  LeaseContractDao {
    private final DataSource dataSource;

    public JdbcLeaseContractDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<LeaseContract> getAll() {
        ArrayList<LeaseContract> contracts = new ArrayList<>();
        String sql = "SELECT * FROM LeaseContracts";
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(sql);
            while (rows.next()) {
                int leaseID = rows.getInt("LeaseID");
                String lesseeName = rows.getString("LesseeName");
                String leaseStartDate = rows.getString("LeaseStartDate");
                String leaseEndDate = rows.getString("LeaseEndDate");
                Double monthlyPayment = rows.getDouble("MonthlyPayment");
                String VIN = rows.getString("VIN");
                int dealershipID = rows.getInt("DealershipID");
                System.out.println(monthlyPayment);
                LeaseContract leaseContract = new LeaseContract(leaseID,lesseeName,leaseStartDate,leaseEndDate,dealershipID,VIN,monthlyPayment);
                System.out.println(leaseContract);
                contracts.add(leaseContract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contracts;
    }

    @Override
    public LeaseContract getById(int id) {
        LeaseContract leaseContract = null;
        String sql = "SELECT * FROM LeaseContracts WHERE LeaseID = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet rows = preparedStatement.executeQuery();

            if (rows.next()) {
                int leaseID = rows.getInt("LeaseID");
                String customerName = rows.getString("LesseeName");
                String leaseStartDate = rows.getString("LeaseStartDate");
                String leaseEndDate = rows.getString("LeaseEndDate");
                String VIN = rows.getString("VIN");
                int dealerID = rows.getInt("DealershipID");
                leaseContract = new LeaseContract(leaseID,customerName,leaseStartDate,leaseEndDate,VIN,dealerID);

                System.out.println(leaseID);
                System.out.println(dealerID);
                System.out.println(customerName);
                System.out.println(VIN);
//                System.out.println(salesContract.getCustomerName());
//                System.out.println(salesContract.getVin());
//                System.out.println(salesContract.getDealerID());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return leaseContract;
    }

    @Override
    public LeaseContract insertLeaseContract(LeaseContract leaseContract) {
        String sql = "INSERT INTO LeaseContracts(leaseID,LesseeName,leaseStartDate,leaseEndDate,VIN,dealershipID) VALUES (?, ?, ?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, leaseContract.getLeaseID());
            preparedStatement.setString(2, leaseContract.getCustomerName());
            preparedStatement.setString(3, leaseContract.getLeaseStartDate());
            preparedStatement.setString(4, leaseContract.getLeaseEndDate());
            preparedStatement.setString(5, leaseContract.getVin());
            preparedStatement.setInt(6, leaseContract.getDealerID());


            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Lease added");
                return leaseContract;
            } else {
                System.out.println("Failed to add");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteLeaseContract(int id) {

    }


}
