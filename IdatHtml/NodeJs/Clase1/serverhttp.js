const http = require('http');

// Crear un servidor HTTP
const server = http.createServer((req, res) => {
    // Establecer la cabecera de respuesta HTTP
    res.setHeader('Content-Type', 'application/json');

    // Verificar el método de la solicitud
    if (req.method === 'GET') {
        // Si es una solicitud GET, devolver datos JSON
        res.end(JSON.stringify({ message: '¡Hola, Mundo!' }));
    } else if (req.method === 'POST') {
        // Si es una solicitud POST, analizar el cuerpo de la solicitud
        let body = '';
        req.on('data', chunk => {
            body += chunk;
        });

        req.on('end', () => {
            // Analizar los datos JSON del cuerpo de la solicitud
            const data = JSON.parse(body);

            // Verificar si los datos contienen una propiedad "name"
            if (typeof data.name !== 'string' || data.name.trim() === '') {
                // Si no, enviar una respuesta de error 400 Bad Request
                res.status(400).end(JSON.stringify({ error: 'El nombre es obligatorio.' }));
                return;
            }
        });
    }
});

// Escuchar en el puerto 2413
server.listen(2413, () => {
    console.log('Servidor escuchando en el puerto 2413');
});
