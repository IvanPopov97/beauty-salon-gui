package ru.psu.beautysalongui.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psu.beautysalongui.entities.Service;

public interface ServiceRepo extends JpaRepository<Service, Integer> {}
