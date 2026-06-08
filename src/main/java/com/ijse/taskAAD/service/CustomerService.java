package com.ijse.taskAAD.service;


import com.ijse.taskAAD.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerDetail(long id);
    void updateCustomer(CustomerDTO customerDTO);

}
