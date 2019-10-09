/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.OrderDetailsDAO;
import entity.OrderDetail;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    private Connection connection;

    @Override
    public boolean add(OrderDetail entity) throws Exception {
        return CrudUtil.executeUpdate(connection, "insert into OrderDetail values(?,?,?,?)", entity.getOid(), entity.getItemCode(), entity.getQty(),entity.getUnitPrice());
    }

    @Override
    public boolean delete(String entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetail search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

}
