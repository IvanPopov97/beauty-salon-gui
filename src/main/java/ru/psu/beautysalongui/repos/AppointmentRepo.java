package ru.psu.beautysalongui.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psu.beautysalongui.entities.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {}
