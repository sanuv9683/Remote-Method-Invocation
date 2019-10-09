/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation;

import java.rmi.Remote;

/**
 *
 * @author sanuak
 */
public interface Reservation extends Remote{
    public boolean reserved(Object key)throws Exception;
    public boolean released(Object key)throws Exception;
}
