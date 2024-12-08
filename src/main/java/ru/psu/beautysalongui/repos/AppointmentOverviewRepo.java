package ru.psu.beautysalongui.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psu.beautysalongui.entities.AppointmentOverview;

public interface AppointmentOverviewRepo extends JpaRepository<AppointmentOverview, Integer> {}
