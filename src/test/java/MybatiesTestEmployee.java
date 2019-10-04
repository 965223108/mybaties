import com.beans.Department;
import com.beans.Employee;
import com.dao.DepartmentMapper;
import com.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class MybatiesTestEmployee {

    @Test
    public void  Test01() throws  Exception
    {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){

            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployeeById(1);
            //添加
            Employee employee1 = new Employee();
            employee1.setEmail("tesst@qq.com");
            employee1.setGender("1");
            employee1.setLastName("小小甜");
            employee1.setdId(3);
            boolean result = employeeMapper.addEmployee(employee1);
            System.out.println("添加用户结果：" + result + employee1);
            System.out.println(employee);
            sqlSession.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() throws Exception
    {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(resourceAsStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.getEmployeeById(1);
            System.out.println(employee);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test03() throws Exception
    {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(resourceAsStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DepartmentMapper employeeMapper = sqlSession.getMapper(DepartmentMapper.class);
            Department department = employeeMapper.getDepartmentWithEmployees(3);
            System.out.println(department.getDepartmentList());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
