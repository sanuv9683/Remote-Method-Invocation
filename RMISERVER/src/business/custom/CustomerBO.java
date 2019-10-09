/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom;

import business.SuperBO;
import dto.CustomerDTO;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public interface CustomerBO extends SuperBO{
    public boolean addCustomer(CustomerDTO dto)throws Exception;
    public boolean deleteCustomer(String id)throws Exception;
    public boolean updateCustomer(CustomerDTO dto)throws Exception;
    public CustomerDTO searchCustomer(String id)throws Exception;
    public ArrayList<CustomerDTO> getAllCustomers()throws Exception;
}
