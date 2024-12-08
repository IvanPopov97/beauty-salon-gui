--liquibase formatted sql

--changeset valentin:add-employees-table
create table employees
(
    employee_id serial primary key,
    name        text not null unique,
    position    text not null
);

comment on table employees is 'Таблица работников';

/* liquibase rollback
 drop table employees;
 */