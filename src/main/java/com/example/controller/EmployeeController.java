package com.example.controller;

import com.example.model.EmployeeModel;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    public String getListOfEmployee(Model model) {
        List<EmployeeModel> employees = employeeService.getListOfEmployee();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping
    public String getEmployeeList(Model model) {
        return getListOfEmployee(model);
    }

    @GetMapping("/addEmployee")
    public String addNewEmployee(Model model) {
        EmployeeModel employeeModel = new EmployeeModel();
        model.addAttribute("actionType", "addEmployee");
        model.addAttribute("employee", employeeModel);
        return "employeeAddForm";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(Model model, @ModelAttribute("employee") EmployeeModel employeeModel) {
        employeeService.save(employeeModel);
        return getListOfEmployee(model);
    }

    @GetMapping("/viewEmployee")
    public String viewEmployeeById(@RequestParam("id") String id, Model model) {
        Optional<EmployeeModel> employee = employeeService.findById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
        } else {
            model.addAttribute("employee", new EmployeeModel());
        }
        model.addAttribute("actionType", "UpdateEmployee");
        return "employeeAddForm";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployeeById(Model model, @ModelAttribute("employee") EmployeeModel employeeModel) {
        employeeService.update(employeeModel);
        return getListOfEmployee(model);
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployeeById(@RequestParam("id") String id, Model model) {
        employeeService.deleteById(id);
        return getListOfEmployee(model);
    }
}
