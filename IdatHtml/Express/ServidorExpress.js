const http = require('http');
const path = require('path');
const express = require('express');

const app = express();
const PORT = 1324;

// Crear servidor express
const server = http.createServer(app).listen(PORT, () => {
    console.log(`Servidor listening on port ${PORT}`);
});

// Ruta para servir Index.html y Info.html
app.get("/", (req, res) => {
    console.log("Petición GET recibida en /IdatHtml/Express/");
    res.sendFile('Index.html' ,{root: '.'});
    // res.sendFile( 'Index.html' ,{root :path.join(__dirname,'aplicacion', 'Bootstrapp', 'EVC1', 'EVC2', 'Express')});
});

// Ruta para servir Info.html
app.get("/info", (req, res) => {
    console.log("Petición GET recibida en /IdatHtml/Express/info");
    res.sendFile('Info.html' , {root: '.'});
    // res.sendFile(path.join(__dirname, 'aplicacion', 'Bootstrapp', 'EVC1', 'EVC2', 'Express', 'Info.html'));
});

// Configuración de archivos estáticos
// app.use('/', express.static(path.join(__dirname, '/img')));
app.use('/img', express.static(path.join(__dirname, 'img')));

