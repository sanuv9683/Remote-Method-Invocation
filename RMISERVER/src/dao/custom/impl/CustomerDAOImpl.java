/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CustomerDAO;
import entity.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public class CustomerDAOImpl implements CustomerDAO {

    private Connection connection;

    @Override
    public boolean add(Customer entity) throws Exception {
        return CrudUtil.executeUpdate(connection, "Insert into Customer values(?,?,?,?)", entity.getId(), entity.getName(), entity.getAddress(), entity.getSalary());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate(connection, "delete from Customer where id=?", id);
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return CrudUtil.executeUpdate(connection, "update Customer set name=?,address=?,salary=? where id=?", entity.getName(), entity.getAddress(), entity.getSalary(), entity.getId());
    }

    @Override
    public Customer search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery(connection, "select * from Customer where id=?", id);
        Customer cus = null;
        while (rst.next()) {
            cus = new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4));
        }
        return cus;
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery(connection, "select * from Customer");
        ArrayList<Customer> allCustomers = new ArrayList<>();
        while (rst.next()) {
            allCustomers.add(new Customer(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4)));
        }
        return allCustomers;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

}
