/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import business.BOFactory;
import business.custom.CustomerBO;
import dto.CustomerDTO;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observer;
import reservation.impl.ReservationImpl;
import service.custom.CustomerService;

/**
 *
 * @author sanuak
 */
public class CustomerServiceImpl extends UnicastRemoteObject implements CustomerService {

    public CustomerServiceImpl() throws Exception {
    }

    CustomerBO bo = (CustomerBO) BOFactory.getInstace().getBO(BOFactory.BOFactoryTypes.CUSTOMER);
    public static ArrayList<Observer> customerObservers = new ArrayList<>();
    private static ReservationImpl<CustomerService> cusReservation = new ReservationImpl();

    @Override
    public boolean addCustomer(CustomerDTO dto) throws Exception {
        return bo.addCustomer(dto);

    }

    @Override
    public boolean deleteCustomer(String id) throws Exception {
        return bo.deleteCustomer(id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return bo.updateCustomer(dto);
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws Exception {
        if (cusReservation.reserve(id, this, true)) {
            return bo.searchCustomer(id);
        } else {
            throw new NullPointerException("Customer Alredy Reserved.. try Laiter");
        }
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        notyfyAllObservers("Customer Get All Is Called");
        return bo.getAllCustomers();
    }

    @Override
    public void register(Observer ob) throws Exception {
        this.customerObservers.add(ob);
    }

    @Override
    public void unregister(Observer ob) throws Exception {
        this.customerObservers.remove(ob);
    }

    @Override
    public void notyfyAllObservers(String message) throws Exception {
        for (Observer ob : customerObservers) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ob.update(message);
                    } catch (Exception ex) {
                        Logger.getLogger(CustomerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();
        }
    }

    @Override
    public boolean reserved(Object key) throws Exception {
        return cusReservation.reserve(key, this, true);
    }

    @Override
    public boolean released(Object key) throws Exception {
        return cusReservation.released(key, this);
    }

}
