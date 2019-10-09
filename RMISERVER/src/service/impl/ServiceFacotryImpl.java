/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import java.rmi.server.UnicastRemoteObject;
import service.ServiceFactory;
import service.SuperService;
import service.custom.impl.CustomerServiceImpl;
import service.custom.impl.ItemServiceImpl;
import service.custom.impl.POServiceImpl;

/**
 *
 * @author sanuak
 */
public class ServiceFacotryImpl extends UnicastRemoteObject implements ServiceFactory {

    private static ServiceFacotryImpl serviceFactory;

    private ServiceFacotryImpl()throws Exception{
    }

    public static ServiceFacotryImpl getInstace() throws Exception {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFacotryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceTypes types) throws Exception {
        switch (types) {
            case CUSTOMER:
                return new CustomerServiceImpl();
            case ITEM:
                return new ItemServiceImpl();
            case PO:
                return new POServiceImpl();
            default:
                return null;
        }
    }

}
