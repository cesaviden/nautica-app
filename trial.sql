-- Active: 1712048577709@@127.0.0.1@3306@nauticadb

INSERT INTO members (name, address, phone, dni, email) 
VALUES ('John Doe', '123 Main St', '123456789', '12345678A', 'john.doe@example.com');
INSERT INTO members (name, address, phone, dni, email) 
VALUES ('Alice Smith', '456 Elm St', '987654321', '87654321B', 'alice.smith@example.com');
INSERT INTO members (name, address, phone, dni, email) 
VALUES ('Michael Johnson', '789 Oak St', '456789123', '45678912C', 'michael.johnson@example.com');
INSERT INTO members (name, address, phone, dni, email) 
VALUES ('Emily Brown', '321 Pine St', '789123456', '78912345D', 'emily.brown@example.com');
INSERT INTO members (name, address, phone, dni, email) 
VALUES ('William Davis', '654 Cedar St', '321987654', '32198765E', 'william.davis@example.com');
INSERT INTO members (name, address, phone, dni, email) 
VALUES ('Emma Garcia', '987 Maple St', '654321987', '65432198H', 'emma.garcia@example.com');
INSERT INTO members (name, address, phone, dni, email) 
VALUES ('Noah Martinez', '741 Oak St', '321654987', '32165498I', 'noah.martinez@example.com');
INSERT INTO members (name, address, phone, dni, email) 
VALUES ('Olivia Rodriguez', '852 Pine St', '987321654', '98732198J', 'olivia.rodriguez@example.com');
INSERT INTO members (name, address, phone, dni, email) 
VALUES ('Liam Hernandez', '369 Cedar St', '654987321', '65498798K', 'liam.hernandez@example.com');
INSERT INTO members (name, address, phone, dni, email) 
VALUES ('Ava Lopez', '159 Elm St', '321987654', '32198798L', 'ava.lopez@example.com');



INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('ABC123', 'Sailboat 1', 3, 100, 1);
INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('DEF456', 'Speedboat 1', 5, 150, 2);
INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('GHI789', 'Yacht 1', 7, 200, 3);
INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('JKL012', 'Canoe 1', 2, 50, 4);
INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('MNO345', 'Fishing boat 1', 4, 120, 5);
INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('PQR678', 'Kayak 1', 1, 30, 6);
INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('STU901', 'Catamaran 1', 6, 180, 7);
INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('VWX234', 'Cruise ship 1', 10, 300, 8);
INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('YZA567', 'Dinghy 1', 2, 40, 9);
INSERT INTO boats (registrationNumber, name, mooringNumber, fee, owner_id) 
VALUES ('BCD890', 'Pontoon 1', 8, 220, 10);




INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (1, '2024-04-01 10:00:00', 'Marina 1', 1);
INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (2, '2024-04-02 11:00:00', 'Beach 1', 2);
INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (3, '2024-04-03 12:00:00', 'Island 1', 3);
INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (4, '2024-04-04 13:00:00', 'Port 1', 4);
INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (5, '2024-04-05 14:00:00', 'Harbor 1', 5);
INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (6, '2024-04-06 15:00:00', 'Bay 1', 6);
INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (7, '2024-04-07 16:00:00', 'Coast 1', 7);
INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (8, '2024-04-08 17:00:00', 'Sea 1', 8);
INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (9, '2024-04-09 18:00:00', 'River 1', 9);
INSERT INTO trips (boat_id, departureDateTime, destination, patron_id) 
VALUES (10, '2024-04-10 19:00:00', 'Lake 1', 10);




INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 1', '789 Oak St', '456123789', '45612378C', 'patron1@example.com');
INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 2', '321 Pine St', '789456123', '78945612D', 'patron2@example.com');
INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 3', '456 Elm St', '987654321', '87654321E', 'patron3@example.com');
INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 4', '123 Main St', '123456789', '12345678F', 'patron4@example.com');
INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 5', '654 Cedar St', '321987654', '32198765G', 'patron5@example.com');
INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 6', '741 Oak St', '321654987', '32165498M', 'patron6@example.com');
INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 7', '987 Maple St', '654321987', '65432198N', 'patron7@example.com');
INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 8', '159 Elm St', '321987654', '32198798O', 'patron8@example.com');
INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 9', '369 Cedar St', '654987321', '65498798P', 'patron9@example.com');
INSERT INTO patrons (name, address, phone, dni, email) 
VALUES ('Patron 10', '852 Pine St', '987321654', '98732198Q', 'patron10@example.com');