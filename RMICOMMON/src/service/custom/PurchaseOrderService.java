/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom;

import dto.OrderDTO;
import service.SuperService;

/**
 *
 * @author sanuak
 */
public interface PurchaseOrderService extends SuperService {

    public boolean purchaseOrder(OrderDTO dto) throws Exception;
}
