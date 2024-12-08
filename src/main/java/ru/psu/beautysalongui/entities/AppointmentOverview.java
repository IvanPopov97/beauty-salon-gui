package ru.psu.beautysalongui.entities;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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

  private String customerName;
  private BigDecimal customerSpends;

  private String employeeName;

  private String serviceName;

  @Column(name = "appointment_date_time")
  private LocalDateTime time;

  @Enumerated(value = STRING)
  private Status status;

  public enum Status {
    PENDING,
    CANCELED,
    COMPLETED
  }
}
