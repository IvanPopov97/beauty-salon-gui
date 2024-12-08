package ru.psu.beautysalongui.views.admin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.TabSheet;
import ru.psu.beautysalongui.views.VaadinTabView;

import java.util.List;
import java.util.Map;

import static com.vaadin.flow.component.tabs.TabSheetVariant.LUMO_TABS_EQUAL_WIDTH_TABS;
import static com.vaadin.flow.component.tabs.TabVariant.LUMO_ICON_ON_TOP;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.range;

public class AdminTabSheet extends TabSheet {

  public AdminTabSheet(List<AdminTabView> tabViews) {
    Map<Integer, Component> indexedViews =
        tabViews.stream().collect(toMap(AdminTabView::adminTabIndex, VaadinTabView::ref));
    add(new Tab(VaadinIcon.USERS.create(), new Span("Клиенты")), indexedViews.get(0));
    add(new Tab(VaadinIcon.DIAMOND_O.create(), new Span("Услуги")), indexedViews.get(1));
    add(new Tab(VaadinIcon.CALENDAR_CLOCK.create(), new Span("Бронирование")), indexedViews.get(2));
    range(0, getTabCount()).forEach(num -> getTabAt(num).addThemeVariants(LUMO_ICON_ON_TOP));
    addThemeVariants(LUMO_TABS_EQUAL_WIDTH_TABS);
    setSizeFull();
  }
}
