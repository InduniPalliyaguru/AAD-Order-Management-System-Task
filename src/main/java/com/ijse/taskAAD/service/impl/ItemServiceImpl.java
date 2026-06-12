package com.ijse.taskAAD.service.impl;

import com.ijse.taskAAD.dto.ItemDTO;
import com.ijse.taskAAD.entity.Item;
import com.ijse.taskAAD.repository.ItemRepository;
import com.ijse.taskAAD.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void saveItem(ItemDTO item) {
        log.info("Execute Method saveItem");
        try {

            Item item1 = new Item();
            item1.setName(item.getName());
            item1.setPrice(item.getPrice());

            itemRepository.save(item1);

        } catch (Exception e) {
            log.error("Error in saveItem: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        log.info("Execute Method getAllItems");
        try {

            List<ItemDTO> itemDTOList = new ArrayList<>();
            List<Item> itemList = itemRepository.findAll();

            for (Item item : itemList) {
                ItemDTO itemDTO = new ItemDTO();
                itemDTO.setItemId(item.getItemId());
                itemDTO.setName(item.getName());
                itemDTO.setPrice(item.getPrice());

                itemDTOList.add(itemDTO);
            }
            return itemDTOList;

        } catch (Exception e) {
            log.error("Error in getAllItems: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public ItemDTO getItemDetail(long id) {
        log.info("Execute Method getItemDetail");
        try {

            Optional<Item> itemOptional = itemRepository.findById(id);
            if (!itemOptional.isPresent()) {
                throw new RuntimeException("Item not found");
            }
            Item item = itemOptional.get();
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemId(item.getItemId());
            itemDTO.setName(item.getName());
            itemDTO.setPrice(item.getPrice());

            return itemDTO;

        } catch (Exception e) {
            log.error("Error in getItemDetail: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        log.info("Execute Method updateItem");
        try {

            Optional<Item> itemOptional = itemRepository.findById(itemDTO.getItemId());
            if (!itemOptional.isPresent()) {
                throw new RuntimeException("Item not found");
            }
            Item item = itemOptional.get();
            item.setName(itemDTO.getName());
            item.setPrice(item.getPrice());

            itemRepository.save(item);

        }  catch (Exception e) {
            log.error("Error in updateItem: {}", e.getMessage());
            throw e;
        }
    }
}
