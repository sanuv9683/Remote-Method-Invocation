/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connector;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import service.ServiceFactory;
import service.SuperService;
import service.custom.CustomerService;
import service.custom.ItemService;
import service.custom.PurchaseOrderService;

/**
 *
 * @author sanuak
 */
public class ProxyHandler {

    private static ProxyHandler ph;
    private CustomerService customerService;
    private ItemService itemService;
    private PurchaseOrderService poService;

    private ProxyHandler() throws NotBoundException, MalformedURLException, RemoteException, Exception {
        ServiceFactory serviceProxy = (ServiceFactory) Naming.lookup("rmi://localhost:5050/ijse");
        itemService = (ItemService) serviceProxy.getService(ServiceFactory.ServiceTypes.ITEM);
        customerService = (CustomerService) serviceProxy.getService(ServiceFactory.ServiceTypes.CUSTOMER);
        poService = (PurchaseOrderService) serviceProxy.getService(ServiceFactory.ServiceTypes.PO);
    }

    public static ProxyHandler getInstance() throws MalformedURLException, RemoteException, Exception {
        if (ph == null) {
            ph = new ProxyHandler();
        }
        return ph;
    }

    public enum ProxyTypes {

        CUSTOMER, ITEM, PO;
    }

    public SuperService getProxy(ProxyTypes types) {
        switch (types) {
            case CUSTOMER:
                return customerService;
            case ITEM:
                return itemService;
            case PO:
                return poService;
            default:
                return null;
        }
    }
    
    
    

}
