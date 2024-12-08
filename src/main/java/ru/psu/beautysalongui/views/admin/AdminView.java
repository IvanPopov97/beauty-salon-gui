package ru.psu.beautysalongui.views.admin;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.vaadin.flow.theme.material.Material.DARK;

@Route("/admin")
@Slf4j
public class AdminView extends VerticalLayout {

  public AdminView(List<AdminTabView> tabViews) {
    setDarkTheme();
    add(new AdminTabSheet(tabViews));
    setSizeFull();
  }

  private void setDarkTheme() {
    UI.getCurrent().getElement().getThemeList().add(DARK);
  }
}
