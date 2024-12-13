package ru.psu.beautysalongui.views.director;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.psu.beautysalongui.entities.Employee;
import ru.psu.beautysalongui.services.EmployeeService;
import ru.psu.beautysalongui.views.GridCrudFactory;
import ru.psu.beautysalongui.views.WithDarkTheme;

@Route("/director")
public class DirectorMainView extends VerticalLayout implements WithDarkTheme {

  public DirectorMainView(EmployeeService employeeService, GridCrudFactory gridFactory) {
    setDarkTheme();
    add(gridFactory.create(Employee.class, employeeService, "id", "name", "position"));
    setSizeFull();
  }
}
