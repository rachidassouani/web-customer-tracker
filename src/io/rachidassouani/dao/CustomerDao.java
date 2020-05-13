package io.rachidassouani.dao;

import java.util.List;

import io.rachidassouani.entity.Customer;

public interface CustomerDao {
	
	List<Customer> getCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(int customerId);

	void deleteCustomer(int customerId);

}
