CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS APPLICANT (
    applicant_Id BIGSERIAL PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    userName VARCHAR(50) NOT NULL,
    password CHAR(68) NOT NULL,
    fatherName VARCHAR(50) NOT NULL,
    panNo VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE ,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    zip VARCHAR(10) NOT NULL,
    country VARCHAR(50) NOT NULL,
    active SMALLINT NOT NULL
);

CREATE TABLE IF NOT EXISTS APPLICATION(
    application_id BIGSERIAL NOT NULL PRIMARY KEY,
    status VARCHAR(8) NOT NULL,
    applicant_id BIGSERIAL NOT NULL,
    FOREIGN KEY (applicant_id) REFERENCES APPLICANT(applicant_id)
);

CREATE TABLE IF NOT EXISTS PASSPORT(
    passport_number uuid NOT NULL PRIMARY KEY,
    issued_on DATE NOT NULL,
    expires_on DATE NOT NULL,
    applicant_id BIGSERIAL NOT NULL,
    FOREIGN KEY (applicant_id) REFERENCES APPLICANT(applicant_id)
);

CREATE TABLE IF NOT EXISTS ROLE(
	username VARCHAR(50) NOT NULL,
	role VARCHAR(50) NOT NULL
);