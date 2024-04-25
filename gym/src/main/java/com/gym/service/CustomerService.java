package com.gym.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.gym.model.Customer;

@Service
public interface CustomerService {
	
	void saveCustomer(Customer cus);
	List<Customer> viewCustomer();
	void updateCustomer(Customer cus);
	void deleteCustomer(int cusId);
}


