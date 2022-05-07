package com.example.service;

import com.example.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final List<EmployeeModel> listOfEmployee = new ArrayList<>();

    public List<EmployeeModel> getListOfEmployee() {
        return listOfEmployee;
    }

    public void save(EmployeeModel employee) {
        String uId = UUID.randomUUID().toString();
        employee.setId(uId);
        listOfEmployee.add(employee);
    }

    public Optional<EmployeeModel> findById(String id) {
        return listOfEmployee.stream().filter(employeeModel -> employeeModel.getId().equals(id)).findFirst();
    }

    public void update(EmployeeModel employee) {
        for(EmployeeModel employeeModel : listOfEmployee){
            if(employeeModel.getId().equals(employee.getId())){
                employeeModel.setEmail(employee.getEmail());
                employeeModel.setName(employee.getName());
                employeeModel.setAddress(employee.getAddress());
                employeeModel.setPhone(employee.getPhone());
                break;
            }
        }
    }

    public void deleteById(String id) {
        listOfEmployee.removeIf(employeeModel -> employeeModel.getId().equals(id));
    }
}
