package com.pluralsight.thecardealershipapi.Controller;

import com.pluralsight.thecardealershipapi.DAO.JdbcLeaseContractDao;
import com.pluralsight.thecardealershipapi.DAO.JdbcSalesContractDao;
import com.pluralsight.thecardealershipapi.DAO.JdbcVehicledDao;
import com.pluralsight.thecardealershipapi.DAO.LeaseContractDao;
import com.pluralsight.thecardealershipapi.LeaseContract;
import com.pluralsight.thecardealershipapi.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class LeaseContractController {
    private JdbcLeaseContractDao jdbcLeaseContractDao;

    @Autowired
   public LeaseContractController(JdbcLeaseContractDao jdbcLeaseContractDao){
        this.jdbcLeaseContractDao = jdbcLeaseContractDao;
    }
    @RequestMapping(path = "/leasecontract", method = RequestMethod.GET)
    public ArrayList<LeaseContract> getLeaseContract() {
        System.out.println("ALLLLLL");
        return  jdbcLeaseContractDao.getAll();
    }
    @RequestMapping(path = "/leasecontract/{id}", method = RequestMethod.GET)
    public LeaseContract getLeaseContractById(@PathVariable int id) {
        return jdbcLeaseContractDao.getById(id);
    }


    @RequestMapping(path = "/leasecontract/insert", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public LeaseContract insertLeaseContract(@RequestBody LeaseContract leaseContract) {
        return jdbcLeaseContractDao.insertLeaseContract(leaseContract);
    }

}
