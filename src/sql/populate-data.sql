INSERT INTO client(first_name, last_name, address, email, age)
VALUES ('Roman', 'Bezus', 'Liege, BE','bezus@gmail.com', 27),
       ('Andriy', 'Yarmolenko', 'London, UK','yarmolenko@gmail.com', 28),
       ('Evgen', 'Khacheridi', 'Athens, GRE','olkom@gmail.com', 28),
       ('Evgen', 'Shakhov', 'Athens, GRE','paok@gmail.com', 28),
       ('Olexandr', 'Zinchenko', 'Manchester, UK','zinchenko@gmail.com', 23);
/*
Bezus accounts
*/
INSERT INTO account(name, account_number, amount, client_id)
VALUES ('Debit',5375353540405050, 2000, 1),
       ('Credit',5375353540406060, 5000, 1);
/*
Yarmolenko accounts
*/
INSERT INTO account(name, account_number, amount, client_id)
VALUES ('Debit',5375353555455050, 12000, 2),
       ('Credit',5375353534445050, 25000, 2);
/*
Khacheridi accounts
*/
INSERT INTO account(name, account_number, amount, client_id)
VALUES ('Debit',5375353512125050, 32000, 3),
       ('Credit',5375353513135050, 45000, 3);
/*
Shakhov accounts
*/
INSERT INTO account(name, account_number, amount, client_id)
VALUES ('Debit',5375353512345050, 22000, 4),
       ('Credit',5375353523565050, 53000, 4);
/*
Zinchenko accounts
*/
INSERT INTO account(name, account_number, amount, client_id)
VALUES ('Debit',5372147540405050, 20, 5),
       ('Credit',5375376540405151, 10, 5);
