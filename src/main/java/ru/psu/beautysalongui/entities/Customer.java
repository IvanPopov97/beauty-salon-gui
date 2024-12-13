package ru.psu.beautysalongui.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

  private static final String GENERATOR = "customer_generator";

  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = GENERATOR)
  @SequenceGenerator(
      name = GENERATOR,
      sequenceName = "customers_customer_id_seq",
      allocationSize = 1)
  @Column(name = "customer_id")
  @EqualsAndHashCode.Include
  private Integer id;

  @NotBlank private String name;

  @NotBlank
  @Pattern(message = "{constraints.Phone.message}", regexp = "^(\\+7|8)\\d{10}$")
  private String phone;

  @NotBlank @Email private String email;

  @Override
  public String toString() {
    return name;
  }
}
