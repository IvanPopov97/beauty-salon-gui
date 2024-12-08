package ru.psu.beautysalongui.views.admin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import ru.psu.beautysalongui.entities.Service;
import ru.psu.beautysalongui.services.ServiceService;
import ru.psu.beautysalongui.views.GridCrudFactory;
import ru.psu.beautysalongui.views.View;

@View
public class ServiceView extends VerticalLayout implements AdminTabView {

  public ServiceView(ServiceService service, GridCrudFactory gridFactory) {
    add(gridFactory.create(Service.class, service, "id", "name", "price"));
    setSizeFull();
  }

  @Override
  public int adminTabIndex() {
    return 1;
  }

  @Override
  public Component ref() {
    return this;
  }
}
