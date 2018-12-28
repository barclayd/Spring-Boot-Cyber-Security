CREATE DEFINER=`root`@`localhost` FUNCTION `function_activity_name`(v_patientID INT) RETURNS varchar(20) CHARSET utf8
BEGIN

DECLARE var_activity_id integer;
DECLARE var_activity_name varchar(20);

SET  var_activity_id = (SELECT activity_activity_id FROM behaviour.scheduled WHERE patient_patient_id=v_patientID ORDER BY sch_date DESC);

-- the activity name
SET var_activity_name = (select activity.name FROM activity WHERE activity.activity_id =  var_activity_id LIMIT 1);

RETURN var_activity_name;
END