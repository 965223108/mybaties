package com.beans;

import java.util.List;

public interface EmployeeDynamic {

    public List<Employee> getEmployeeByConditionIF(Employee employee);
    public List<Employee> getEmployeeByConditionTrim(Employee employee);
    public List<Employee> getEmployeeByConditionChoose(Employee employee);
    public void updateEmployee(Employee employee);
}
