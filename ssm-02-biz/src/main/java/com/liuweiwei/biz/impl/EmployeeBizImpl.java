package com.liuweiwei.biz.impl;

import com.liuweiwei.biz.EmployeeBiz;
import com.liuweiwei.dao.EmployeeDao;
import com.liuweiwei.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeBizImpl implements EmployeeBiz {
    private static ClassPathXmlApplicationContext ctx1;
    private static EmployeeDao employeeDao;
    static {
        ctx1 = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
        employeeDao = ctx1.getBean(EmployeeDao.class);
    }
    /*
    @Autowired
    private EmployeeDao employeeDao;
    */
    public void add(Employee employee) {
        employee.setPassword("000000");
        employeeDao.insert(employee);
    }
    public void edit(Employee employee) {
        employeeDao.update(employee);
    }
    public void remove(String sn) {
        employeeDao.delete(sn);
    }
    public Employee get(String sn) {
        return employeeDao.select(sn);
    }
    public List<Employee> getAll() {
        List<Employee> list = employeeDao.selectAll();
        System.out.println("EmployeeBizImpl print: " + list);
        return list;
    }
}
