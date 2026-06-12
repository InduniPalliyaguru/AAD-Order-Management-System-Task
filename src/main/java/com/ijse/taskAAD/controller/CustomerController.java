package com.ijse.taskAAD.controller;

import com.ijse.taskAAD.constant.CommonResponse;
import com.ijse.taskAAD.dto.CustomerDTO;
import com.ijse.taskAAD.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ijse.taskAAD.constant.ResponseMessage.SUCCESS_MESSAGE;
import static com.ijse.taskAAD.constant.ResponseStatusCode.OPERATION_SUCCESS;

@RestController
@RequestMapping(value = "v2/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }

    @GetMapping (value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return new CommonResponse(OPERATION_SUCCESS, allCustomers, SUCCESS_MESSAGE);
    }

    @GetMapping (value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getCustomerDetail(@PathVariable long customerId) {
        CustomerDTO customerDetail = customerService.getCustomerDetail(customerId);
        return new CommonResponse(OPERATION_SUCCESS, customerDetail, SUCCESS_MESSAGE);
    }

    @PutMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return new CommonResponse(OPERATION_SUCCESS, SUCCESS_MESSAGE);
    }
}
