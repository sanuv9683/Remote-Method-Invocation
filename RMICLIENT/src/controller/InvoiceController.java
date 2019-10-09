/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connector.ProxyHandler;
import dto.OrderDTO;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import service.SuperService;
import service.custom.ItemService;
import service.custom.PurchaseOrderService;

/**
 *
 * @author sanuak
 */
public class InvoiceController {

    private PurchaseOrderService proxy;

    public InvoiceController() throws RemoteException, Exception {
        proxy = (PurchaseOrderService) ProxyHandler.getInstance().getProxy(ProxyHandler.ProxyTypes.PO);

    }

    public  boolean purchaseOrder(OrderDTO dto) throws ClassNotFoundException, SQLException, Exception {
        return proxy.purchaseOrder(dto);
    }

}
