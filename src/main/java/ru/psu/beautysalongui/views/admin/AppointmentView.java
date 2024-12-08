package ru.psu.beautysalongui.views.admin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LocalDateTimeRenderer;
import org.vaadin.crudui.crud.impl.GridCrud;
import ru.psu.beautysalongui.entities.AppointmentOverview;
import ru.psu.beautysalongui.services.AppointmentOverviewService;
import ru.psu.beautysalongui.views.GridCrudFactory;
import ru.psu.beautysalongui.views.View;

@View
public class AppointmentView extends VerticalLayout implements AdminTabView {

  private static final String TIME_COLUMN = "time";
  private static final String TIME_FORMAT = "dd.MM.yyyy HH:mm";
  private static final String[] ORDERED_FIELDS =
      new String[] {
        "id", "customerName", "customerSpends", "employeeName", "serviceName", TIME_COLUMN, "status"
      };
  private static final String[] NOT_EDITABLE_FIELDS = new String[] {"id", "customerSpends"};

  public AppointmentView(
      AppointmentOverviewService overviewService, GridCrudFactory gridCrudFactory) {
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

  @Override
  public int adminTabIndex() {
    return 2;
  }

  @Override
  public Component ref() {
    return this;
  }
}
