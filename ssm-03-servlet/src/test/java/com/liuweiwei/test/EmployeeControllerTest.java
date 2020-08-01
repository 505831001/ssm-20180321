package com.liuweiwei.test;

import com.liuweiwei.controller.EmployeeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-web.xml"})
public class EmployeeControllerTest {
    @Autowired
    private EmployeeController employeeController;
    @Test
    public void webTest() {
        Map<String, Object> map = new HashMap<>();
        String list = employeeController.list(map);
        System.out.println(list);
    }
}
