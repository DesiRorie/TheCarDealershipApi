package com.pluralsight.thecardealershipapi.DAO;

import com.pluralsight.thecardealershipapi.SalesContract;

import java.util.ArrayList;

public interface SalesContractDao  {
    ArrayList<SalesContract> getAll();
    SalesContract getById(int id);
    SalesContract insertSalesContract(SalesContract salesContract);

    void deleteSalesContract(int id);
}
