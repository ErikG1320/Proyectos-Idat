const connection = require('./Mysqlconnect');

function Select (callback,rl) {
    const query = 'SELECT * FROM Personas'
    connection.query(query, (err, results) => {
        if (err) {
            console.error('Error al seleccionar las personas:', err);
        } else if (results.length > 0){
            console.log('Personas encontradas:', results);
        }else {
            console.log('No hay personas registradas.');
        }
    })
}
module.exports =Select