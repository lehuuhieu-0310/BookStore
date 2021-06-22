create database BookStore

use BookStore

create table tblAccount(
	username nvarchar(10) primary key,
	password nvarchar(50) not null,
	fullname nvarchar(50) not null,
	role nvarchar(10) not null
)

drop table tblCode

create table tblCategory(
	categoryId int identity(1,1) primary key,
	categoryName nvarchar(50) not null
)

create table tblBook(
	bookId int identity(1,1) primary key,
	bookName nvarchar(50) not null,
	title nvarchar(50),
	[image] nvarchar(200),
	[description] nvarchar(255),
	price float,
	author nvarchar(50),
	importDate date,
	quantity int,
	status nvarchar(10),
	categoryId int not null,
	foreign key (categoryId) references tblCategory (categoryId)
)

create table tblOrder(
	orderId int identity(1,1) primary key,
	username nvarchar(10) not null,
	total float,
	dateOrder date not null,
	foreign key (username) references tblAccount(username)
)

create table tblOrderDetail(
	orderId int not null,
	bookId int not null,
	quantity int,
	price float,
	foreign key (orderId) references tblOrder(orderId),
	foreign key (bookId) references tblBook(bookId),
	primary key (orderId, bookId)
)

create table tblCode(
	codeId int identity(1,1) primary key,
	code nvarchar(10) UNIQUE,
	value float
)

select *
from tblOrder
inner join tblOrderDetail
on tblOrderDetail.orderId = tblOrder.orderId
where tblOrder.orderId = 6

select *
from tblOrder
where username = 'user'

insert tblOrderDetail values (3,1,2,5000)
insert tblOrderDetail values (3,2,2,5000)

insert tblOrder values ('user',150000,'2021-06-17')
select IDENT_CURRENT('tblOrder')

insert tblCategory values('Sach ngoai ngu')
insert tblCategory values('Sach thieu nhi')
insert tblCategory values('Sach chinh tri - xa hoi')


insert tblBook values ('Tap viet tieng nhat can ban', '','','Nham giup ban hoc luyen tap viet duoc nhieu hon trong viec hoc và luyen viet chu Nhat, quyen "Tap Viet Tieng Nhat Can Ban Kanji" da duoc xuat ban',
50000, 'Minh Nhat', '2021-06-16',10,'active', 1)
insert tblBook values ('Vua luoi vua ban van gioi tieng Anh','','','Ban co the vua hoc tieng Anh trong luc ban dang nghe nhac, dang an trua, hoac truoc khi di ngu. Bat ke khi nao ban co thoi gian ranh roi, hay hoc mot chut',
100000, 'Hoai Nguyen', '2021-06-16',10,'active', 1)
insert tblBook values  ('Tu hoc nhanh tieng pho thong Trung Quoc','','','Cuon sach duoc chia thanh cac phan mau cau, tu vung, hoi thoai theo tung chu de gan lien voi cuoc song hang ngay, giup cac ban co the tu hoc tieng Trung mot cach de dang va nhanh chong',
51000, 'Hy Quang', '2021-06-16',10,'active', 1)
insert tblBook values ('Vui Cung Xep Giay Origami','','','Origami - trong tieng Nhat nghia la "xep giay", la nghe thuat xep giay thu cong de tao hinh trang tri bang giay',
30000, 'Nhan Van', '2021-06-16',10,'active', 2)
insert tblBook values ('100 Truyen Ngu Ngon Hay Nhat','','','Nhung thong diep duoc truyen tai trong cuon sach nay la bai hoc ve tam hon cao thuong, la long thuong yeu, la duc tinh tot, la kinh nghiem song, la quan diem song',
40000, 'Nguyen Thu Minh', '2021-06-16',10,'active', 2)
insert tblBook values ('Than thoai Hy Lap','','','Than thoai Hy Lap la nhung truyen co tinh chat hoang duong ve nguon goc vu tru, loai nguoi, giai thich cac hien tuong tu nhien xa hoi, lich su Hy Lạp thoi co',
150000,'Huynh Phan Th. Yen', '2021-06-16',10,'active', 3)
insert tblBook values ('Ho Chi Minh - Bieu tuong cua thoi dai','','','Chan dung cu Ho trong cuon “Ho” cua nha bao nguoi My noi tieng David Halberstam duoc phac hoa day an tuong: “…tu tin trong cot cach binh dan, ly tuong dan toc manh me va kien dinh',
200000,'Do Hoang Linh', '2021-06-16',10,'active', 3)

select codeId
from tblCode
where code = 'giamgia20k'