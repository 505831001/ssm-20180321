package com.liuweiwei.controller;

import com.liuweiwei.biz.DepartmentBiz;
import com.liuweiwei.biz.EmployeeBiz;
import com.liuweiwei.entity.Employee;
import com.liuweiwei.global.Contant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@Api("职员服务 Employee")
public class EmployeeController {
    private static ClassPathXmlApplicationContext ctx1;
    private static DepartmentBiz departmentBiz;
    private static EmployeeBiz employeeBiz;

    static {
        ctx1 = new ClassPathXmlApplicationContext("classpath:spring-biz.xml");
        departmentBiz = ctx1.getBean(DepartmentBiz.class);
        employeeBiz = ctx1.getBean(EmployeeBiz.class);
    }

    /*
    @Autowired
    private DepartmentBiz departmentBiz;
    @Autowired
    private EmployeeBiz employeeBiz;
    */
    @RequestMapping("/list")
    @ApiOperation(value = "职员列表信息", notes = "职员列表信息")
    public String list(Map<String, Object> map) {
        List<Employee> list = employeeBiz.getAll();
        System.out.println("EmployeeController print: " + list);
        map.put("list", list);
        return "employee_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map) {
        map.put("employee", new Employee());
        map.put("dlist", departmentBiz.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_add";
    }

    @RequestMapping("/add")
    public String add(Employee employee) {
        employeeBiz.add(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/to_update", params = "sn")
    public String toUpdate(String sn, Map<String, Object> map) {
        map.put("employee", employeeBiz.get(sn));
        map.put("dlist", departmentBiz.getAll());
        map.put("plist", Contant.getPosts());
        return "employee_update";
    }

    @RequestMapping("/update")
    public String update(Employee employee) {
        employeeBiz.edit(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove", params = "sn")
    public String remove(String sn) {
        employeeBiz.remove(sn);
        return "redirect:list";
    }

}
