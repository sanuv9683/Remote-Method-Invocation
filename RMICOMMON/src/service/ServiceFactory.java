/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.rmi.Remote;

/**
 *
 * @author sanuak
 */
public interface ServiceFactory  extends Remote{
    public enum ServiceTypes{
    CUSTOMER,ITEM,PO
    }
    
    public SuperService getService(ServiceTypes types)throws Exception;
}
