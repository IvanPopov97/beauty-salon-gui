--liquibase formatted sql

--changeset valentin:add-customers-table
create table customers
(
    customer_id serial
        primary key,
    name        text not null,
    phone       text not null
        unique,
    email       text not null
        unique
);

comment on table customers is 'Таблица клиентов';

/* liquibase rollback
 drop table customers;
 */