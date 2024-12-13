package ru.psu.beautysalongui.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.vaadin.crudui.crud.CrudListener;
import ru.psu.beautysalongui.entities.Product;
import ru.psu.beautysalongui.repos.ProductRepo;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ProductService implements CrudListener<Product> {

  private final ProductRepo productRepo;

  @Override
  public List<Product> findAll() {
    return productRepo.findAll();
  }

  @Override
  public Product add(Product product) {
    product.setId(null);
    return productRepo.save(product);
  }

  @Override
  public Product update(Product product) {
    return productRepo.save(product);
  }

  @Override
  public void delete(Product product) {
    productRepo.delete(product);
  }
}
