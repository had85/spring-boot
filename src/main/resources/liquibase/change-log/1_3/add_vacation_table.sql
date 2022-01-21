CREATE TABLE VACATION (
  id NUMBER NOT NULL,
  start_date date NOT NULL,
  duration NUMBER NOT NULL,
  approval char NOT NULL,
  username varchar2(45) NOT NULL,
  CONSTRAINT pk_vacation PRIMARY KEY(id)
);
  
CREATE SEQUENCE vacation_increment MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 1 NOCACHE;