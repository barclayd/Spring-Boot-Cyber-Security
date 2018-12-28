USE behaviour;

DELIMITER $$
DROP TRIGGER IF EXISTS action_log_trigger$$
USE behaviour$$
CREATE TRIGGER action_log_trigger
AFTER INSERT ON scheduled FOR EACH ROW
	BEGIN
		INSERT INTO action_log (change_made, change_date, patient_patient_id)
        VALUES("Scheduled activity",now(), new.patient_patient_id);

	END$$
DELIMITER ;