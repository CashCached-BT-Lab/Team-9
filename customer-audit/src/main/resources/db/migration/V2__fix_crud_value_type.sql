-- Align column type with JPA expectation
ALTER TABLE AUDIT_LOG MODIFY CRUD_VALUE VARCHAR(1) NOT NULL;


