package com.ijse.taskAAD.service.impl;

import com.ijse.taskAAD.dto.FilterOrderDTO;
import com.ijse.taskAAD.dto.ItemDTO;
import com.ijse.taskAAD.dto.PlaceOrderDTO;
import com.ijse.taskAAD.entity.Customer;
import com.ijse.taskAAD.entity.Item;
import com.ijse.taskAAD.entity.Order;
import com.ijse.taskAAD.entity.OrderItem;
import com.ijse.taskAAD.repository.CustomerRepository;
import com.ijse.taskAAD.repository.ItemRepository;
import com.ijse.taskAAD.repository.OrderItemRepository;
import com.ijse.taskAAD.repository.OrderRepository;
import com.ijse.taskAAD.service.OrderService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    public OrderServiceImpl(OrderItemRepository orderItemRepository, CustomerRepository customerRepository, OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderItemRepository = orderItemRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void placeOrder(PlaceOrderDTO placeOrderDTO) {
        log.info("execute method place order");
        try {

            Order order = new Order();
            // set total
            order.setTotal(placeOrderDTO.getTotal());

            // check the customer before saving
            Optional<Customer> optionalCustomer = customerRepository.findById(placeOrderDTO.getCustomerId());
            if(!optionalCustomer.isPresent()){
                throw new RuntimeException("Customer not found");
            }

            Customer customer = optionalCustomer.get();
            order.setCustomer(customer);

            // save order
            Order savedOrder = orderRepository.save(order);

            // save order item
            // check the item before saving
            for (Long itemId : placeOrderDTO.getItemIdList()) {
                OrderItem orderItem = new OrderItem();

                Optional<Item> optionalItem = itemRepository.findById(itemId);
                if(!optionalItem.isPresent()){
                    throw new RuntimeException("OrderItem not found");
                }
                Item item = optionalItem.get();

                orderItem.setOrder(savedOrder);
                orderItem.setItem(item);

                orderItemRepository.save(orderItem);

            }

        } catch (Exception e) {
            log.error("error occurred while placing order", e);
            throw e;
        }
    }

    @Override
    public List<FilterOrderDTO> filterOrders(String customerName) {
        log.info("execute method filter order");
        try {

            List<FilterOrderDTO> filterrderDTOList = new ArrayList<>();
            List<Order> orderList = orderRepository.findByCustomerName(customerName);

            for (Order order : orderList) {

                FilterOrderDTO dto = new FilterOrderDTO();

                dto.setOrderId(order.getOrderId());
                dto.setCustomerName(order.getCustomer().getName());

                List<ItemDTO> itemDtoList  = new ArrayList<>();

                List<OrderItem> orderItemList = order.getOrderItemList();

                for (OrderItem orderItem : orderItemList) {

                    Item item = orderItem.getItem();

                    ItemDTO itemDTO = new ItemDTO();
                    itemDTO.setItemId(item.getItemId());
                    itemDTO.setName(item.getName());

                    itemDtoList.add(itemDTO);
                }
                dto.setItemList(itemDtoList);
                filterrderDTOList.add(dto);
            }
            return filterrderDTOList;

        } catch (Exception e) {
            log.error("error occurred while filter order", e);
            throw e;
        }
    }
}
