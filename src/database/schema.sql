DROP DATABASE IF EXISTS lead;

CREATE DATABASE lead;

GRANT ALL PRIVILEGES ON lead.* TO 'leadapp'@'localhost' IDENTIFIED BY 'leadapp' WITH GRANT OPTION;

USE lead;

# -----------------------------------------------------------------------
# LEADUSER
# -----------------------------------------------------------------------
CREATE TABLE USER
(
   USR_ID BIGINT NOT NULL AUTO_INCREMENT,
   USR_FIRST_NAME VARCHAR(255)  NOT NULL,
   USR_LAST_NAME VARCHAR(255) NOT NULL,
   USR_EMAIL VARCHAR(255) NOT NULL,
   USR_PASSWORD VARCHAR(255) NOT NULL,
   USR_CREATED_DATE DATETIME,
   USR_MODIFIED_DATE DATETIME,
      PRIMARY KEY(USR_ID),
      UNIQUE(USR_EMAIL)
   ) ENGINE = InnoDB;


# -----------------------------------------------------------------------
# CATEGORY
# -----------------------------------------------------------------------
CREATE TABLE CATEGORY
(
   CT_ID BIGINT NOT NULL AUTO_INCREMENT,
   CT_NAME VARCHAR(255) NOT NULL,
   CT_DESCRIPTION VARCHAR(400),
   CT_CREATED_DATE DATETIME,
   CT_MODIFIED_DATE DATETIME,
      PRIMARY KEY(CT_ID) ,
      UNIQUE(CT_NAME)
   ) engine=InnoDB;

# -----------------------------------------------------------------------
# LEAD
# -----------------------------------------------------------------------
CREATE TABLE LEAD
(
   LD_ID BIGINT NOT NULL AUTO_INCREMENT,
   LD_TITLE VARCHAR(255) NOT NULL,
   LD_DESCRIPTION VARCHAR(400) NOT NULL,
   LD_FIRST_NAME VARCHAR(255) NOT NULL,
   LD_LAST_NAME VARCHAR(255) NOT NULL,
   LD_EMAIL VARCHAR(255) NOT NULL,
   LD_PHONE VARCHAR(100),
   LD_PRICE DECIMAL(19,2),
   LD_STATUS VARCHAR(100) NOT NULL,
   LD_OWNER_ID BIGINT NOT NULL,
   LD_CATEGORY_ID BIGINT NOT NULL,
   LD_CREATED_DATE DATETIME,
   LD_MODIFIED_DATE DATETIME,
      PRIMARY KEY(LD_ID),
      FOREIGN KEY (LD_OWNER_ID) REFERENCES USER(USR_ID),
      FOREIGN KEY (LD_CATEGORY_ID) REFERENCES CATEGORY(CT_ID)
   )engine=InnoDB;



INSERT INTO USER (USR_FIRST_NAME, USR_LAST_NAME, USR_EMAIL, USR_PASSWORD, USR_CREATED_DATE, USR_MODIFIED_DATE)
VALUES('John', 'Miller', 'user@javachap.com', 'javachap', now(), now());


INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Insurance', 'Insurance');
INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('IT Services', 'IT Services');
INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Software', 'Software');
INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Hardware', 'Hardware');
INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Financial Services', 'Financial Services');
INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Construction', 'Construction');
INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Consumer Loans', 'Consumer Loans');
