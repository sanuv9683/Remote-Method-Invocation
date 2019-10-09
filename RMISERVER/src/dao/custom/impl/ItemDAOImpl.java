/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.ItemDAO;
import entity.Customer;
import entity.Item;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public class ItemDAOImpl implements ItemDAO {

    private Connection connection;

    @Override
    public boolean add(Item entity) throws Exception {
        return CrudUtil.executeUpdate(connection, "Insert into Item values(?,?,?,?)", entity.getCode(), entity.getDescription(), entity.getQtyOnHand(), entity.getUnitPrice());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate(connection, "delete from Item where code=?", id);
    }

    @Override
    public boolean update(Item entity) throws Exception {
        return CrudUtil.executeUpdate(connection, "update Item set description=?,qtyOnHand=?,unitPrice=? where code=?", entity.getDescription(), entity.getQtyOnHand(), entity.getUnitPrice(), entity.getCode());
    }

    @Override
    public Item search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery(connection, "select * from Item where code=?", id);
        Item item = null;
        while (rst.next()) {
            item = new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4));
        }
        return item;
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery(connection, "select * from Item");
        ArrayList<Item> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getDouble(4)));
        }
        return allItems;
    }

    @Override
    public void setConnection(Connection connection) throws Exception {
        this.connection = connection;
    }

}
