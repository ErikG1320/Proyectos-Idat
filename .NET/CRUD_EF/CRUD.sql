    CREATE DATABASE CRUD;
    USE CRUD;
    CREATE TABLE Cliente(
        ClienteId INT IDENTITY (1,1) NOT NULL PRIMARY KEY,
        Nombre VARCHAR(50) NOT NULL,
        Email VARCHAR(50) NOT NULL
    )
    CREATE TABLE Pedido(
        PedidoId INT IDENTITY (1,1) NOT NULL PRIMARY KEY,
        Descripcion VARCHAR(100),
        FechaPedido DATETIME,
        ClienteId INT NOT NULL,
        CONSTRAINT FK_Cliente_Pedido_ClienteId FOREIGN KEY (ClienteId) REFERENCES Cliente (ClienteId) ON DELETE CASCADE
    )