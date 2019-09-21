package application.repository;

import org.springframework.data.repository.CrudRepository;

import application.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
