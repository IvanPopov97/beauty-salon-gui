--liquibase formatted sql

--changeset valentin:add-inventory-table
create table inventory
(
    product_id serial primary key,
    name       text           not null,
    quantity   integer        not null,
    price      decimal(10, 2) not null
);

comment on table inventory is 'Таблица с инвентарём';

/* liquibase rollback
 drop table inventory;
 */
