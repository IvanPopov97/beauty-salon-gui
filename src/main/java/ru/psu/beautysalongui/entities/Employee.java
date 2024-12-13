package ru.psu.beautysalongui.entities;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

  private static final String GENERATOR = "employee_generator";

  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = GENERATOR)
  @SequenceGenerator(
      name = GENERATOR,
      sequenceName = "employees_employee_id_seq",
      allocationSize = 1)
  @Column(name = "employee_id")
  @EqualsAndHashCode.Include
  private Integer id;

  @NotBlank private String name;
  @NotBlank private String position;

  @Override
  public String toString() {
    return name;
  }
}
