package ru.psu.beautysalongui.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psu.beautysalongui.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {}
