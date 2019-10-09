/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom;

import business.SuperBO;
import dto.OrderDTO;

/**
 *
 * @author sanuak
 */
public interface PurchaseOrderBO extends SuperBO {
    public boolean purchaseOrder(OrderDTO dtos) throws Exception;
}
