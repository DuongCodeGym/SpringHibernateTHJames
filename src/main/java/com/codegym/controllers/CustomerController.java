package com.codegym.controllers;

import com.codegym.models.Customer;
import com.codegym.services.CustomerService;
import com.codegym.services.JPACustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping (value = "customer")
public class CustomerController {

    CustomerService customerService = new JPACustomerService();

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listAll(){
        List<Customer> customers = customerService.findAll();

        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ModelAndView details(@PathVariable Long id){
       Customer customer = customerService.findOne(id);

        ModelAndView modelAndView = new ModelAndView("/customer/info");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

}
