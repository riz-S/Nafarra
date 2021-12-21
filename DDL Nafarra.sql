create database nafarra;
use nafarra

create table Customer(
	cust_phone_num	varchar(13)  not null unique,
    first_name		varchar(15)  not null,
    last_name		varchar(50)  not null,
    street_name		varchar(100) not null,
    street_number	varchar(5)	 not null,
	city			varchar(20)	 not null,
    zipcode			varchar(5)	 not null,
    
    primary key(cust_phone_num)
)

create table Employee (
	emp_id			varchar(6)	 not null unique,
    name			varchar(20)	 not null,
	sex				varchar(1)	 check(sex in ('P', 'L')) not null,
    salary			numeric(8)   not null,
    b_date			date		 not null,
    emp_phone_num	varchar(13)  not null,

    primary key (emp_id)
)

create table Province(
	prov_id		varchar(2)	not null unique,
    prov_name	varchar(20) not null,

	primary key(prov_id)
)

create table Branch(
	branch_id		varchar(8)		not null unique,
	manager_id		varchar(6)		not null unique,
	street_name		varchar(100)	not null,
    street_number	varchar(5)		not null,
	city			varchar(20)		not null,
    zipcode			varchar(5)		not null,
	prov_id			varchar(2)		not null,

	primary key (branch_id),
	foreign key (manager_id) references Employee(emp_id) on update cascade,
	foreign key (prov_id) references Province(prov_id)
)

create table Division(
	div_id				varchar(3)	not null unique,
	div_name			varchar(20) not null,
	branch_id			varchar(8)	not null,

	primary key (div_id),
	foreign key (branch_id) references Branch(branch_id)
)

create table WorksFor(
	emp_id		varchar(6)	not null unique,
	div_id		varchar(3)	not null unique,
	start_date	date		not null,

	primary key (emp_id,div_id),
	foreign key (emp_id) references Employee(emp_id) on delete cascade on update cascade,
	foreign key (div_id) references Division(div_id) on delete cascade on update cascade
)

create table Manages(
	emp_id		varchar(6)	not null unique,
	div_id		varchar(3)	not null unique,
	start_date	date		not null,

	primary key (emp_id,div_id),
	foreign key (emp_id) references Employee(emp_id) on delete cascade on update cascade,
	foreign key (div_id) references Division(div_id) on delete cascade on update cascade
)

create table Order1 (
	order_id		varchar (6)		not null unique,
	street_name		varchar(100)	not null,
	street_number	varchar(5)		not null,
	zipcode			varchar(5)		not null,
	city			varchar(20)		not null,
	date_made		date			not null,
	cust_phone_num	varchar(13)		not null,
	delivery_type	varchar(10)		check(delivery_type in ('EXP', 'REG')) not null,
	prov_id			varchar(2)		not null,

	primary key (order_id),
	foreign key (cust_phone_num) references Customer(cust_phone_num) on delete cascade on update cascade,
	foreign key (prov_id) references Province(prov_id)
)

create table Item (
	item_name		varchar(100)	not null unique,
	order_id		varchar(6)		not null,
	item_length		int				not null,
	item_width		int				not null,
	item_height		int				not null,
	item_weight		int				not null,

	primary key (item_name, order_id),
	foreign key (order_id) references order1(order_id) on delete cascade on update cascade
)

create table Status1 (
	status_date		date			not null,
	status_time		time			not null,
	order_id		varchar(6)		not null,
	status_desc		varchar(100)	not null,
	emp_id			varchar(6),

	primary key (status_date,status_time, order_id),
	foreign key (order_id) references Order1(order_id) on delete cascade on update cascade,
	foreign key (emp_id) references Employee(emp_id) on delete set null
)

create table DeliveryFee(
	prov_origin			varchar(2)		not null,
	prov_destination	varchar(2)		not null,
	fee					numeric(8)		not null,

	primary key (prov_origin,prov_destination),
	foreign key (prov_origin) references Province(prov_id) on delete cascade on update cascade,
	foreign key (prov_destination) references Province(prov_id)
)


go
create function qtyCalculate (@order_id varchar(20)) returns int
as
begin
	declare @result int
	set @result = (select count(order_id) from Order1 where order_id = @order_id)
	return @result
end
go

go
create function combineCustName (
@fName varchar(10),
@lName varchar(10))
returns varchar(30)
as
begin
	return @fname + ' ' + @lname
end
go

