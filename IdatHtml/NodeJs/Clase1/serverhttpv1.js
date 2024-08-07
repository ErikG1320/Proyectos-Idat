const http = require('http');
const fs = require('fs');
const path = require('path');

// Crear un servidor HTTP

const server = http.createServer((req, res) => {
    // Obtener la ruta del archivo solicitado
    const filePath = path.join(__dirname,"Index.html");

    // Verificar si el archivo existe
    fs.access(filePath, fs.constants.F_OK, (err) => {
        if (err) {
            // Si el archivo no existe, responder con un código de estado 404
            res.writeHead(404, { 'Content-Type': 'text/html' });
            return res.end("<h1>404 Not Found</h1><p>El recurso solicitado no existe.</p>");
        }

        // Si el archivo existe, leer su contenido y responder con el código de estado 200
        fs.readFile(filePath,'utf-8',(err, content) => {
            if (err) {
                res.writeHead(500, { 'Content-Type': 'text/html' });
                return res.end("<h1>500 Internal Server Error</h1><p>Error leyendo el archivo.</p>");
            }
            res.writeHead(200, { 'Content-Type': contentType(path.extname(filePath)) });
            res.end(content);
        });
    });
});

function contentType(ext) {
    switch (ext) {
        case '.html':
            return 'text/html';
        case '.css':
            return 'text/css';
        case '.js':
            return 'application/javascript';
        default:
            return 'application/octet-stream';
    }
}
// Definir el puerto en el que escuchará el servidor
const port = process.env.PORT || 2413;

// Iniciar el servidor
server.listen(port, () => {
    console.log(`Servidor escuchando en el puerto ${port}`);
});
