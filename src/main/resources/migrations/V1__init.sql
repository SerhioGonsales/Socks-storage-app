USE socks_db;

CREATE TABLE socks
(
    id INT primary key auto_increment,
    colour VARCHAR(255),
    cotton int,
    quantity int
);

INSERT INTO socks (colour, cotton, quantity)
VALUES
    ('blue', 18, 88),
    ('pink', 20, 30),
    ('pink', 30, 25),
    ('pink', 40, 12),
    ('pink', 50, 90),
    ('pink', 60, 65),
    ('pink', 70, 1),
    ('pink', 80, 50),
    ('black', 12, 3),
    ('yellow', 33, 74),
    ('green', 87, 44),
    ('white', 53, 34),
    ('pink', 80, 7);