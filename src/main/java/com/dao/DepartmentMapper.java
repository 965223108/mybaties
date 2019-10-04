package com.dao;

import com.beans.Department;
import com.beans.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DepartmentMapper {

    public Department getDepartmentById(Integer id);
    public Department getDepartmentWithEmployees(Integer id);
    public Map<String,Object> getDepartmentByMap(Integer id);
    @MapKey("departmentName")
    public Map<Integer, Employee> getDepartmentByReturnMap(Integer id);
    public void addDepartment(Department department);
    public void updateDepartment(Department  department);
    public void deleteDepartment(Integer id);
    public Department getDepartmentByIdAndDepartment(@Param("id") Integer id, @Param("departmentname") String departmentname);
    public List<Department> getDeparmentLike(@Param("likeparam") String str);

}
