package com.clarlove.controller;

import com.clarlove.dao.DepartmentDao;
import com.clarlove.dao.EmployeeDao;
import com.clarlove.pojo.Department;
import com.clarlove.pojo.Employee;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author promise
 * @date 2024/3/9 - 15:27
 */
@Controller
public class EmployeeController {

  @Autowired
  private EmployeeDao employeeDao;

  @Autowired
  private DepartmentDao departmentDao;

  // 查询所有员工
  @RequestMapping("/emps")
  public String list(Model model) {
    Collection<Employee> employees =  employeeDao.getAll();
    model.addAttribute("emps", employees);
    return "emp/list";
  }

  @GetMapping("/emp")
  public String toAddPage(Model model) {
    // 查出所有部门的信息
    Collection<Department> departments =  departmentDao.getDepartments();
    model.addAttribute("departments", departments);
    return "emp/add";
  }


  @PostMapping("/emp")
  public String addEmp(Employee employee, Model model) {
    // 新增员工
    employeeDao.save(employee);
    return "redirect:/emps";
  }


  @GetMapping("/emp/{id}")
  public String toUpdatePage(@PathVariable("id") Integer id, Model model) {
    Employee employee = employeeDao.getEmployeeById(id);
    model.addAttribute("emp", employee);
    // 查出所有部门的信息
    Collection<Department> departments =  departmentDao.getDepartments();
    model.addAttribute("departments", departments);
    return "emp/update";
  }


  @PostMapping("/updateEmp")
  public String updateEmp(Employee employee, Model model) {
    // 新增员工
    employeeDao.save(employee);
    return "redirect:/emps";
  }

  @GetMapping("/delEmp/{id}")
  public String deleteEmp(@PathVariable("id") Integer id, Model model) {
    employeeDao.delete(id);
    return "redirect:/emps";
  }
}
