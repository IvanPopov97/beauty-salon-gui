package ru.psu.beautysalongui.views;

import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.textfield.EmailField;
import org.springframework.stereotype.Component;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.form.CrudFormFactory;
import org.vaadin.crudui.form.impl.form.factory.DefaultCrudFormFactory;

import java.util.*;

import static com.vaadin.flow.dom.Style.Overflow.HIDDEN;
import static java.lang.System.arraycopy;
import static java.util.Arrays.stream;
import static java.util.Comparator.comparingInt;
import static java.util.function.Function.identity;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.range;

@Component
public class GridCrudFactory {
  private static final String TIME_FIELD = "time";
  private static final String EMAIL_FIELD = "email";
  private static final String BORDER_RADIUS = "1em";

  public <T> GridCrud<T> create(
      Class<T> type, CrudListener<T> crudListener, String... orderedFields) {
    final CrudFormFactory<T> formFactory = createFormFactory(type, orderedFields);
    final GridCrud<T> gridCrud = new GridCrud<>(type, formFactory);
    return customizeGrid(gridCrud, crudListener, orderedFields);
  }

  public <T> GridCrud<T> create(
      Class<T> type,
      CrudListener<T> crudListener,
      String[] orderedFields,
      String[] notEditableFields) {
    final CrudFormFactory<T> formFactory =
        createFormFactory(type, orderedFields, remove(orderedFields, notEditableFields));
    final GridCrud<T> gridCrud = new GridCrud<>(type, formFactory);
    return customizeGrid(gridCrud, crudListener, orderedFields);
  }

  private <T> GridCrud<T> customizeGrid(
      GridCrud<T> crud, CrudListener<T> crudListener, String[] orderedFields) {
    Grid<T> grid = crud.getGrid();
    crud.getGrid().getStyle().setBorderRadius(BORDER_RADIUS).setOverflow(HIDDEN);
    setColumnOrder(grid, orderedFields);
    crud.setCrudListener(crudListener);
    return crud;
  }

  private String[] remove(String[] from, String[] what) {
    final Set<String> deletable = stream(what).collect(toSet());
    return stream(from).filter(not(deletable::contains)).toArray(String[]::new);
  }

  private String[] removeFirst(String[] orderedFields) {
    final String[] withoutFirst = new String[orderedFields.length - 1];
    arraycopy(orderedFields, 1, withoutFirst, 0, withoutFirst.length);
    return withoutFirst;
  }

  private <T> CrudFormFactory<T> createFormFactory(Class<T> type, String[] orderedFields) {
    return createFormFactory(type, orderedFields, removeFirst(orderedFields));
  }

  private <T> CrudFormFactory<T> createFormFactory(
      Class<T> type, String[] orderedFields, String[] editableFields) {
    final CrudFormFactory<T> crudFormFactory = new DefaultCrudFormFactory<>(type);
    crudFormFactory.setVisibleProperties(editableFields);
    crudFormFactory.setVisibleProperties(CrudOperation.DELETE, orderedFields);
    crudFormFactory.setFieldType(TIME_FIELD, DateTimePicker.class);
    crudFormFactory.setFieldType(EMAIL_FIELD, EmailField.class);
    return crudFormFactory;
  }

  private <T> void setColumnOrder(Grid<T> grid, String[] orderedFields) {
    final Map<String, Integer> fieldPositions =
        range(0, orderedFields.length)
            .boxed()
            .collect(toMap(num -> orderedFields[num], identity()));
    final List<Grid.Column<T>> orderedColumns =
        grid.getColumns().stream()
            .sorted(comparingInt(column -> fieldPositions.get(column.getKey())))
            .toList();
    grid.setColumnOrder(orderedColumns);
  }
}
