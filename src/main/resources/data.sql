DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product
(
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(128) NOT NULL,
  description VARCHAR(256),
  price DECIMAL(5,2) NOT NULL,
  available BOOLEAN DEFAULT TRUE,
  creation_date TIMESTAMP
);
insert into product(name, description, price, available, creation_date) VALUES ('Pencil', 'Drawing pencil', 0.3, true, CURRENT_TIMESTAMP());
insert into product(name, description, price, available, creation_date) VALUES ('Pen', 'Blue pen', 1.5, true, CURRENT_TIMESTAMP());
insert into product(name, description, price, available, creation_date) VALUES ('Rubber', 'Rubber for pen', 0.2, false, CURRENT_TIMESTAMP());
insert into product(name, description, price, available, creation_date) VALUES ('Book', 'The Truth About the Harry Quebert Affair', 12.50, true, CURRENT_TIMESTAMP());
insert into product(name, description, price, available, creation_date) VALUES ('Paper', 'Pack of 100 sheets', 1, true, CURRENT_TIMESTAMP());