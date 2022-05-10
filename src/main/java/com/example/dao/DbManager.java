package com.example.dao;

import com.example.model.EmployeeModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "");

        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }

    public static int save(EmployeeModel employeeModel) {
        int status = 0;
        try {
            Connection con = DbManager.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into employee(name, email, address, phone) values (?,?,?,?)");
            ps.setString(1, employeeModel.getName());
            ps.setString(2, employeeModel.getEmail());
            ps.setString(3, employeeModel.getAddress());
            ps.setString(4, employeeModel.getPhone());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static List<EmployeeModel> findAll() {
        List<EmployeeModel> employeeList = new ArrayList<>();
        try {
            Connection con = DbManager.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EmployeeModel schema = new EmployeeModel();
                schema.setId(rs.getString("id"));
                schema.setName(rs.getString("name"));
                schema.setEmail(rs.getString("email"));
                schema.setAddress(rs.getString("address"));
                schema.setPhone(rs.getString("phone"));
                employeeList.add(schema);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeList;
    }

    public static EmployeeModel findById(String id) {
        EmployeeModel employeeModel = new EmployeeModel();
        try {
            Connection con = DbManager.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from employee where id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employeeModel.setId(rs.getString("id"));
                employeeModel.setName(rs.getString("name"));
                employeeModel.setEmail(rs.getString("email"));
                employeeModel.setAddress(rs.getString("address"));
                employeeModel.setPhone(rs.getString("phone"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return employeeModel;
    }

    public static int update(EmployeeModel employeeModel) {
        int status = 0;
        try {
            Connection con = DbManager.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "update employee set name = ?, email = ?, address = ?, phone = ? where id = ?");
            ps.setString(1, employeeModel.getName());
            ps.setString(2, employeeModel.getEmail());
            ps.setString(3, employeeModel.getAddress());
            ps.setString(4, employeeModel.getPhone());
            ps.setInt(5, Integer.parseInt(employeeModel.getId()));

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }


    public static int deleteById(String id) {
        int status = 0;
        try {
            Connection con = DbManager.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "delete from employee where id = ?");
            ps.setInt(1, Integer.parseInt(id));

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

}
