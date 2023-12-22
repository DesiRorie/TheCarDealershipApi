package com.pluralsight.thecardealershipapi.Controller;


import com.pluralsight.thecardealershipapi.DAO.JdbcSalesContractDao;
import com.pluralsight.thecardealershipapi.SalesContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SalesContractController {
    private JdbcSalesContractDao jdbcSalesContractDao;

    @Autowired
    public SalesContractController(JdbcSalesContractDao jdbcSalesContractDao) {
        this.jdbcSalesContractDao = jdbcSalesContractDao;
    }
    @RequestMapping(path = "/salescontract", method = RequestMethod.GET)
    public ArrayList<SalesContract> getSalesContract() {
        System.out.println("ALLLLLL");
        return  jdbcSalesContractDao.getAll();
    }

    @RequestMapping(path = "/salescontract/{id}", method = RequestMethod.GET)
    public SalesContract getSalesContractById(@PathVariable int id) {
        return jdbcSalesContractDao.getById(id);
    }
    @RequestMapping(path = "/salescontract/insert", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public SalesContract insertSalesContract(@RequestBody SalesContract salesContract) {
        return jdbcSalesContractDao.insertSalesContract(salesContract);
    }
}
