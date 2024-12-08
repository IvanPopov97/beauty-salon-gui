package ru.psu.beautysalongui.entities;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

  private static final String GENERATOR = "service_generator";

  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = GENERATOR)
  @SequenceGenerator(
      name = GENERATOR,
      sequenceName = "customers_customer_id_seq",
      allocationSize = 1)
  @Column(name = "customer_id")
  @EqualsAndHashCode.Include
  private Integer id;

  private String name;
  private String phone;
  private String email;

  @Override
  public String toString() {
    return name;
  }
}
