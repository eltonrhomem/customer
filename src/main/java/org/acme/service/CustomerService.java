package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;
import org.acme.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public List<CustomerDTO> findAllCustomers() {
        List<CustomerDTO> customers = new ArrayList<>();

        customerRepository.findAll().stream().forEach(item-> {
            customers.add(mapCustomerEntityToDTO(item));
        });

        return customers;
    }

    public void createNewCustomer(CustomerDTO customerDTO) {
        customerRepository.persist(mapCustomerDTOtoEntity(customerDTO));
    }

    public void changeCustomer(Long id, CustomerDTO customerDTO) {
        CustomerEntity customer = customerRepository.findById(id);
        customer.setName(customer.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setPhone(customerDTO.getPhone());
        customer.setEmail(customerDTO.getEmail());
        customer.setAge(customerDTO.getAge());

        customerRepository.persist(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerEntity mapCustomerDTOtoEntity(CustomerDTO customer) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setAddress(customer.getAddress());
        customerEntity.setAge(customer.getAge());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setName(customer.getName());
        customerEntity.setPhone(customer.getPhone());

        return  customerEntity;
    }

    private CustomerDTO mapCustomerEntityToDTO(CustomerEntity customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setAddress(customer.getAddress());
        customerDTO.setAge(customer.getAge());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setName(customer.getName());
        customerDTO.setPhone(customer.getPhone());

        return  customerDTO;
    }
}
