package ru.psu.beautysalongui.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import ru.psu.beautysalongui.entities.Appointment;
import ru.psu.beautysalongui.repos.AppointmentRepo;

@Service
@RequiredArgsConstructor
public class AppointmentService implements CrudListener<Appointment> {

    private final AppointmentRepo appointmentRepo;

    @Override
    public List<Appointment> findAll() {
        return appointmentRepo.findAll();
    }

    @Override
    public Appointment add(Appointment appointment) {
        appointment.setId(null);
        return appointmentRepo.save(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @Override
    public void delete(Appointment appointment) {
         appointmentRepo.delete(appointment);
    }

}
