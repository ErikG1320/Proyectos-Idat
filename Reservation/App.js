const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const reservationsRouters = require('./Routes/Reservations');
const app = express();
const port = 3000;

// Middleware para analizar solicitudes JSON
app.use(express.json());

// Conexión a MongoDB
mongoose.connect('mongodb://localhost:27017/Hotel')
    .then(() => console.log('Conectado a MongoDB'))
    .catch(err => console.error('Error al conectar a MongoDB:', err));

app.use(cors());
app.use(bodyParser.json());

// Importar las rutas de reservaciones
app.use('/api/Reservations', reservationsRouters);

// Iniciar el servidor
app.listen(port, () => {
    console.log(`Servidor escuchando en http://localhost:${port}`);
});
