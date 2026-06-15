package com.ijse.taskAAD.service;


import com.ijse.taskAAD.dto.CustomerDTO;
import com.ijse.taskAAD.dto.FilterOrderDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerDetail(long id);
    void updateCustomer(CustomerDTO customerDTO);
    List<FilterOrderDTO>  getFilterOrders(long customerId);

}
