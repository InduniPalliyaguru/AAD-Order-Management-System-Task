package com.ijse.taskAAD.controller;

import com.ijse.taskAAD.constant.CommonResponse;
import com.ijse.taskAAD.dto.FilterOrderDTO;
import com.ijse.taskAAD.dto.PlaceOrderDTO;
import com.ijse.taskAAD.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ijse.taskAAD.constant.ResponseMessage.SUCCESS_MESSAGE;
import static com.ijse.taskAAD.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping(value = "v2/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse placeOrder(@RequestBody PlaceOrderDTO placeOrderDTO){
        orderService.placeOrder(placeOrderDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse filterOrders(
            @RequestParam(value = "name") String customerName) {
        List<FilterOrderDTO> filterOrderDTOS = orderService.filterOrders(customerName);
        return new CommonResponse(OPERATION_SUCCESS, filterOrderDTOS, SUCCESS_MESSAGE);
    }
}
