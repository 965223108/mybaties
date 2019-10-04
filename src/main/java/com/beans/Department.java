package com.beans;

import java.util.List;

public class Department {

    private Integer id;
    private String departmentName;
    private List<Department> EmployeeList;

    public List<Department> getDepartmentList() {
        return EmployeeList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.EmployeeList = departmentList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentList=" + EmployeeList +
                '}';
    }
}
