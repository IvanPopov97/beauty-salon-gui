package ru.psu.beautysalongui.views;

import static com.vaadin.flow.theme.material.Material.DARK;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ru.psu.beautysalongui.entities.Customer;
import ru.psu.beautysalongui.services.CustomerService;

@Route("/customer")
public class CustomerView extends VerticalLayout {

  private static final String[] ORDERED_FIELDS = new String[] {"id", "name", "phone", "email"};

  public CustomerView(CustomerService customerService, GridCrudFactory gridFactory) {
    setDarkTheme();
    add(gridFactory.create(Customer.class, customerService, ORDERED_FIELDS));
    setSizeFull();
  }

  private void setDarkTheme() {
    UI.getCurrent().getElement().getThemeList().add(DARK);
  }
}
