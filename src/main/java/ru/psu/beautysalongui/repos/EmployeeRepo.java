package ru.psu.beautysalongui.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psu.beautysalongui.entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {}
