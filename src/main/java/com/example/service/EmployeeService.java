package com.example.service;

import com.example.dao.DbManager;
import com.example.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    public List<EmployeeModel> getListOfEmployee() {
        return DbManager.findAll();
    }

    public void save(EmployeeModel employee) {
        int status = DbManager.save(employee);
        if (status == 0) {
            System.out.println("Unable to save data!");
        } else {
            System.out.println("Data save successful!");
        }
    }

    public Optional<EmployeeModel> findById(String id) {
        return Optional.ofNullable(DbManager.findById(id));
    }

    public void update(EmployeeModel employee) {
        int status = DbManager.update(employee);
        if (status == 0) {
            System.out.println("Failed to Update employee!");
        } else {
            System.out.println("Employee update successful!");
        }
    }

    public void deleteById(String id) {
       int status = DbManager.deleteById(id);
        if (status == 0) {
            System.out.println("Failed to delete employee!");
        } else {
            System.out.println("Employee delete successful!");
        }
    }
}
