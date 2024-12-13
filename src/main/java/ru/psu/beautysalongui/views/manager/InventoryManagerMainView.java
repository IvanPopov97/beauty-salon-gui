package ru.psu.beautysalongui.views.manager;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
import ru.psu.beautysalongui.entities.Product;
import ru.psu.beautysalongui.services.ProductService;
import ru.psu.beautysalongui.views.GridCrudFactory;
import ru.psu.beautysalongui.views.WithDarkTheme;

@Route("/inventory-manager")
public class InventoryManagerMainView extends VerticalLayout implements WithDarkTheme {

  public InventoryManagerMainView(ProductService productService, GridCrudFactory gridCrudFactory) {
    setDarkTheme();
    final GridCrud<Product> gridCrud =
        gridCrudFactory.create(Product.class, productService, "id", "name", "quantity", "price");
    add(gridCrud);
    setSizeFull();
  }
}
