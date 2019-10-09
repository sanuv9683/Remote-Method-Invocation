/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom.impl;

import business.custom.PurchaseOrderBO;
import dao.DAOFactory;
import dao.SuperDAO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailsDAO;
import db.DBConnection;
import dto.OrderDTO;
import dto.OrderDetailsDTO;
import entity.OrderDetail;
import entity.Orders;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    public PurchaseOrderBOImpl() {

    }

    @Override
    public boolean purchaseOrder(OrderDTO dto) throws Exception {
        OrderDAO orderDAO = (OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.ORDER);
        OrderDetailsDAO orderDetail = (OrderDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOFacTypes.ORDERDETAIL);
        try (Connection connection = DBConnection.getInstance().getConnection()) {
            connection.setAutoCommit(false);
            orderDAO.setConnection(connection);
            orderDetail.setConnection(connection);

            Orders orders = new Orders(dto.getOid(), dto.getDate(), dto.getCustomerID());
            if (orderDAO.add(orders)) {

                ArrayList<OrderDetailsDTO> orderDetails = dto.getOrderDetails();
                for (OrderDetailsDTO od : orderDetails) {
                    OrderDetail odd = new OrderDetail(od.getOid(), od.getItemCode(), od.getQty(), od.getUnitPrice());
                    if (!orderDetail.add(odd)) {
                        connection.rollback();
                        connection.setAutoCommit(true);
                        return false;
                    }
                }
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            } else {
                connection.rollback();
                connection.setAutoCommit(false);
                return false;
            }

        }
    }

}
