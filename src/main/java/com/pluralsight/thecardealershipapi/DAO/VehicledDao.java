package com.pluralsight.thecardealershipapi.DAO;

import com.pluralsight.thecardealershipapi.Vehicle;

import java.util.List;

public interface VehicledDao {
    List<Vehicle> getAll();
    Vehicle getById(int id);
    Vehicle insertVehicle(Vehicle vehicle);

    void deleteVehicle(int id);
}
