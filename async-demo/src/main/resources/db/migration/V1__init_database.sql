CREATE TABLE IF NOT EXISTS DOCTOR(
    doctor_id SERIAL NOT NULL PRIMARY KEY,
    doctor_name VARCHAR(250) NOT NULL,
    specialization VARCHAR(250) NOT NULL,
    doctor_degree VARCHAR(250) NOT NULL,
    ratings VARCHAR(250)
);

ALTER TABLE DOCTOR ADD CONSTRAINT degree_check_constraint CHECK ( doctor_degree='MBBS' OR doctor_degree='PHD' );