create database qlythuvien;
use qlythuvien;

create table user(
	ten nvarchar(255),
    matkhau int
);

drop table user;
	CREATE TABLE admin (
		id INT AUTO_INCREMENT PRIMARY KEY,
		email VARCHAR(100) NOT NULL,
		password VARCHAR(255) NOT NULL
	);
INSERT INTO admin (email, password) VALUES
('quyen204@gmail.com', '2004');
CREATE table sach (
    masach VARCHAR(20) PRIMARY KEY,
    tensach VARCHAR(100),
    theloai VARCHAR(50),
    soluong INT,
    ngayxuatban DATETIME,
    nhaxuatban VARCHAR(100),
    tacgia VARCHAR(100),
    giatien DECIMAL(10,2),
    vitri VARCHAR(50)
);
ALTER TABLE sach MODIFY COLUMN ngayxuatban DATETIME;



CREATE TABLE phongdoc (
    maphongdoc VARCHAR(10) PRIMARY KEY,
    phong VARCHAR(10) NOT NULL,
    tang NVARCHAR(10) NOT NULL,
    trangthai varchar(10) not null,
    soluongnguoi INT NOT NULL DEFAULT 0,
    loaiphong varchar(10)
);

CREATE TABLE nhanvien (
    manv VARCHAR(10) PRIMARY KEY,          
    tennv VARCHAR(100),                    
    ngaysinh DATE,                        
    diachi VARCHAR(255),                   
    ngaylamviec datetime,                      
    email VARCHAR(100),                    
    luong DECIMAL(15, 2),                  
    sodienthoai VARCHAR(15),               
    chucvu VARCHAR(50)                     
);
CREATE TABLE docgia (
    madocgia VARCHAR(20) PRIMARY KEY,
    hoten VARCHAR(100) NOT NULL,
    gioitinh VARCHAR(100) NOT NULL,
    ngaysinh DATE,
    diachi VARCHAR(255),
    email VARCHAR(100),
    sodienthoai int,
    ngaylamthe DATEtime,
    ngayhethan DATEtime
);
CREATE TABLE muontra (
    maphieumuon VARCHAR(20) PRIMARY KEY,         
    madocgia VARCHAR(20),                        
    masach VARCHAR(20),                         
    tensach VARCHAR(100),                     
    soluong INT,                              
    giatien DECIMAL(10,2),                     
    ngaymuon DATETIME,                          
    ngaydukientra DATETIME,                      
    ngaytrasach DATETIME,                      
    trangthai VARCHAR(50),                       
    ghichu TEXT,                                 

    FOREIGN KEY (madocgia) REFERENCES docgia(madocgia),
    FOREIGN KEY (masach) REFERENCES sach(masach)
);

