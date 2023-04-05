-- Insert 30 addresses with different coordinates
INSERT INTO address (coordinatex, coordinatey) VALUES (12.34, 56.78);
INSERT INTO address (coordinatex, coordinatey) VALUES (23.45, 67.89);
INSERT INTO address (coordinatex, coordinatey) VALUES (34.56, 78.90);
-- ... continue with the rest of the addresses
INSERT INTO address (coordinatex, coordinatey) VALUES (45.67, 89.01);
INSERT INTO address (coordinatex, coordinatey) VALUES (56.78, 90.12);
INSERT INTO address (coordinatex, coordinatey) VALUES (67.89, 01.23);
INSERT INTO address (coordinatex, coordinatey) VALUES (78.90, 12.34);
INSERT INTO address (coordinatex, coordinatey) VALUES (89.01, 23.45);
INSERT INTO address (coordinatex, coordinatey) VALUES (90.12, 34.56);
INSERT INTO address (coordinatex, coordinatey) VALUES (01.23, 45.67);
INSERT INTO address (coordinatex, coordinatey) VALUES (12.34, 56.78);
INSERT INTO address (coordinatex, coordinatey) VALUES (23.45, 67.89);
INSERT INTO address (coordinatex, coordinatey) VALUES (34.56, 78.90);
INSERT INTO address (coordinatex, coordinatey) VALUES (45.67, 89.01);
INSERT INTO address (coordinatex, coordinatey) VALUES (56.78, 90.12);
INSERT INTO address (coordinatex, coordinatey) VALUES (67.89, 01.23);
INSERT INTO address (coordinatex, coordinatey) VALUES (78.90, 12.34);
INSERT INTO address (coordinatex, coordinatey) VALUES (89.01, 23.45);
INSERT INTO address (coordinatex, coordinatey) VALUES (90.12, 34.56);
INSERT INTO address (coordinatex, coordinatey) VALUES (01.23, 45.67);
INSERT INTO address (coordinatex, coordinatey) VALUES (12.34, 56.78);
INSERT INTO address (coordinatex, coordinatey) VALUES (23.45, 67.89);
INSERT INTO address (coordinatex, coordinatey) VALUES (34.56, 78.90);
INSERT INTO address (coordinatex, coordinatey) VALUES (45.67, 89.01);
INSERT INTO address (coordinatex, coordinatey) VALUES (56.78, 90.12);
INSERT INTO address (coordinatex, coordinatey) VALUES (67.89, 01.23);
INSERT INTO address (coordinatex, coordinatey) VALUES (78.90, 12.34);
INSERT INTO address (coordinatex, coordinatey) VALUES (89.01, 23.45);
INSERT INTO address (coordinatex, coordinatey) VALUES (90.12, 34.56);
INSERT INTO address (coordinatex, coordinatey) VALUES (01.23, 45.67);


INSERT INTO depot (name, address_id) VALUES ('Depot 1', 1);
INSERT INTO depot (name, address_id) VALUES ('Depot 2', 2);

INSERT INTO supplier (name) VALUES ('Supplier 1');
INSERT INTO supplier (name) VALUES ('Supplier 2');

INSERT INTO custom_order (order_name, order_number, order_status, supplier_id) VALUES ('Order 1', 1001, 1, 1);
INSERT INTO custom_order (order_name, order_number, order_status, supplier_id) VALUES ('Order 2', 1002, 1, 2);

-- Insert 30 addresses with different coordinates
INSERT INTO address (coordinatex, coordinatey) VALUES (12.34, 56.78);
INSERT INTO address (coordinatex, coordinatey) VALUES (23.45, 67.89);
INSERT INTO address (coordinatex, coordinatey) VALUES (34.56, 78.90);
-- ... continue with the rest of the addresses
INSERT INTO address (coordinatex, coordinatey) VALUES (45.67, 89.01);
INSERT INTO address (coordinatex, coordinatey) VALUES (56.78, 90.12);
INSERT INTO address (coordinatex, coordinatey) VALUES (67.89, 01.23);
INSERT INTO address (coordinatex, coordinatey) VALUES (78.90, 12.34);
INSERT INTO address (coordinatex, coordinatey) VALUES (89.01, 23.45);
INSERT INTO address (coordinatex, coordinatey) VALUES (90.12, 34.56);
INSERT INTO address (coordinatex, coordinatey) VALUES (01.23, 45.67);
INSERT INTO address (coordinatex, coordinatey) VALUES (12.34, 56.78);
INSERT INTO address (coordinatex, coordinatey) VALUES (23.45, 67.89);
INSERT INTO address (coordinatex, coordinatey) VALUES (34.56, 78.90);
INSERT INTO address (coordinatex, coordinatey) VALUES (45.67, 89.01);
INSERT INTO address (coordinatex, coordinatey) VALUES (56.78, 90.12);
INSERT INTO address (coordinatex, coordinatey) VALUES (67.89, 01.23);
INSERT INTO address (coordinatex, coordinatey) VALUES (78.90, 12.34);
INSERT INTO address (coordinatex, coordinatey) VALUES (89.01, 23.45);
INSERT INTO address (coordinatex, coordinatey) VALUES (90.12, 34.56);
INSERT INTO address (coordinatex, coordinatey) VALUES (01.23, 45.67);
INSERT INTO address (coordinatex, coordinatey) VALUES (12.34, 56.78);
INSERT INTO address (coordinatex, coordinatey) VALUES (23.45, 67.89);
INSERT INTO address (coordinatex, coordinatey) VALUES (34.56, 78.90);
INSERT INTO address (coordinatex, coordinatey) VALUES (45.67, 89.01);
INSERT INTO address (coordinatex, coordinatey) VALUES (56.78, 90.12);
INSERT INTO address (coordinatex, coordinatey) VALUES (67.89, 01.23);
INSERT INTO address (coordinatex, coordinatey) VALUES (78.90, 12.34);
INSERT INTO address (coordinatex, coordinatey) VALUES (89.01, 23.45);
INSERT INTO address (coordinatex, coordinatey) VALUES (90.12, 34.56);
INSERT INTO address (coordinatex, coordinatey) VALUES (01.23, 45.67);


INSERT INTO package (status, custom_order_id, address_id) VALUES (0, 1, 3);
INSERT INTO package (status, custom_order_id, address_id) VALUES (1, 1, 4);
INSERT INTO package (status, custom_order_id, address_id) VALUES (2, 1, 5);

INSERT INTO package (status, custom_order_id, address_id) VALUES (0, 2, 6);
INSERT INTO package (status, custom_order_id, address_id) VALUES (1, 2, 7);
INSERT INTO package (status, custom_order_id, address_id) VALUES (2, 2, 8);
