/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom.impl;

import business.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import db.DBConnection;
import dto.ItemDTO;
import entity.Item;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public class ItemBOImpl implements ItemBO {

    @Override
    public boolean addItem(ItemDTO dto) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.ITEM);
            dao.setConnection(connection);
            return dao.add(new Item(dto.getCode(), dto.getDescription(), dto.getQtyOnHand(), dto.getUnitPrice()));
        }
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.ITEM);
            dao.setConnection(connection);
            return dao.delete(code);
        }
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.ITEM);
            dao.setConnection(connection);
            return dao.update(new Item(dto.getCode(), dto.getDescription(), dto.getQtyOnHand(), dto.getUnitPrice()));
        }
    }

    @Override
    public ItemDTO searchItem(String code) throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.ITEM);
            dao.setConnection(connection);
            Item search = dao.search(code);
            return new ItemDTO(search.getCode(), search.getDescription(), search.getQtyOnHand(), search.getUnitPrice());
        }
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws Exception {
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            ItemDAO dao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.ITEM);
            dao.setConnection(connection);
            ArrayList<Item> all = dao.getAll();
            ArrayList<ItemDTO> allCustomers = new ArrayList<>();
            for (Item search : all) {
                allCustomers.add(new ItemDTO(search.getCode(), search.getDescription(), search.getQtyOnHand(), search.getUnitPrice()));
            }
            return allCustomers;
        }
    }

}
