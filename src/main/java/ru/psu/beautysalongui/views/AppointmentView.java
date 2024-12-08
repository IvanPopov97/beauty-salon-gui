package ru.psu.beautysalongui.views;

import static com.vaadin.flow.theme.material.Material.DARK;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LocalDateTimeRenderer;
import com.vaadin.flow.router.Route;
import org.vaadin.crudui.crud.impl.GridCrud;
import ru.psu.beautysalongui.entities.AppointmentOverview;
import ru.psu.beautysalongui.services.AppointmentOverviewService;

@Route("/appointment")
public class AppointmentView extends VerticalLayout {

  private static final String TIME_COLUMN = "time";
  private static final String TIME_FORMAT = "dd.MM.yyyy HH:mm";
  private static final String[] ORDERED_FIELDS =
      new String[] {
        "id", "customerName", "customerSpends", "employeeName", "serviceName", TIME_COLUMN, "status"
      };
  private static final String[] NOT_EDITABLE_FIELDS = new String[] {"id", "customerSpends"};

  public AppointmentView(
      AppointmentOverviewService overviewService, GridCrudFactory gridCrudFactory) {
    setDarkTheme();
    final GridCrud<AppointmentOverview> gridCrud =
        gridCrudFactory.create(
            AppointmentOverview.class, overviewService, ORDERED_FIELDS, NOT_EDITABLE_FIELDS);
    gridCrud
        .getGrid()
        .getColumnByKey(TIME_COLUMN)
        .setRenderer(new LocalDateTimeRenderer<>(AppointmentOverview::getTime, TIME_FORMAT));
    add(gridCrud);
    setSizeFull();
  }

  private void setDarkTheme() {
    UI.getCurrent().getElement().getThemeList().add(DARK);
  }
}
