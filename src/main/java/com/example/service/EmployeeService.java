package com.example.service;

import com.example.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private List<EmployeeModel> listOfEmployee = new ArrayList<>();

    public List<EmployeeModel> getListOfEmployee() {
        return listOfEmployee;
    }

    public List<EmployeeModel> save(EmployeeModel employee) {
        String uId = UUID.randomUUID().toString();
        employee.setId(uId);
        listOfEmployee.add(employee);
        return listOfEmployee;
    }
}
