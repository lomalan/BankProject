INSERT INTO client(first_name, last_name, address, age)
VALUES ('Roman', 'Bezus', 'Liege, BE', 27),
       ('Andriy', 'Yarmolenko', 'London, UK', 28),
       ('Evgen', 'Khacheridi', 'Athens, GRE', 28),
       ('Evgen', 'Shakhov', 'Athens, GRE', 28),
       ('Olexandr', 'Zinchenko', 'Manchester, UK', 23);
/*
Bezus accounts
*/
INSERT INTO account(name, amount, client_id)
VALUES ('Debit', 2000, 1),
       ('Credit', 5000, 1);
/*
Yarmolenko accounts
*/
INSERT INTO account(name, amount, client_id)
VALUES ('Debit', 12000, 2),
       ('Credit', 25000, 2);
/*
Khacheridi accounts
*/
INSERT INTO account(name, amount, client_id)
VALUES ('Debit', 32000, 3),
       ('Credit', 45000, 3);
/*
Shakhov accounts
*/
INSERT INTO account(name, amount, client_id)
VALUES ('Debit', 22000, 4),
       ('Credit', 53000, 4);
/*
Zinchenko accounts
*/
INSERT INTO account(name, amount, client_id)
VALUES ('Debit', 20, 5),
       ('Credit', 10, 5);
