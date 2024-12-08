--liquibase formatted sql

--changeset valentin:add-services-table
create table services
(
    service_id serial primary key,
    name       text not null unique,
    price      decimal(10, 2)  not null
);

comment on table services is 'Таблица услуг';

/* liquibase rollback
 drop table services;
 */