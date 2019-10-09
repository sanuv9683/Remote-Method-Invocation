/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.custom;

import dto.ItemDTO;
import java.util.ArrayList;
import service.SuperService;

/**
 *
 * @author sanuak
 */
public interface ItemService extends SuperService{
    public boolean addItem(ItemDTO dto)throws Exception;
    public boolean deleteItem(String code)throws Exception;
    public ItemDTO searchItem(String code)throws Exception;
    public boolean updateItem(ItemDTO dto)throws Exception;
    public ArrayList<ItemDTO> getAllItems()throws Exception;
}
