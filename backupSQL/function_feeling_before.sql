CREATE DEFINER=`root`@`localhost` FUNCTION `function_feeling_before`(v_patientID INT) RETURNS int(11)
BEGIN

DECLARE var_sch_date datetime;
DECLARE var_activity_id integer;
DECLARE var_feeling_level_before integer;

SET var_sch_date = (SELECT sch_date FROM behaviour.scheduled WHERE patient_patient_id=v_patientID ORDER BY sch_date DESC);
SET  var_activity_id = (SELECT activity_activity_id FROM behaviour.scheduled WHERE patient_patient_id=v_patientID ORDER BY sch_date DESC);

-- feeling before
set var_feeling_level_before = (SELECT feeling_log.feeling_in_num_format FROM feeling_log where date_inputted < var_sch_date ORDER BY date_inputted DESC LIMIT 1);
								

RETURN var_feeling_level_before;
END