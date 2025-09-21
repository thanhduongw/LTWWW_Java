CREATE DATABASE QUANLYDIENTHOAI CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE QUANLYDIENTHOAI;

CREATE TABLE NHACUNGCAP (
                            MANCC VARCHAR(20) PRIMARY KEY,
                            TENNHACC VARCHAR(150) NOT NULL,
                            DIACHI VARCHAR(255),
                            SODIENTHOAI VARCHAR(50)
);

CREATE TABLE DIENTHOAI (
                           MADT VARCHAR(20) PRIMARY KEY,
                           TENDT VARCHAR(200) NOT NULL,
                           NAMSANXUAT INT,
                           CAUHINH VARCHAR(255),
                           MANCC VARCHAR(20),
                           HINHANH VARCHAR(255),
                           CONSTRAINT fk_ncc FOREIGN KEY (MANCC) REFERENCES NHACUNGCAP(MANCC) ON DELETE SET NULL
);

INSERT INTO NHACUNGCAP(MANCC, TENNHACC, DIACHI, SODIENTHOAI) VALUES
                                                                 ('NCC001', 'Fango Mobile', '123 Lê Lợi, HCM', '028123456'),
                                                                 ('NCC002quanlydienthoaidienthoaidienthoai', 'VietPhone', '456 Pasteur, HCM', '028987654');

INSERT INTO DIENTHOAI(MADT, TENDT, NAMSANXUAT, CAUHINH, MANCC, HINHANH) VALUES
                                                                            ('DT001','Fango X1',2023,'Ram 8GB; Rom 128GB','NCC001','fango_x1.jpg'),
                                                                            ('DT002','VPhone Z','2022','Ram 6GB; Rom 64GB','NCC002','vphone_z.jpg');
