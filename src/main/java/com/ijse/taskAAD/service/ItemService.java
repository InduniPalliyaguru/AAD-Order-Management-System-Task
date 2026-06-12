package com.ijse.taskAAD.service;

import com.ijse.taskAAD.dto.ItemDTO;
import com.ijse.taskAAD.entity.Item;

import java.util.List;

public interface ItemService {

    void saveItem(ItemDTO item);
    List<ItemDTO> getAllItems();
    ItemDTO getItemDetail(long id);
    void updateItem(ItemDTO itemDTO);

}
