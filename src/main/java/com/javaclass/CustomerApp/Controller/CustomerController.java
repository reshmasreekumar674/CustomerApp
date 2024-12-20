package com.javaclass.CustomerApp.Controller;


import com.javaclass.CustomerApp.Entity.Customer;
import com.javaclass.CustomerApp.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
   public CustomerService customerService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }


    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.addCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @GetMapping("/all")
    public ResponseEntity <List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomer();
         return ResponseEntity.ok(customers);
    }
    @PatchMapping("{id}/name")
    public ResponseEntity<Customer> updateName(@PathVariable Integer id, @RequestBody String name){
       Customer updatedCustomer = customerService.updateName(id,name);
       return ResponseEntity.ok(updatedCustomer);
    }

    @PatchMapping("{id}/email")
    public ResponseEntity<Customer> updateEmail(@RequestParam Integer id, String email){
        Customer updatedCustomer = customerService.updateEmail(id, email);
        return ResponseEntity.ok(updatedCustomer);
    }

    @PatchMapping("{id}/phone")
    public ResponseEntity<Customer> updateMobileNumber (@RequestBody Integer id, String phone){
       Customer updatedCustomer = customerService.updateMobileNumber(id, phone);
       return ResponseEntity.ok(updatedCustomer);
    }
}
