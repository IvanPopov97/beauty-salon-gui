package ru.psu.beautysalongui.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import ru.psu.beautysalongui.entities.AppointmentOverview;
import ru.psu.beautysalongui.repos.AppointmentOverviewRepo;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AppointmentOverviewService implements CrudListener<AppointmentOverview> {

    private final AppointmentOverviewRepo overviewRepo;

    @Override
    public Collection<AppointmentOverview> findAll() {
        return overviewRepo.findAll();
    }

    @Override
    public AppointmentOverview add(AppointmentOverview appointmentOverview) {
        appointmentOverview.setId(null);
        return overviewRepo.save(appointmentOverview);
    }

    @Override
    public AppointmentOverview update(AppointmentOverview appointmentOverview) {
        return overviewRepo.save(appointmentOverview);
    }

    @Override
    public void delete(AppointmentOverview appointmentOverview) {
        overviewRepo.delete(appointmentOverview);
    }

}
