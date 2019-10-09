/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connector.ProxyHandler;
import dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import service.custom.CustomerService;

/**
 *
 * @author sanuak
 */
public class CustomerController {

     private CustomerService service;

    public CustomerController() throws Exception {
        service = (CustomerService) ProxyHandler.getInstance().getProxy(ProxyHandler.ProxyTypes.CUSTOMER);
    }

    public  boolean addCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException, Exception {
        return service.addCustomer(customer);
    }

    public  boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        return service.deleteCustomer(id);
    }

    public  boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException, Exception {
        return service.updateCustomer(customer);
    }

    public  CustomerDTO searchCustomer(String id) throws ClassNotFoundException, SQLException, Exception {
        return service.searchCustomer(id);
    }

    public  ArrayList<CustomerDTO> getAllCustomers() throws ClassNotFoundException, SQLException, Exception {
        return service.getAllCustomers();
    }

}
