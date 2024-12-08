--liquibase formatted sql

--changeset valentin:add-customer-spends-view
create or replace view customer_spends as
select customer_id, sum(services.price) as amount
from customers
         join appointments using (customer_id)
         join services using (service_id)
where appointments.status = 'COMPLETED'
group by customer_id;

/* liquibase rollback
 drop view customer_spends;
 */