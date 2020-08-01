package com.liuweiwei.test;

import com.liuweiwei.biz.DepartmentBiz;
import com.liuweiwei.biz.EmployeeBiz;
import com.liuweiwei.biz.impl.DepartmentBizImpl;
import com.liuweiwei.biz.impl.EmployeeBizImpl;
import com.liuweiwei.entity.Department;
import com.liuweiwei.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-dao.xml"})
public class EmployeeBizTest {

    @Autowired
    private EmployeeBiz employeeBiz;
    @Autowired
    private DepartmentBiz departmentBiz;

    @Test
    public void employeeBizTest() {
        List<Employee> list = employeeBiz.getAll();
        System.out.println(list.toString());

        List<Department> list1 = departmentBiz.getAll();
        System.out.println(list1.toString());
    }
}
