package ru.psu.beautysalongui.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psu.beautysalongui.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {}
