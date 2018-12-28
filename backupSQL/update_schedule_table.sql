USE behaviour;

-- Column name was a keyword therefore name is changed.
ALTER TABLE scheduled CHANGE scheduled.date sch_date DATETIME;

-- Data type and column name were wrong in the creation script.
ALTER TABLE scheduled CHANGE scheduled.condition event_condition Boolean;

-- Inserting into the versioning tables.
INSERT INTO schema_changes VALUES (1,1,1,'update_schedule_table.sql','1645238','table namings were keywords.',now());
INSERT INTO db_versions VALUES (0.2, 'table names were keywords.', true);