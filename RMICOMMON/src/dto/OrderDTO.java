/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public class OrderDTO implements Serializable{

    private String oid;
    private String date;
    private String customerID;
    private ArrayList<OrderDetailsDTO> orderDetails;

    public OrderDTO() {
    }

    public OrderDTO(String oid, String date, String customerID, ArrayList<OrderDetailsDTO> orderDetails) {
        this.oid = oid;
        this.date = date;
        this.customerID = customerID;
        this.orderDetails = orderDetails;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public ArrayList<OrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

}
