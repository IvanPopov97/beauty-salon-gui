package ru.psu.beautysalongui.entities;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.*;
import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

  private static final String GENERATOR = "product_generator";

  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = GENERATOR)
  @SequenceGenerator(
      name = GENERATOR,
      sequenceName = "inventory_product_id_seq",
      allocationSize = 1)
  @Column(name = "product_id")
  @EqualsAndHashCode.Include
  private Integer id;

  @NotBlank private String name;

  @Min(0)
  private int quantity;

  @NotNull
  @Min(1)
  private BigDecimal price;

  @Override
  public String toString() {
    return name;
  }
}