go
create function combineAddress (
@stName varchar(100),
@stNum varchar(5),
@zipCode varchar(5),
@city varchar(20))
returns varchar(130)
as
begin
	return @stName + ' No.' + cast(@stNum as varchar(3)) + ' ' + @city + ' ' + @zipCode
end
go

go
create function getDeliveryFee(
@deliveryType varchar(10), 
@prov_from varchar(20),
@prov_to varchar(20),
@weight int)
returns numeric
as
begin
	declare @deliveryFee numeric
	declare @provFee numeric
	set @provFee =
		(select fee from DeliveryFee where prov_origin = @prov_from and prov_destination = @prov_to)
	set @provFee = isnull(@provFee,(select fee from DeliveryFee where prov_origin = @prov_to and prov_destination = @prov_from))
	set @deliveryFee =
		case
			when @deliveryType = 'EXP' then @provFee*1.25*@weight
			when @deliveryType = 'REG' then @provFee*@weight
		end
	return @deliveryFee
end
go

go
create function dimension(@length int, @width int, @height int)
returns int
as
begin
	declare @dimension int
	set @dimension = @length*@width*@height
	return @dimension
end
go

go
create function getProvID (@prov_name varchar(20))
returns varchar(2)
as
begin
    declare @provID varchar(2)
    set @provID = (select prov_id from Province where prov_name=@prov_name)
    return @provID
end
go

go
create function jnsPengiriman (@del_type varchar(3))
returns varchar(10)
as
begin
	declare @jnsKirim varchar(10)
	set @jnsKirim =(
	case
		when @del_type = 'REG' then 'REGULER'
		when @del_type = 'EXP' then 'EXPRESS'
	end)
	return @jnsKirim
end
go

go
create function getRow(@prefix varchar(3))
returns int
as
begin
	declare @banyakEmp int
	set @banyakEmp = (select count(emp_id) from Employee where emp_id like concat(@prefix,'%'))
	return @banyakEmp
end
go

go
create function generateEmpId(@city varchar(50),@div varchar(50))
returns varchar(6)
as
begin
	declare @b_id varchar(2)
	declare @d_id varchar(1)
	declare @id varchar(6)
	set @b_id = (
	case
		when @city = 'Malang' then '30'
		when @city = 'Jakarta' then '60'
		when @city = 'Bandung' then '90'
	end)
	set @d_id = (
	case
		when @div = 'Cust. Service' then '1'
		when @div = 'Logistic' then '5'
		when @div = 'Courier' then '6'
		when @div = 'Administration' then '9'
	end)
	set @id = concat(@b_id,@d_id,format(dbo.getRow(concat(@b_id,@d_id))+1,'000'))
	return @id
end
go

go
create function generateOrderId(@del_type varchar(3))
returns varchar(6)
as
begin
	declare @id varchar(6)
	set @id = concat(@del_type,format((select count(*) from Order1 o where o.delivery_type = @del_type)+1,'000'))
	return @id
end
go

--Read--
go
create procedure cekStatus(@order_id varchar(6))
as
	select * from Status1
	where order_id like concat('%',@order_id,'%')
go

go
create procedure getOngkir
        @provOrigin varchar(20),
        @provDest varchar(20),
		@weight int
as
	select 'EXP', dbo.getDeliveryFee('EXP', dbo.getProvID(@provOrigin), dbo.getProvID(@provDest), @weight)
	UNION 
	select 'REG', dbo.getDeliveryFee('REG', dbo.getProvID(@provOrigin), dbo.getProvID(@provDest), @weight)
go

go
create procedure cetakOrder @orderId varchar(6)
as
	select order_id as 'ID Order', cust_phone_num as 'No. HP Pemesan', 
	dbo.jnsPengiriman(delivery_type) as 'Jenis Pengiriman', 
	date_made as 'Tanggal dibuat', 
	dbo.combineAddress(street_name,street_number,zipcode,city) as 'Alamat' from Order1
	where order_id = @orderId
go

go
create procedure cetakStatusAdmin @orderId varchar(6)
as
	select status_desc as 'Status', 
	concat(status_date,' ',format(status_time,'hh\:mm\:ss')) as 'Waktu',
	(select name from Employee e where e.emp_id = s.emp_id) as 'Penanggung Jawab'
	from Status1 s where order_id = @orderId
go

go
create procedure cetakStatusUser @orderId varchar(6)
as
	select order_id, status_desc, 
	concat(status_date,' ',format(status_time,'hh\:mm\:ss')) as 'Waktu' from Status1
	where order_id = @orderId
go

