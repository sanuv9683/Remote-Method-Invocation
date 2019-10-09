/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.custom;

import business.SuperBO;
import dto.ItemDTO;
import java.util.ArrayList;

/**
 *
 * @author sanuak
 */
public interface ItemBO extends SuperBO{
    public boolean addItem(ItemDTO dto)throws Exception;
    public boolean deleteItem(String code)throws Exception;
    public boolean updateItem(ItemDTO dto)throws Exception;
    public ItemDTO searchItem(String code)throws Exception;
    public ArrayList<ItemDTO> getAllItem()throws Exception;
}
