package ru.psu.beautysalongui.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import ru.psu.beautysalongui.entities.Employee;
import ru.psu.beautysalongui.repos.EmployeeRepo;

@Service
@RequiredArgsConstructor
public class EmployeeService implements CrudListener<Employee> {

    private final EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee add(Employee employee) {
        employee.setId(null);
        return employeeRepo.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void delete(Employee employee) {
         employeeRepo.delete(employee);
    }

}
