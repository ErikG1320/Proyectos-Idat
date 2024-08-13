const mongodb = require('mongoose');
//conexion a ala base de datos
mongodb.connect('mongodb://localhost:27017/mongoweb')
    .then(() => console.log('Conectado a MongoDB'))
    .catch(err => console.error('Error de conexión: ', err));

const db = mongodb.connection;
module.exports = mongodb
// }