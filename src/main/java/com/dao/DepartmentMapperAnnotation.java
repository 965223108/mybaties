package com.dao;

import com.beans.Department;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapperAnnotation {

    @Select("select * from Department where id = #{id}")
    public Department getDepartmentById(Integer id);

}
