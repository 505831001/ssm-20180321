package com.liuweiwei.biz;

import com.liuweiwei.entity.Employee;

public interface GlobalBiz {
    Employee login(String sn, String password);
    void changePassword(Employee employee);
}
