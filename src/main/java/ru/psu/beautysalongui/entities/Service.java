package ru.psu.beautysalongui.entities;

import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "services")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Service {

  private static final String GENERATOR = "service_generator";

  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = GENERATOR)
  @SequenceGenerator(name = GENERATOR, sequenceName = "services_service_id_seq", allocationSize = 1)
  @Column(name = "service_id")
  @EqualsAndHashCode.Include
  private Integer id;

  @NotBlank private String name;

  @NotNull
  @Min(1)
  private BigDecimal price;

  @Override
  public String toString() {
    return name;
  }
}
