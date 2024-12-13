package ru.psu.beautysalongui.views;

import com.vaadin.flow.component.UI;

import static com.vaadin.flow.theme.material.Material.DARK;

public interface WithDarkTheme {
  default void setDarkTheme() {
    UI.getCurrent().getElement().getThemeList().add(DARK);
  }
}
