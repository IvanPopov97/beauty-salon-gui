--liquibase formatted sql

--changeset valentin:add-appointments-table
create table appointments
(
    appointment_id        serial primary key,
    customer_id           integer   not null references customers,
    employee_id           integer   not null references employees,
    service_id            integer   not null references services,
    appointment_date_time timestamp not null,
    status                text      not null
);

comment on table appointments is 'Таблица бронирований';

/* liquibase rollback
 drop table appointments;
 */
