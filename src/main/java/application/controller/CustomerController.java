package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.entity.Customer;
import application.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(value="/readAll", method=RequestMethod.GET)
	public Iterable<Customer> readAll() {
		return customerRepository.findAll();
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Customer create(@RequestParam("firstName") String firstName, @RequestParam("middleName") String middleName, 
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer customer = new Customer(0, firstName, middleName, lastName, email);
		customer = customerRepository.save(customer);
		return customer;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Customer update(@RequestParam("id") int id, @RequestParam("firstName") String firstName, 
			@RequestParam("middleName") String middleName, @RequestParam("lastName") String lastName, 
			@RequestParam("email") String email) {
		Customer customer = new Customer(id, firstName, middleName, lastName, email);
		customer = customerRepository.save(customer);
		return customer;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.DELETE)
	public Customer delete(@RequestParam("id") int id) {
		Customer customer = customerRepository.findById(id).get();
		customerRepository.deleteById(id);
		return customer;
	}
	
}
