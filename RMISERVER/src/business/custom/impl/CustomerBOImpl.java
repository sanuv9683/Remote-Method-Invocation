/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom.impl;

import business.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import db.DBConnection;
import dto.CustomerDTO;
import entity.Customer;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public class CustomerBOImpl implements CustomerBO {

    @Override
    public boolean addCustomer(CustomerDTO dto) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.CUSTOMER);
            dao.setConnection(connection);
            return dao.add(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary()));
        }
    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.CUSTOMER);
            dao.setConnection(connection);
            return dao.delete(id);
        }
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.CUSTOMER);
            dao.setConnection(connection);
            return dao.update(new Customer(dto.getId(), dto.getName(), dto.getAddress(), dto.getSalary()));
        }
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.CUSTOMER);
            dao.setConnection(connection);
            Customer search = dao.search(id);
            return new CustomerDTO(search.getId(), search.getName(), search.getAddress(), search.getSalary());
        }
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            CustomerDAO dao = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.CUSTOMER);
            dao.setConnection(connection);
            ArrayList<Customer> all = dao.getAll();
            ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
            for (Customer search : all) {
                allCustomers.add(new CustomerDTO(search.getId(), search.getName(), search.getAddress(), search.getSalary()));
            }
            return allCustomers;
        }
    }

}
