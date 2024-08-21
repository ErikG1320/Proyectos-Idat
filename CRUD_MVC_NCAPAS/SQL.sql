CREATE DATABASE Systemas;
USE Systemas;
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
CREATE TABLE Categorias (
    id INT IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255),
    PRIMARY KEY(id)
);
CREATE TABLE Proveedores (
    id INT IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100),
    PRIMARY KEY(id)
);
CREATE TABLE Ventas (
    id INT IDENTITY(1,1),
    fecha DATE NOT NULL,
    total DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE Clientes (
    id INT IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    correo_electronico VARCHAR(100),
    PRIMARY KEY(id)
);
CREATE TABLE DetalleVenta (
    id INT IDENTITY(1,1),
    venta_id INT NOT NULL,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(venta_id) REFERENCES Ventas(id),
    FOREIGN KEY(producto_id) REFERENCES Productos(id)
);
CREATE TABLE ProductoCategoria (
    producto_id INT NOT NULL,
    categoria_id INT NOT NULL,
    PRIMARY KEY(producto_id, categoria_id),
    FOREIGN KEY(producto_id) REFERENCES Productos(id),
    FOREIGN KEY(categoria_id) REFERENCES Categorias(id)
);
CREATE TABLE ProductoProveedor (
    producto_id INT NOT NULL,
    proveedor_id INT NOT NULL,
    PRIMARY KEY(producto_id, proveedor_id),
    FOREIGN KEY(producto_id) REFERENCES Productos(id),
    FOREIGN KEY(proveedor_id) REFERENCES Proveedores(id)
);