package com.ijse.taskAAD.service.impl;

import com.ijse.taskAAD.dto.CustomerDTO;
import com.ijse.taskAAD.entity.Customer;
import com.ijse.taskAAD.repository.CustomerRepository;
import com.ijse.taskAAD.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        log.info("Execute method saveCustomer");
        try {

            Customer customer = new Customer();
            customer.setName(customerDTO.getName());
            customer.setAddress(customer.getAddress());

            customerRepository.save(customer);

        } catch (Exception e) {
            log.error("Error occurred while saving customer: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        log.info("Execute method getAllCustomers");
        try {
            return List.of();
        } catch (Exception e) {
            log.error("Error occurred while retrieving customers: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public CustomerDTO getCustomerDetail(long id) {
        log.info("Execute method getCustomerDetail");
        try {
            return null;
        } catch (Exception e) {
            log.error("Error occurred while retrieving customer detail: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        log.info("Execute method updateCustomer");
        try {

        } catch (Exception e) {
            log.error("Error occurred while updating customer: " + e.getMessage());
            throw e;
        }
    }
}
