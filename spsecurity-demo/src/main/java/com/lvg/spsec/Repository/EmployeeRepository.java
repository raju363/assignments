package com.lvg.spsec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lvg.spsec.Entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer>
{

}
