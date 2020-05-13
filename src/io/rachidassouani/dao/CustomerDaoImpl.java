package io.rachidassouani.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.rachidassouani.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session session= sessionFactory.getCurrentSession();
		
		// create a query & sort by last name!
		Query<Customer> query = session.createQuery("FROM Customer ORDER BY lastName",
				Customer.class);
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		
		// return the results
		return customers;
	}


	@Override
	public void saveCustomer(Customer customer) {
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// save the customer
		session.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int customerId) {

		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve/read from database
		Customer customer = session.get(Customer.class, customerId);		
				
		return customer;
	}


	@Override
	public void deleteCustomer(int customerId) {

		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// get customer object
		Customer customer = getCustomer(customerId);
		
		// delete it 
		session.delete(customer);
		
	}
}
