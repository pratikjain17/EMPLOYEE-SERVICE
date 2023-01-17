package com.pratik.www.employee.db.repository;

import com.pratik.www.employee.db.entity.EmployeeEntity;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
//@N1qlPrimaryIndexed
//@ViewIndexed(designDoc = "employee", viewName = "all")
public interface EmployeeEntityRepository extends CouchbaseRepository<EmployeeEntity,String> {
}
