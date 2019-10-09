/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDAO;
import entity.Orders;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public class OrderDAOImpl implements OrderDAO {

    private Connection connection;

    @Override
    public boolean add(Orders entity) throws Exception {
        return CrudUtil.executeUpdate(connection, "insert into Orders values(?,?,?)", entity.getOid(), entity.getDate(), entity.getCustomerID());
    }

    @Override
    public boolean delete(String entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Orders entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
       this.connection=connection;
    }

}
