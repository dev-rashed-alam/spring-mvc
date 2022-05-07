package com.example.controller;

import com.example.model.EmployeeModel;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String getEmployeeList(Model model) {
        List<EmployeeModel> employees = employeeService.getListOfEmployee();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/addEmployee")
    public String addNewEmployee(Model model) {
        EmployeeModel employeeModel = new EmployeeModel();
        model.addAttribute("employee", employeeModel);
        return "employeeAddForm";
    }

    @PostMapping ("/saveEmployee")
    public String saveEmployee(Model model, @ModelAttribute("employee") EmployeeModel employeeModel) {
        List<EmployeeModel> employees = employeeService.save(employeeModel);
        model.addAttribute("employees", employees);
        return "index";
    }


    @GetMapping("/deleteEmployee")
    public String deleteEmployeeById(Model model) {
        return "index";
    }
}
