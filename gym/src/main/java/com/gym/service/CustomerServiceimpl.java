package com.gym.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gym.model.Customer;
import com.gym.repos.CustomerRepository;
import jakarta.transaction.Transactional;

@Service
public class CustomerServiceimpl implements CustomerService{

	@Autowired
	private CustomerRepository customerrepo;
	
	@Override
	public void saveCustomer(Customer cus) {

		customerrepo.save(cus);
	}

	@Override
	public List<Customer> viewCustomer() {
		return customerrepo.findAll();
		
	}
	
	@Transactional
	@Override
	public void deleteCustomer(int cusId) {
	    customerrepo.deleteById(cusId);
	}

	@Override
	public void updateCustomer(Customer cus) {
		customerrepo.save(cus);
		
	}
	
}
