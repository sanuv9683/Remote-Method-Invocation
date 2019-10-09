/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import business.BOFactory;
import business.custom.PurchaseOrderBO;
import dto.OrderDTO;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observer;
import reservation.impl.ReservationImpl;
import service.custom.PurchaseOrderService;

/**
 *
 * @author sanuak
 */
public class POServiceImpl extends UnicastRemoteObject implements PurchaseOrderService {

    PurchaseOrderBO bo = (PurchaseOrderBO) BOFactory.getInstace().getBO(BOFactory.BOFactoryTypes.PO);
    private static ArrayList<Observer> allPoObsers = new ArrayList<>();
    private static ReservationImpl<PurchaseOrderService> poReservation = new ReservationImpl<>();

    public POServiceImpl() throws Exception {

    }

    @Override
    public void register(Observer ob) throws Exception {
        allPoObsers.add(ob);
    }

    @Override
    public void unregister(Observer ob) throws Exception {
        allPoObsers.remove(ob);
    }

    @Override
    public void notyfyAllObservers(String message) throws Exception {
        for (Observer allPoObser : allPoObsers) {
            new Thread(
                    new Runnable() {

                        @Override
                        public void run() {
                            try {
                                allPoObser.update(message);
                            } catch (Exception ex) {
                                Logger.getLogger(POServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
            ).start();
        }
    }

    @Override
    public boolean purchaseOrder(OrderDTO dto) throws Exception {
        notyfyAllObservers("Order ID " + dto.getOid() + " is Aded..!");
        if (poReservation.reserve(dto.getOid(), this, true)) {
            boolean purchaseOrder = bo.purchaseOrder(dto);
            if (purchaseOrder) {
                poReservation.released(ref, this);
                return true;
            }
        } else {
            throw new Exception("This order Id is Alredy Reserved");
        }
        return false;
    }

    @Override
    public boolean reserved(Object key) throws Exception {
        return poReservation.reserve(key, this, true);
    }

    @Override
    public boolean released(Object key) throws Exception {
        return poReservation.released(key, this);
    }

}
