package com.happyhour.test;

import java.util.Date;
import java.util.List;

import com.happyhour.dao.CustomerDAO;
import com.happyhour.model.Customer;

public class App {

	public static void main(String[] args) {

		//ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");

		Customer customer = new Customer();
		customer.setAddress("A");
		customer.setCreatedDate(new Date());
		customer.setEmail("m");
		customer.setPassword("abc");
		customer.setPhoneNum(123);
		customer.setPincode(234);
		customer.setUserId("Mohit1");
		customer.setUserName("Mohit");

	//	customerDAO.insertCustomer(customer);

	//	List<Customer> list = customerDAO.getCustomers();

		//System.out.println("Batch inserted :" + list.size());

		//context.close();
	}
}