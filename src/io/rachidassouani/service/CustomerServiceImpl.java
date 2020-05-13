package io.rachidassouani.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rachidassouani.dao.CustomerDao;
import io.rachidassouani.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao; 
	
	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customerDao.getCustomer(customerId);
	}

	@Override
	public void deleteCustomer(int customerId) {
		customerDao.deleteCustomer(customerId);
		
	}

}
