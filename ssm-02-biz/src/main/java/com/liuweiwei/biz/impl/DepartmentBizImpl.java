package com.liuweiwei.biz.impl;

import com.liuweiwei.biz.DepartmentBiz;
import com.liuweiwei.dao.DepartmentDao;
import com.liuweiwei.dao.EmployeeDao;
import com.liuweiwei.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {
    private static ClassPathXmlApplicationContext ctx1;
    private static DepartmentDao departmentDao;
    static {
        ctx1 = new ClassPathXmlApplicationContext("classpath:spring-dao.xml");
        departmentDao = ctx1.getBean(DepartmentDao.class);
    }
    /*
    @Autowired
    private DepartmentDao departmentDao;
    */
    public void add(Department department) {
        departmentDao.insert(department);
    }
    public void edit(Department department) {
        departmentDao.update(department);
    }
    public void remove(String sn) {
        departmentDao.delete(sn);
    }
    public Department get(String sn) {
        return departmentDao.select(sn);
    }
    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
