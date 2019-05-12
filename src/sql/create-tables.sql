DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS bank_transaction;

CREATE TABLE client
(
  id         int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name varchar(45),
  last_name  varchar(45),
  address    varchar(120),
  age        int(3)
);



CREATE TABLE account
(
  id        int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name      VARCHAR(50),
  amount    NUMERIC(20, 2),
  client_id int(11),
  CONSTRAINT account_client_FK
    FOREIGN KEY (client_id) REFERENCES client (id)
);

CREATE table bank_transaction
(
  id                  int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  transaction_date    DATETIME,
  account_sender_id   int(11),
  account_receiver_id int(11),
  amount              NUMERIC(20, 2),
  constraint sender_transaction_FK
    FOREIGN KEY (account_sender_id) references account (id),
  constraint receiver_transaction_FK
    FOREIGN KEY (account_receiver_id) references account (id)
);
