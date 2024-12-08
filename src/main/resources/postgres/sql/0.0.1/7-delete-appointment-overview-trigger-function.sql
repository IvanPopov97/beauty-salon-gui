--liquibase formatted sql

--changeset valentin:delete-appointment-overview-function splitStatements:false

create or replace function delete_appointment_overview() returns trigger as
$$
begin
    delete from appointments where appointment_id = old.appointment_id;
    return old;
end;
$$ language plpgsql;

--changeset valentin:delete-appointment-overview-trigger splitStatements:false
create or replace trigger delete_this
    instead of delete
    on appointment_overview
    for each row
execute function delete_appointment_overview();

/* liquibase rollback
 drop trigger delete_this on appointment_overview;
 drop function delete_appointment_overview;
 */