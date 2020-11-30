package com.dongnaoedu.mycat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dongnaoedu.mycat.model.Employee;
import com.dongnaoedu.mycat.service.EmployeeService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping
    public ModelAndView getAll(Employee employee) {
        ModelAndView result = new ModelAndView("index_employee");
        List<Employee> employeeList = employeeService.getAllByWeekend(employee);
        result.addObject("pageInfo", new PageInfo<Employee>(employeeList));
        result.addObject("queryParam", employee);
        result.addObject("page", employee.getPage());
        result.addObject("rows", employee.getRows());
        return result;
    }

    @RequestMapping(value = "/add")
    public ModelAndView add() {
        ModelAndView result = new ModelAndView("view_employee");
        result.addObject("employee", new Employee());
        return result;
    }

    @RequestMapping(value = "/view/{id}")
    public ModelAndView view(@PathVariable Integer id) {
        ModelAndView result = new ModelAndView("view_employee");
        Employee employee = employeeService.getById(id);
        employee.setIsNew("N");
        result.addObject("employee", employee);
        return result;
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id, RedirectAttributes ra) {
        ModelAndView result = new ModelAndView("redirect:/employee");
        employeeService.deleteById(id);
        ra.addFlashAttribute("msg", "删除成功!");
        return result;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save1(Employee employee) {
        ModelAndView result = new ModelAndView("view_employee");
        String msg = employee.getId() == null ? "新增成功!" : "更新成功!";
        employeeService.save(employee);
        result.addObject("employee", employee);
        result.addObject("msg", msg);
        return result;
    }
}
