package com.pluralsight.thecardealershipapi.Controller;

import com.pluralsight.thecardealershipapi.DAO.JdbcVehicledDao;
import com.pluralsight.thecardealershipapi.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
public class VehicleController {
    private JdbcVehicledDao jdbcVehicledDao;
    @Autowired
    public VehicleController(JdbcVehicledDao jdbcVehicledDao) {
        this.jdbcVehicledDao = jdbcVehicledDao;
    }
    @RequestMapping(path = "/vehicles", method = RequestMethod.GET)
    public ArrayList<Vehicle> getVehicles() {
        System.out.println("ALLLLLL");
        return jdbcVehicledDao.getAll();
    }


    @RequestMapping(path = "/vehicles/{id}", method = RequestMethod.GET)
    public Vehicle getProductById(@PathVariable int id) {
        return jdbcVehicledDao.getById(id);
    }


    @RequestMapping(path = "/vehicles/insert", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle insertProduct(@RequestBody Vehicle vehicle) {
        return jdbcVehicledDao.insertVehicle(vehicle);
    }



    @RequestMapping(path="/vehicles/delete/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id)
    {
        jdbcVehicledDao.deleteVehicle(id);
    }
}
