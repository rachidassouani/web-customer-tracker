package io.rachidassouani.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.rachidassouani.entity.Customer;
import io.rachidassouani.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("list")
	public String listCustomers(Model model) {
		
		// getting list of customers
		List<Customer> customers = customerService.getCustomers();
		
		// adding it to the model
		model.addAttribute("customers", customers);
		
		return "list-customer";
	}
	
	@GetMapping("showFormAdd")
	public String showFormAdd(Model model) {
		
		// create model attribute to bind form data
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("saveCustomer")
	public String saveCustomer(Model model, @ModelAttribute("customer")Customer customer) {
		
		// save the customer using service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("showFormUpdate")
	public String showFormUpdate(@RequestParam("customerId") int customerId
			, Model model) {
		
		// get the customer from service
		Customer customer = customerService.getCustomer(customerId);
		
		// set customer as a model attribute 
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("delete")
	public String deleteCustomer(@RequestParam("customerId") int customerId
			,Model model) {
		
		// get the customer from service
		customerService.deleteCustomer(customerId);
		
		return "redirect:/customer/list";
	}
	
	
	
}
