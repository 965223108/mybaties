import com.beans.Department;
import com.beans.Employee;
import com.dao.DepartmentMapper;
import com.dao.DepartmentMapperAnnotation;
import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class MybatiesTest {

    //调用SQLsession中的增删改查方法操作数据库
    @Test
    public void test01() throws Exception
    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            Employee employee = sqlSession.selectOne("org.mybatis.example.employee.selectEmployee",1);
            System.out.println(employee);
        }finally {
            sqlSession.close();
        }
    }
    /* 接口与SQL配置文件绑定的方式
       把与SQL配置文件绑定的接口传给SQLSession，并获取到接口的实现实例，mybaties会自动为接口创建一个代理对象（将接口和SQL配置文件绑定在一起）
       调用接口中的方法完成增删改查操作
       SQLSession代表和数据库的一次会话，用完需要及时关闭
       SQLSession和connection一样都是非线程安全的，不能当做公共资源，每次使用都应该去获取新的对象
       两个重要的配置文件：
        mybaties全局配置文件 ：包含数据库连接池信息，事务管理信息，运行环境信息等
        SQL映射文件：将SQL语句抽取出来
     */
    @Test
    public void test02() throws Exception
    {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department department = mapper.getDepartmentById(1);
            System.out.println(department);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void test03() throws Exception
    {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()){
            DepartmentMapperAnnotation mapper = sqlSession.getMapper(DepartmentMapperAnnotation.class);
            Department department = mapper.getDepartmentById(5);
            System.out.println(department);
        }
    }

    @Test
    public void test_zsgc() throws Exception
    {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //sqlSessionFactory.openSession(true)  自动提交 不需要手动提交
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            Department department = new Department();
            department.setDepartmentName("架构部");
            departmentMapper.addDepartment(department);
            System.out.print(department);
            //department.setId(3);
            //departmentMapper.updateDepartment(department);
           // departmentMapper.deleteDepartment(8);
            sqlSession.commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Test
    public void test04() throws Exception
    {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            Department department = departmentMapper.getDepartmentByIdAndDepartment(1, "开发部");
            System.out.print(department);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void test05() throws Exception
    {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            List<Department> lists = departmentMapper.getDeparmentLike("%部%");
            for (Department d:lists) {
                System.out.println(d);
            }
            Map<String, Object> departmentByMap = departmentMapper.getDepartmentByMap(1);
            System.out.println(departmentByMap);
            Map<Integer, Employee> map = departmentMapper.getDepartmentByReturnMap(1);
            System.out.println(map);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
