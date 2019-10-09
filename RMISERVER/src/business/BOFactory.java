/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.custom.impl.CustomerBOImpl;
import business.custom.impl.ItemBOImpl;
import business.custom.impl.PurchaseOrderBOImpl;

/**
 *
 * @author sanuak
 */
public class BOFactory {

    public static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstace() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOFactoryTypes {

        CUSTOMER, ITEM, PO;
    }

    public SuperBO getBO(BOFactoryTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PO:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }

}
