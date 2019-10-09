/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connector.ProxyHandler;
import dto.ItemDTO;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import service.custom.ItemService;

/**
 *
 * @author sanuak
 */
public class ItemController {

    private ItemService proxy;

    public ItemController() throws RemoteException, Exception {
        proxy = (ItemService) ProxyHandler.getInstance().getProxy(ProxyHandler.ProxyTypes.ITEM);
    }

    public  boolean addItem(ItemDTO item) throws SQLException, ClassNotFoundException, Exception {
        return proxy.addItem(item);
    }

    public  boolean deleteItem(String code) throws ClassNotFoundException, SQLException, Exception {
        return proxy.deleteItem(code);
    }

    public  boolean updateItem(ItemDTO item) throws ClassNotFoundException, SQLException, Exception {
        return proxy.updateItem(item);
    }

    public  ItemDTO searchItem(String code) throws ClassNotFoundException, SQLException, Exception {
        return proxy.searchItem(code);
    }

    public  ArrayList<ItemDTO> getAllItems() throws ClassNotFoundException, SQLException, Exception {
        return proxy.getAllItems();
    }

}
