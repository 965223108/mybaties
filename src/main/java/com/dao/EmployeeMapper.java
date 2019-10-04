package com.dao;

import com.beans.Employee;

import java.io.InputStream;

public interface EmployeeMapper {

    public Employee getEmployeeById(Integer id);
    public boolean addEmployee(Employee employee);
    public int updateEmployee(Employee employee);
    public boolean deleteEmployee(Integer id);
}
