package ru.psu.beautysalongui.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import ru.psu.beautysalongui.entities.Customer;
import ru.psu.beautysalongui.repos.CustomerRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements CrudListener<Customer> {

    private final CustomerRepo customerRepo;

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public Customer add(Customer customer) {
        customer.setId(null);
        return customerRepo.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void delete(Customer customer) {
         customerRepo.delete(customer);
    }

}
