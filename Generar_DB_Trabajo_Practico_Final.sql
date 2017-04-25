drop database db_Callejas_Lucas;
create database db_Callejas_Lucas;

use db_Callejas_Lucas;

create table Empleado(
	id int auto_increment primary key,
	nombre varchar(50),
	apellido varchar(50)
);

create table Propietario(
	id int auto_increment primary key,
	dni int,
	nombre varchar(50),
	apellido varchar(50),
	direccion varchar(50),
	telefono varchar(20)
);

create table OrdenDeTrabajo(
	id int auto_increment primary key,
	patente varchar(7) not null,
	fechaIngreso date not null,
	idPropietario int not null,
	foreign key (idPropietario) references Propietario(id),
	marca varchar(50) not null,
	modelo varchar(50) not null,
	descripcion varchar(256),
	idEmpleado int not null,
	foreign key (idEmpleado) references Empleado(id),
	estado bit not null,
	horasTrabajadas float not null,
	manoDeObra float,
	costoTotal float
);

create table Repuesto(
	id int auto_increment primary key,
	nombre varchar(50),
	precio float
);

create table OrdenDeTrabajo_Repuesto(
	idOrdenDeTrabajo int,
	idRepuesto int,
	cantidadUsadaDeRepuesto int not null,
	costoDetalle float not null,
	primary key(idOrdenDeTrabajo, idRepuesto),
	foreign key(idOrdenDeTrabajo) references OrdenDeTrabajo(id),
	foreign key(idRepuesto) references Repuesto(id)
);

insert into Empleado (nombre, apellido) values	('Pedro','Rivadavia'),
												('Juan','Las Heras'),
												('Martin','Julio'),
												('Fernando','Hernandez');

-- insert into Propietario (dni, nombre, apellido, direccion, telefono) values
-- 						('36532104','Cosme','Fulanito','Calle Falsa 444', '1563245687'),
-- 						('37895431','Pato','Donald','Disney 555', '47893250');

-- insert into OrdenDeTrabajo	(patente, fechaIngreso, idPropietario, marca, modelo, descripcion, idEmpleado, estado, horasTrabajadas, manoDeObra, costoTotal) values
-- 							('ASD 123', '1982/12/12', 1, 'BMW', 'X3', 'Bujias en mal estado.', 1, 0, 10, 150, 10500);

insert into Repuesto (nombre, precio) values	('Bujia', 100 ),
												('Disipador', 200 ),
												('Inerte Barra de Carbon', 10000 );

-- insert into OrdenDeTrabajo_Repuesto (idOrdenDeTrabajo, idRepuesto, cantidadUsadaDeRepuesto, costoDetalle) values
-- 									(1,1,1,100),
-- 									(1,2,2,400),
-- 									(1,3,1,10000);

