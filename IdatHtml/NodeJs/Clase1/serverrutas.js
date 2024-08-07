const http = require('http');

// Crear un servidor HTTP
const http = require('http');

// Crear un servidor HTTP
const server = http.createServer((req, res) => {
    // Establecer la cabecera de respuesta HTTP
    res.setHeader('Content-Type', 'text/html');

    // Verificar el método de la solicitud y la ruta
    if (req.url === '/') {
        // Ruta raíz: enviar una página HTML simple
        res.write('<html><body><h1>Hola desde Node.js</h1></body></html>');
        res.end();
    } else if (req.url === '/datos') {
        // Ruta '/datos': aquí puedes manejar los datos JSON (aunque actualmente no estás haciendo nada con ellos)
        // Por ahora, simplemente enviaremos un mensaje de confirmación
        res.write('<html><body><p>Ruta /datos recibida.</p></body></html>');
        res.end();
    } else {
        // Otras rutas: enviar un mensaje de error 404 (recurso no encontrado)
        res.writeHead(404, { 'Content-Type': 'text/html' });
        res.write('<html><body><h1>404 - Recurso no encontrado</h1></body></html>');
        res.end();
    }
});

// Escuchar en el puerto 2413
server.listen(2413, () => {
    console.log('Servidor escuchando en el puerto 2413');
});

