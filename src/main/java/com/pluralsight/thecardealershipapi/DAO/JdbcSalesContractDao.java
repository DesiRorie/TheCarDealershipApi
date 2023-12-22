package com.pluralsight.thecardealershipapi.DAO;

import com.pluralsight.thecardealershipapi.Contract;
import com.pluralsight.thecardealershipapi.SalesContract;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Component
public class JdbcSalesContractDao implements SalesContractDao {
    private final DataSource dataSource;

    public JdbcSalesContractDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<SalesContract> getAll() {
        ArrayList<SalesContract> contracts = new ArrayList<>();
        String sql = "SELECT * FROM SalesContracts";
        try (Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(sql);
            while (rows.next()) {
                int contractID = rows.getInt("ContractID");
                String customerName = rows.getString("CustomerName");
                int dealerID = rows.getInt("DealerID");
                String VIN = rows.getString("VIN");
                SalesContract salesContract = new SalesContract(contractID,customerName,dealerID,VIN);
                System.out.println(salesContract);
                contracts.add(salesContract);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contracts;
    }
    @Override
    public SalesContract getById(int id) {
        SalesContract salesContract = null;
        String sql = "SELECT * FROM SalesContracts WHERE ContractID = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet rows = preparedStatement.executeQuery();

            if (rows.next()) {
                int contractID = rows.getInt("ContractID");
                String customerName = rows.getString("CustomerName");
                int dealerID = rows.getInt("DealerID");
                String VIN = rows.getString("VIN");
                salesContract = new SalesContract(contractID,customerName,dealerID,VIN);

                System.out.println(contractID);
                System.out.println(dealerID);
                System.out.println(customerName);
                System.out.println(VIN);
//                System.out.println(salesContract.getCustomerName());
                System.out.println(salesContract.getVin());
                System.out.println(salesContract.getDealerID());
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return salesContract;
    }
    @Override
    public SalesContract insertSalesContract(SalesContract salesContract) {

        String sql = "INSERT INTO SalesContracts (CustomerName, DealerID,VIN) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, salesContract.getCustomerName());
            preparedStatement.setInt(2, salesContract.getDealerID());
            preparedStatement.setString(3, salesContract.getVin());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Product added");
                return salesContract;
            } else {
                System.out.println("Failed to add");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    public void deleteSalesContract(int id) {

    }
}
