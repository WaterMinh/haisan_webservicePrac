
CREATE DATABASE HaiSan
GO

USE HaiSan
GO

CREATE TABLE tblHaiSan(
	id int IDENTITY(1,1) PRIMARY KEY,
	ten nvarchar(50) NOT NULL,
	ncc nvarchar(50) NOT NULL,
	dvt nvarchar(10) DEFAULT('kg'),
	soluong float DEFAULT(10) CHECK (soluong > 0),
	giatien int CHECK (giatien > 1000),
	tinhtrang bit DEFAULT 1,
	anh varchar(256)
)
GO

INSERT INTO tblHaiSan(ten, ncc, soluong, giatien) VALUES
	(N'Cua hoàng đế', N'Long Châu', 120, 355000),
	(N'Tôm hùm', N'Hải sản QN', 120, 355000),
	(N'Mực 1 nắng', N'Nam Định', 120, 355000),
	(N'Sứa biển khô giòn', N'Đồ Sơn', 120, 355000),
	(N'Cá nục', N'Nha Trang', 120, 355000)
GO
SELECT * FROM tblHaiSan