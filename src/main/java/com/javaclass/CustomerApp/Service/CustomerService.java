package com.javaclass.CustomerApp.Service;

import com.javaclass.CustomerApp.Entity.Customer;
import com.javaclass.CustomerApp.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    public CustomerRepo customerRepo;

    public Customer addCustomer(Customer customer){
        return customerRepo.save(customer);
    }
    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }
    public Customer updateName(Integer customerId, String newName){
        Customer customer = getCustomerById(customerId);
         customer.setName(newName);
         return customerRepo.save(customer);
    }

    public Customer updateEmail(Integer customerId, String newEmail){
        Customer customer = getCustomerById(customerId);
        customer.setEmail(newEmail);
        return  customerRepo.save(customer);
    }

    public Customer updateMobileNumber(Integer id, String newNumber){
        Customer customer= getCustomerById(id);
        customer.setMobileNumber(newNumber);
        return  customerRepo.save(customer);
    }

    public Customer getCustomerById(Integer customerId){
        return customerRepo.findById(customerId)
                .orElseThrow(()->new RuntimeException("Customer not found with ID: " +customerId));
    }
}
