CREATE DATABASE CRUD_MVC_NCAPAS;
USE CRUD_MVC_NCAPAS;
Create table Productos(
    id INT IDENTITY(1,1),
    nombre varchar(100) not null,
    marca varchar(100) not null,
    cantidad int not null,
    precio DECIMAL (10,2) not null,
    descripcion varchar(255) not null,
    fecha date not null,
    PRIMARY KEY(id)
)
DROP TABLE Productos;