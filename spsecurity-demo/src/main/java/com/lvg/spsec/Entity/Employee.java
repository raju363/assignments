package com.lvg.spsec.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
@Id
@Column(name="emp_id")
private int employeeId;
@Column(name="emp_name")
private String employeeName;
@Column(name="emp_sal")
 private String salary;
private  int deptno;
public Employee() {   
}
public Employee(int employeeId, String employeeName, String salary, int deptno) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.salary = salary;
	this.deptno = deptno;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getSalary() {
	return salary;
}
public void setSalary(String salary) {
	this.salary = salary;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}

}
