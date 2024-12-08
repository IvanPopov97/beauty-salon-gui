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

create or replace function delete_appointment_overview() returns trigger as
$$
begin
    delete from appointments where appointment_id = old.appointment_id;
    return old;
end;
$$ language plpgsql;

create or replace trigger update_appointment_overview
    instead of insert or update
    on appointment_overview
    for each row
execute function update_appointment_overview();

create or replace trigger delete_appointment_overview
    instead of delete
    on appointment_overview
    for each row
execute function delete_appointment_overview();

-- update appointments app
-- set customer_id           = 777,
--     employee_id           = 666,
--     service_id            = 555,
--     appointment_date_time = now(),
--     status                = 'status'
-- where appointment_id = 999;
--
-- do
-- $$
--     declare
--         customer_id integer;
--     begin
--         customer_id = (select customers.customer_id from customers where name = 'Иван Попов' limit 1);
--         if customer_id is null then
--             raise exception '% customer not found', 'Иван Попов';
--         end if;
--         --select customer_id;
--     end;
-- $$;

-- CREATE FUNCTION emp_stamp() RETURNS trigger AS
-- $emp_stamp$
-- BEGIN
--     -- Check that empname and salary are given
--     IF NEW.empname IS NULL THEN
--         RAISE EXCEPTION 'empname cannot be null';
--     END IF;
--     IF NEW.salary IS NULL THEN
--         RAISE EXCEPTION '% cannot have null salary', NEW.empname;
--     END IF;
--
--     -- Who works for us when they must pay for it?
--     IF NEW.salary < 0 THEN
--         RAISE EXCEPTION '% cannot have a negative salary', NEW.empname;
--     END IF;
--
--     -- Remember who changed the payroll when
--     NEW.last_date := current_timestamp;
--     NEW.last_user := current_user;
--     RETURN NEW;
-- END;
-- $emp_stamp$ LANGUAGE plpgsql;