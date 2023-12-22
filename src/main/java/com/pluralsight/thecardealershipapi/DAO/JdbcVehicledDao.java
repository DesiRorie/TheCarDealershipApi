package com.pluralsight.thecardealershipapi.DAO;

import com.pluralsight.thecardealershipapi.Vehicle;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcVehicledDao implements VehicledDao {
    private final DataSource dataSource;

    public JdbcVehicledDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ArrayList<Vehicle> getAll() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM Vehicles;";
        try(Connection connection = dataSource.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet rows = statement.executeQuery(sql);
            while(rows.next()){
                int carID = rows.getInt("ID");
                String  VIN = rows.getString("VIN");
                String carMake = rows.getString("Make");
                Double unitPrice = rows.getDouble("Price");
                Vehicle vehicle = new Vehicle(carID,VIN,carMake,unitPrice);
                vehicles.add(vehicle);
            }
        }
        catch (SQLException e){ System.out.println(e); }
        return vehicles;
    }

    @Override
    public Vehicle getById(int id) {
        Vehicle vehicle = null;
        String sql = "SELECT * FROM Vehicles WHERE id  = ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet rows = preparedStatement.executeQuery();

            if (rows.next()) {
                int carID = rows.getInt("ID");
                String  VIN = rows.getString("VIN");
                String carMake = rows.getString("Make");
                Double unitPrice = rows.getDouble("Price");
                vehicle = new Vehicle(carID,VIN,carMake,unitPrice);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return vehicle;
    }

    @Override
    public Vehicle insertVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO Vehicles (VIN,Color,Make,Price,CarYear,Mileage,CarType) VALUES (?,?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, vehicle.getVin());
            preparedStatement.setString(2, vehicle.getColor());
            preparedStatement.setString(3, vehicle.getMake());
            preparedStatement.setDouble(4, vehicle.getPrice());
            preparedStatement.setInt(5, vehicle.getYear());
            preparedStatement.setInt(6, vehicle.getOdometer());
            preparedStatement.setString(7, vehicle.getVehicleType());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Vehicle added");
                return vehicle;
            } else {
                System.out.println("Failed to add");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteVehicle(int id) {
        String sql = "DELETE FROM Vehicles WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1,id);
            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Vehicle deleted");
            } else {
                System.out.println("Failed to delete");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
