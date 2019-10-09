/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom.impl;

import business.BOFactory;
import business.custom.ItemBO;
import dto.ItemDTO;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.Observer;
import reservation.impl.ReservationImpl;
import service.custom.ItemService;

/**
 *
 * @author sanuak
 */
public class ItemServiceImpl extends UnicastRemoteObject implements ItemService {

    private static ArrayList<Observer> itemObservers = new ArrayList<>();
    private static ReservationImpl<ItemService> itemReserve = new ReservationImpl<>();
     private ItemBO itemBO=   (ItemBO) BOFactory.getInstace().getBO(BOFactory.BOFactoryTypes.ITEM);
    
    public ItemServiceImpl() throws Exception {
      
    }

    @Override
    public void register(Observer ob) throws Exception {
        itemObservers.add(ob);
    }

    @Override
    public void unregister(Observer ob) throws Exception {
        itemObservers.remove(ob);
    }

    @Override
    public void notyfyAllObservers(String message) throws Exception {
        for (Observer itemObserver : itemObservers) {
            new Thread(
                    new Runnable() {

                @Override
                public void run() {
                    try {
                        itemObserver.update(message);
                    } catch (Exception ex) {
                        Logger.getLogger(ItemServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            ).start();
        }
    }

    @Override
    public boolean addItem(ItemDTO dto) throws Exception {
        notyfyAllObservers("New Item Aded For Database");
       return itemBO.addItem(dto);
    }

    @Override
    public boolean deleteItem(String code) throws Exception {
         return itemBO.deleteItem(code);
    }

    @Override
    public ItemDTO searchItem(String code) throws Exception {
     return itemBO.searchItem(code);
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        return itemBO.updateItem(dto);
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws Exception {
        return itemBO.getAllItem();
    }

    @Override
    public boolean reserved(Object key) throws Exception {
     return   itemReserve.released(key, this);
    }

    @Override
    public boolean released(Object key) throws Exception {
     return   itemReserve.released(key, this);
    }

}
