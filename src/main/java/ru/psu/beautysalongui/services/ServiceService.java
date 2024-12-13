package ru.psu.beautysalongui.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.vaadin.crudui.crud.CrudListener;
import ru.psu.beautysalongui.entities.Service;
import ru.psu.beautysalongui.repos.ServiceRepo;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService implements CrudListener<Service> {

    private final ServiceRepo serviceRepo;

    @Override
    public List<Service> findAll() {
        return serviceRepo.findAll();
    }

    @Override
    public Service add(Service service) {
        service.setId(null);
        return serviceRepo.save(service);
    }

    @Override
    public Service update(Service service) {
        return serviceRepo.save(service);
    }

    @Override
    public void delete(Service service) {
         serviceRepo.delete(service);
    }

}
