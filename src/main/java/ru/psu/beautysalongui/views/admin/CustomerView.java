package ru.psu.beautysalongui.views.admin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import ru.psu.beautysalongui.entities.Customer;
import ru.psu.beautysalongui.services.CustomerService;
import ru.psu.beautysalongui.views.GridCrudFactory;
import ru.psu.beautysalongui.views.View;

@View
public class CustomerView extends VerticalLayout implements AdminTabView {

  private static final String[] ORDERED_FIELDS = new String[] {"id", "name", "phone", "email"};

  public CustomerView(CustomerService customerService, GridCrudFactory gridFactory) {
    add(gridFactory.create(Customer.class, customerService, ORDERED_FIELDS));
    setSizeFull();
  }

  @Override
  public int adminTabIndex() {
    return 0;
  }

  @Override
  public Component ref() {
    return this;
  }
}
