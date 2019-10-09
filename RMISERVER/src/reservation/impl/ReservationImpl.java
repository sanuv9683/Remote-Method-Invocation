/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.impl;

import java.util.HashMap;

/**
 *
 * @author sanuak
 */
public class ReservationImpl<T> {

    static class ResMap<T> {

        T service;
        boolean isSelected;

        public ResMap(T service, boolean isSelected) {
            this.service = service;
            this.isSelected = isSelected;
        }
    }

    HashMap<Object, ResMap<T>> mapSomething = new HashMap<>();

    public boolean reserve(Object Key, T service, boolean isSelected) {
        if (mapSomething.containsKey(Key)) {
            return mapSomething.get(Key).service == service;
        } else {
            mapSomething.put(Key, new ResMap<>(service, isSelected));
            return true;
        }
    }

    public boolean released(Object Key, T service) {
        if (mapSomething.containsKey(Key) && mapSomething.get(Key).service == service) {
            mapSomething.remove(Key);
            return true;
        }
        return false;
    }

    public boolean checkState(String Key, T service) {
        if (mapSomething.containsKey(Key) && mapSomething.get(Key).service == service) {
            return mapSomething.get(Key).isSelected;
        }
        return false;
    }

}
