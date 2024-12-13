package ru.psu.beautysalongui.views.admin;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;
import ru.psu.beautysalongui.views.WithDarkTheme;

import java.util.List;

@Route("/admin")
@Slf4j
public class AdminMainView extends VerticalLayout implements WithDarkTheme {

  public AdminMainView(List<AdminTabView> tabViews) {
    setDarkTheme();
    add(new AdminTabSheet(tabViews));
    setSizeFull();
  }
}
