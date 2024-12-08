--liquibase formatted sql

--changeset valentin:add-appointment-overview-view

create or replace view appointment_overview as
select appointment_id,
       customers.name as customer_name,
       coalesce(customer_spends.amount, 0) as customer_spends,
       employees.name as employee_name,
       services.name  as service_name,
       appointment_date_time,
       status
from appointments
         join customers using (customer_id)
         join employees using (employee_id)
         join services using (service_id)
         left join customer_spends using (customer_id);

/* liquibase rollback
 drop view appointment_overview;
 */