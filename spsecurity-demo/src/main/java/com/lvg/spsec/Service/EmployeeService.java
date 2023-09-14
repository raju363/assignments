package com.lvg.spsec.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lvg.spsec.Entity.Employee;
import com.lvg.spsec.Repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired
EmployeeRepository  empRepository;
 
@Transactional(readOnly=true)
public List<Employee> getAllEmployees()
{
	return empRepository.findAll();
}
@Transactional(readOnly=true)
public Employee getEmployeeById(int employeeId)

{

	Optional<Employee> oe = empRepository.findById(employeeId);

	if(oe.isPresent()) return oe.get();

	return null;

}
@Transactional
 public boolean  insertorModify(Employee employee) {
	Employee e=empRepository.save(employee);
	return e!=null;
}
@Transactional
public boolean deleteByid(int employeeId) 
{
	long count= empRepository.count();
	empRepository.deleteById(employeeId);
	return  count> empRepository.count();
	
}

}
