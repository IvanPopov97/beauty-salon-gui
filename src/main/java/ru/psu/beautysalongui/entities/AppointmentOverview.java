package ru.psu.beautysalongui.entities;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "appointment_overview")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AppointmentOverview {

  private static final String GENERATOR = "appointment_generator";

  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = SEQUENCE, generator = GENERATOR)
  @SequenceGenerator(
      name = GENERATOR,
      sequenceName = "appointments_appointment_id_seq",
      allocationSize = 1)
  @Column(name = "appointment_id")
  private Integer id;

  @NotBlank private String customerName;
  private BigDecimal customerSpends;

  @NotBlank private String employeeName;

  @NotBlank private String serviceName;

  @NotNull
  @Column(name = "appointment_date_time")
  private LocalDateTime time;

  @NotNull
  @Enumerated(value = STRING)
  private Status status;

  public enum Status {
    PENDING,
    CANCELED,
    COMPLETED
  }
}
