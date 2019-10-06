package com.beans;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDynamic {

    public List<Employee> getEmployeeByConditionIF(Employee employee);
    public List<Employee> getEmployeeByConditionTrim(Employee employee);
    public List<Employee> getEmployeeByConditionChoose(Employee employee);
    public void updateEmployee(Employee employee);
    public List<Employee> getEmployeeByListId(@Param("ids") List<Integer> ids);
    public void addEmployees(@Param("emps") List<Employee> employeeList);
}
