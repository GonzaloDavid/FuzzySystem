ALTER TABLE DephiFuzzyMethod.environment DROP PRIMARY KEY;
ALTER TABLE DephiFuzzyMethod.environment ADD seqenvironment BIGINT(20) NOT NULL;
ALTER TABLE DephiFuzzyMethod.environment ADD CONSTRAINT environment_PK PRIMARY KEY (seqenvironment);
ALTER TABLE DephiFuzzyMethod.environment CHANGE seqenvironment seqenvironment bigint(20) NOT NULL FIRST;
ALTER TABLE DephiFuzzyMethod.environment ADD CONSTRAINT UNIQUE_seqenvironment UNIQUE KEY (seqenvironment);
ALTER TABLE DephiFuzzyMethod.environment MODIFY COLUMN seqenvironment bigint(20) auto_increment NOT NULL;


