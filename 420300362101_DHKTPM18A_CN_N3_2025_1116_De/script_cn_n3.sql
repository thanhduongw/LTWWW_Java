DROP DATABASE IF EXISTS restaurant_management;

CREATE DATABASE restaurant_management 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

USE restaurant_management;

CREATE TABLE table_status (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status_name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO table_status (status_name) VALUES
('Available'),        -- Có thể đặt
('Occupied'),         -- Đang có khách
('Reserved'),         -- Đã đặt trước
('Maintenance');      -- Đang sửa chữa

CREATE TABLE restaurant_tables (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    table_code VARCHAR(10) NOT NULL UNIQUE,
    seats INT NOT NULL,
    status_id BIGINT NOT NULL,
    FOREIGN KEY (status_id) REFERENCES table_status(id)
);

INSERT INTO restaurant_tables (table_code, seats, status_id) VALUES
('T01', 4, 1), 
('T02', 4, 1),
('T03', 2, 3), 
('T04', 6, 2), 
('T05', 4, 3),
('T06', 4, 1),
('T07', 8, 2),
('T08', 2, 4), 
('T09', 4, 1),
('T10', 6, 3),
('T11', 4, 1),
('T12', 4, 2),
('T13', 2, 1),
('T14', 6, 4),
('T15', 4, 1),
('T16', 4, 3),
('T17', 8, 2),
('T18', 2, 1),
('T19', 4, 3),
('T20', 6, 1);

CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    phone VARCHAR(15) NOT NULL UNIQUE,
    email VARCHAR(100) UNIQUE
);

INSERT INTO customers (full_name, phone, email) VALUES
('Lê Minh Hoàng', '0901112233', 'hoanglm@gmail.com'),
('Nguyễn Thảo Vy', '0902345678', 'thaovy@gmail.com'),
('Trần Gia Hưng', '0908765432', 'hungtg@gmail.com'),
('Phạm Khánh Linh', '0912345678', 'linhpk@gmail.com'),
('Đỗ Quốc Bảo', '0933355777', 'baodq@gmail.com');

CREATE TABLE reservations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    reservation_no VARCHAR(20) NOT NULL UNIQUE,
    reservation_date DATE NOT NULL,
    notes VARCHAR(255),
    customer_id BIGINT NOT NULL,
    table_id BIGINT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (table_id) REFERENCES restaurant_tables(id)
);

INSERT INTO reservations (reservation_no, reservation_date, notes, customer_id, table_id) VALUES
('RES001', '2025-11-10', 'Sinh nhật gia đình', 1, 5), 
('RES002', '2025-11-11', 'Tiệc họp lớp', 2, 10), 
('RES003', '2025-11-12', 'Đặt bàn 2 người', 3, 3),
('RES004', '2025-11-13', 'Tiệc kỷ niệm', 4, 16,
('RES005', '2025-11-24', 'Sinh nhật', 5, 19); 
