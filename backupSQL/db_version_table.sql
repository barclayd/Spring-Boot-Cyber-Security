-- Based on CM6211 Database Systems S13's content.

USE behaviour;
DROP TABLE IF EXISTS db_versions;

CREATE TABLE db_versions(
db_version varchar(5) PRIMARY KEY,
description text,
is_being_used boolean
);


DROP TABLE IF EXISTS schema_changes;

CREATE TABLE schema_changes(
ChangeID int NOT NULL AUTO_INCREMENT PRIMARY KEY,
MajorReleaseNumber int NOT NULL,
MinorReleaseNumber int NOT NULL,
ScriptName varchar(50) NOT NULL,
ScriptAuthor varchar(50) NOT NULL,
ChangeDscription varchar(255) NOT NULL,
DateApplied datetime NOT NULL)
ENGINE=INNODB;