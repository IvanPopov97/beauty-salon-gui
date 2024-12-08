--liquibase formatted sql

--changeset valentin:update-appointment-overview-function splitStatements:false

create or replace function update_appointment_overview() returns trigger as
$$
declare
    new_customer_id integer;
    new_employee_id integer;
    new_service_id  integer;
begin
    new_customer_id = (select customer_id from customers where name = new.customer_name limit 1);
    if new_customer_id is null then
        raise exception '% customer not found', new.customer_name;
    end if;
    new_employee_id = (select employee_id from employees where name = new.employee_name limit 1);
    if new_employee_id is null then
        raise exception '% employee not found', new.employee_name;
    end if;
    new_service_id = (select service_id from services where name = new.service_name limit 1);
    if new_service_id is null then
        raise exception '% service not found', new.service_name;
    end if;
    if tg_op = 'INSERT' then
        insert into appointments
        values (new.appointment_id, new_customer_id, new_employee_id, new_service_id, new.appointment_date_time,
                new.status);
    elsif tg_op = 'UPDATE' then
        update appointments
        set customer_id           = new_customer_id,
            employee_id           = new_employee_id,
            service_id            = new_service_id,
            appointment_date_time = new.appointment_date_time,
            status                = new.status
        where appointment_id = new.appointment_id;
    end if;
    return new;
end;
$$ language plpgsql;

--changeset valentin:update-appointment-overview-trigger splitStatements:false
create or replace trigger update_this
    instead of insert or update
    on appointment_overview
    for each row
execute function update_appointment_overview();

/* liquibase rollback
 drop trigger update_this on appointment_overview;
 drop function update_appointment_overview;
 */