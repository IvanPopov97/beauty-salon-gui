package ru.psu.beautysalongui.entities;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.SEQUENCE;

import jakarta.persistence.*;

import java.time.Instant;

import lombok.*;

@Entity
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Appointment {

  private static final String GENERATOR = "appointment_generator";

  @Id
  @GeneratedValue(strategy = SEQUENCE, generator = GENERATOR)
  @SequenceGenerator(
      name = GENERATOR,
      sequenceName = "appointments_appointment_id_seq",
      allocationSize = 1)
  @Column(name = "appointment_id")
  @EqualsAndHashCode.Include
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;

  @ManyToOne
  @JoinColumn(name = "service_id")
  private Service service;

  @Column(name = "appointment_date_time")
  private Instant time;

  @Enumerated(value = STRING)
  private Status status;

  public enum Status {
    PENDING,
    CANCELED,
    COMPLETED
  }
}
