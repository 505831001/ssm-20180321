package com.liuweiwei.test;

import com.liuweiwei.biz.EmployeeBiz;
import com.liuweiwei.biz.impl.EmployeeBizImpl;
import com.liuweiwei.dao.DepartmentDao;
import com.liuweiwei.dao.EmployeeDao;
import com.liuweiwei.entity.Department;
import com.liuweiwei.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml"})
public class ConnectDBTest {
    private ClassPathXmlApplicationContext ctx1;
    private FileSystemXmlApplicationContext ctx2;
    @Test
    public void templateDBTest() {
        ctx1 = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
        System.out.println(ctx1);
        ctx2 = new FileSystemXmlApplicationContext("file:src/main/resources/spring-dao.xml");
        System.out.println(ctx2);
        String[] names = ctx1.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("IoC -> " + name);
        }
        int count = ctx1.getBeanDefinitionCount();
        System.out.println("IoC count -> " + count);
        EmployeeBizImpl bean = ctx1.getBean(EmployeeBizImpl.class);
        List<Employee> list = bean.getAll();
        System.out.println(list.toString());
    }
    @Test
    public void connectDBTest() throws IOException {
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(config);
        SqlSession session = factory.openSession();
        System.out.println("Link -> " + session);
        EmployeeDao mapper = session.getMapper(EmployeeDao.class);
        List<Employee> list = mapper.selectAll();
        System.out.println(list.toString());
        DepartmentDao mapper1 = session.getMapper(DepartmentDao.class);
        List<Department> list1 = mapper1.selectAll();
        System.out.println(list1.toString());
    }
}