go
create procedure cetakItem @orderId varchar(6)
as
	select item_name as 'Nama Barang', 
	concat(dbo.dimension(item_height,item_width,item_length),' (',item_length,
	'cm x ',item_width,'cm x ',item_height,'cm)') as 'Dimensi',
	concat(item_weight,' gr') as 'Berat' from Item
	where order_id = @orderId
go

go
create procedure cetakEmployee @id varchar(100)
as
	select e.emp_id, e.name, d.div_name, b.city from
	Employee e join WorksFor w on e.emp_id = w.emp_id
	join Division d on w.div_id = d.div_id
	join Branch b on b.branch_id = d.branch_id
	where e.emp_id like concat('%',@id,'%')
go

go
create procedure cetakCustomer @nama varchar(100)
as
	select dbo.combineCustName(first_name,last_name) as 'Nama', 
	c.cust_phone_num as 'No. Telefon', 
	dbo.combineAddress(c.street_name,c.street_number,c.zipcode,c.city) as 'Alamat asal',
	o.order_id as 'ID Order', 
	dbo.combineAddress(o.street_name,o.street_number,o.zipcode,o.city) as 'Alamat tujuan'
	from Customer c join Order1 o on c.cust_phone_num = o.cust_phone_num 
	where concat(first_name,' ',last_name) like concat('%',@nama,'%')
go

go
create procedure jenisDelivery @orderId varchar(6)
as
	select count(delivery_type) from Order1
	where order_id like concat('%',@orderId,'%')
	group by delivery_type
go

--create--
go
create proc addWorksFor (@id varchar(6), @div varchar(50), @cabang varchar(50))
as
	declare @divID varchar(3)
	declare @b_id varchar(6)
	set @b_id = (
	case
		when @cabang = 'Malang' then 'MLG-0003'
		when @cabang = 'Jakarta' then 'JKT-0006'
		when @cabang = 'Bandung' then 'BDG-0008'
	end)
	set @divID = (select div_id from Division where div_name = @div and branch_id = @b_id)
	insert into WorksFor values (@id, @divID, (select convert (date, SYSDATETIME())))
go

go
create procedure addEmployee (@name varchar(20), @sex varchar(1), 
@salary numeric(8,0), @bdate date, @empPNum varchar(13), @city varchar(50), @div varchar(50))
as
	declare @id varchar(6)
	set @id = dbo.generateEmpId(@city,@div)
	insert into Employee values(@id, @name, @sex, @salary, @bdate, @empPNum)
	exec addWorksFor(select @id, @div, @city)
go


go
create procedure addOrder (@road varchar(100), @roadNo varchar(5), 
@zip varchar(5), @city varchar(20), @dateMade date, @pNum varchar(13), 
@delType varchar(10), @provName varchar(20))
as
	declare @provId varchar(2)
	declare @id varchar(6)
	set @provId = dbo.getProvID(@provName)
	set @id = dbo.generateOrderId(@delType)
	insert into Order1 values(@id, @road, @roadNo, @zip, @city, @dateMade, @pNum, @delType, @provId)
go

go
create procedure addCust (@fname varchar(15), @lname varchar(20), @pNum varchar(13), @sName varchar(100), 
@sNum varchar(5), @kota varchar(20), @zip varchar(5))
as
	insert into Customer values (@pNum, @fname, @lname, @sName, @sNum, @kota, @zip)
go

--Query 1--
go
create proc Query1
as
	select b.city as 'Kota', max(o.delivery_type) as 'Jenis Pengiriman tertinggi' from Order1 o join Status1 s
	on o.order_id = s.order_id join WorksFor w
	on s.emp_id = w.emp_id join Division d
	on w.div_id = d.div_id join Branch b
	on d.branch_id = b.branch_id group by b.city
go
--Query 2--
go
create proc Query2
as
	select max(cnt.city) as 'Cabang', max(cnt.banyakDelivery) as 'Banyak Pesanan'
	from (select b.city, count(o.delivery_type) banyakDelivery from Order1 o join Status1 s
	on o.order_id = s.order_id join WorksFor w
	on s.emp_id = w.emp_id join Division d
	on w.div_id = d.div_id join Branch b
	on d.branch_id = b.branch_id group by b.city) cnt
go

--Query 3--
go
create proc Query3 
as
	select name as 'Nama Pegawai' from Employee where emp_id =( 
    select top 1 emp_id from Status1 where order_id in(
        select order_id from Status1 where emp_id = (
            select emp_id from Employee where name = 'Azri'
        )
    )
    and emp_id != (
        select emp_id from Employee where name = 'Azri'
    )
    group by emp_id order by count(emp_id)
	)
go