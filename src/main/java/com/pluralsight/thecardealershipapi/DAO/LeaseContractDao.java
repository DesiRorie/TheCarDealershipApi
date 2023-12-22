package com.pluralsight.thecardealershipapi.DAO;

import com.pluralsight.thecardealershipapi.LeaseContract;
import com.pluralsight.thecardealershipapi.SalesContract;

import java.util.ArrayList;

public interface LeaseContractDao {
    ArrayList<LeaseContract> getAll();
    LeaseContract getById(int id);
    LeaseContract insertLeaseContract(LeaseContract leaseContract);

    void deleteLeaseContract(int id);
}
