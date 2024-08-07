const http = require('http');
const fs = require('fs');
const path = require('path');

// Crear un servidor HTTP
const server = http.createServer((req, res) => {
    // Establecer la cabecera de respuesta HTTP
    res.setHeader('Content-Type', 'text/html');

    // Verificar el método de la solicitud y la ruta
    if (req.url === '/IdatHtml/NodeJs/Clase2') {
        // Ruta raíz: enviar una página HTML simple
        fs.readFile(path.join(__dirname, 'Index.html'), 'utf8', (err, data) => {
            if (err) {
                console.error('Error al leer el archivo index.html:', err);
                res.writeHead(500, { 'Content-Type': 'text/html' });
                return res.end('<h1>Error 500</h1><p>Ha ocurrido un error interno.</p>');
            }
            res.end(data);
        });
    } else if (req.url === '/datos') {
        // Ruta '/datos': enviar un JSON con datos simples
        fs.readFile(path.join(__dirname, 'datos.json'), 'utf8', (err, data) => {
            if (err) {
                console.error('Error al leer el archivo datos.json:', err);
                res.writeHead(500, { 'Content-Type': 'text/html' });
                return res.end('<h1>Error 500</h1><p>Ha ocurrido un error interno.</p>');
            }
            res.setHeader('Content-Type', 'application/json');
            res.end(data);
        });
    } else {
        // Ruta no encontrada: enviar un mensaje de error 404
        res.writeHead(404, { 'Content-Type': 'text/html' });
        res.end('<h1>Error 404</h1><p>La ruta solicitada no existe.</p>');
    }
});

// Escuchar en el puerto 2413
server.listen(2413, () => {
    console.log('Servidor escuchando en el puerto 2413');
});

// Instalar express
const express = require('express');
const app = express();
