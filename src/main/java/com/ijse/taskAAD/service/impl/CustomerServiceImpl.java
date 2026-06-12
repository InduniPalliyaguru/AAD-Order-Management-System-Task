package com.ijse.taskAAD.service.impl;

import com.ijse.taskAAD.dto.CustomerDTO;
import com.ijse.taskAAD.entity.Customer;
import com.ijse.taskAAD.repository.CustomerRepository;
import com.ijse.taskAAD.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            log.error("Error occurred while saving customer: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        log.info("Execute method getAllCustomers");
        try {

            List<CustomerDTO> customerList = new ArrayList<>();
            List<Customer> customers = customerRepository.findAll();

            for (Customer customer : customers) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setCustomerId(customer.getCustomerId());
                customerDTO.setName(customer.getName());
                customerDTO.setAddress(customer.getAddress());

                customerList.add(customerDTO);
            }
            return customerList;

        } catch (Exception e) {
            log.error("Error occurred while retrieving customers: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public CustomerDTO getCustomerDetail(long id) {
        log.info("Execute method getCustomerDetail");
        try {

            Optional<Customer> customerOptional = customerRepository.findById(id);

            if (!customerOptional.isPresent()) {
                log.error("Customer with id {} does not exist", id);
            }
            Customer  customer = customerOptional.get();
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerId(customer.getCustomerId());
            customerDTO.setName(customer.getName());
            customerDTO.setAddress(customer.getAddress());
            return customerDTO;

        } catch (Exception e) {
            log.error("Error occurred while retrieving customer detail: {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        log.info("Execute method updateCustomer");
        try {

            Optional<Customer> customerOptional = customerRepository.findById(customerDTO.getCustomerId());
            if (!customerOptional.isPresent()) {
                log.error("Customer with id {} does not exist", customerDTO.getCustomerId());
            }
            Customer customer = customerOptional.get();
            customer.setName(customerDTO.getName());
            customer.setAddress(customerDTO.getAddress());
            customerRepository.save(customer);

        } catch (Exception e) {
            log.error("Error occurred while updating customer: {}", e.getMessage());
            throw e;
        }
    }
}
