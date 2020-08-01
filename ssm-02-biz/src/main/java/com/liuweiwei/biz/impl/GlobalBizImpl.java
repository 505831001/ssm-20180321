package com.liuweiwei.biz.impl;

import com.liuweiwei.biz.GlobalBiz;
import com.liuweiwei.dao.EmployeeDao;
import com.liuweiwei.entity.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("globalBiz")
public class GlobalBizImpl implements GlobalBiz {
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
    public Employee login(String sn, String password) {
        Employee employee = employeeDao.select(sn);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
