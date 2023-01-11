package com.pratik.www.employee.db.repository;

import com.pratik.www.employee.db.entity.EmployeeEntity;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEntityRepository extends CouchbaseRepository<EmployeeEntity,String> {
}
