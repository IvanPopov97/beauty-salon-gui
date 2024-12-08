package ru.psu.beautysalongui.views;

import static com.vaadin.flow.theme.material.Material.DARK;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import ru.psu.beautysalongui.entities.Employee;
import ru.psu.beautysalongui.services.EmployeeService;

@Route("/employee")
public class EmployeeView extends VerticalLayout {

  public EmployeeView(EmployeeService employeeService, GridCrudFactory gridFactory) {
    setDarkTheme();
    add(gridFactory.create(Employee.class, employeeService, "id", "name", "position"));
    setSizeFull();
  }

  private void setDarkTheme() {
    UI.getCurrent().getElement().getThemeList().add(DARK);
  }
}
