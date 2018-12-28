USE behaviour;

DELIMITER $$
DROP TRIGGER IF EXISTS action_log_trigger_delete$$
USE behaviour$$
CREATE TRIGGER action_log_trigger_delete
BEFORE DELETE ON scheduled FOR EACH ROW
	BEGIN
		INSERT INTO action_log (change_made, change_date, patient_patient_id)
        VALUES("Deleted activity",now(), OLD.patient_patient_id);

	END$$
DELIMITER ;


DELIMITER $$
DROP TRIGGER IF EXISTS action_log_trigger_update$$
USE behaviour$$
CREATE TRIGGER action_log_trigger_update
AFTER UPDATE ON scheduled FOR EACH ROW
	BEGIN
		INSERT INTO action_log (change_made, change_date, patient_patient_id)
        VALUES("Updated activity",now(), new.patient_patient_id);

	END$$
DELIMITER ;