import com.beans.Employee;
import com.beans.EmployeeDynamic;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class mybatiesDynamic {

    @Test
    public void test_if() throws  Exception
    {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        try(SqlSession sqlSession= sqlSessionFactory.openSession())
        {
            EmployeeDynamic sqlSessionMapper = sqlSession.getMapper(EmployeeDynamic.class);
            Employee employee = new Employee();
            //employee.setId(1);
            employee.setEmail("965");
            System.out.println(employee);
           // List<Employee> employees = sqlSessionMapper.getEmployeeByConditionIF(employee);
           // List<Employee> employees = sqlSessionMapper.getEmployeeByConditionTrim(employee);
            List<Employee> employees = sqlSessionMapper.getEmployeeByConditionChoose(employee);
            System.out.println(employees);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    @Test
    public void test_02() throws  Exception
    {
        InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        try(SqlSession sqlSession= sqlSessionFactory.openSession())
        {
            EmployeeDynamic sqlSessionMapper = sqlSession.getMapper(EmployeeDynamic.class);
            Employee employee = new Employee();
            employee.setId(18);
            employee.setLastName("rjc");
            employee.setEmail("rangjiancheng@qq.com");
            System.out.println(employee);
            sqlSessionMapper.updateEmployee(employee);
            sqlSession.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
