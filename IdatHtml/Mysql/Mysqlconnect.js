const mysql2 = require ('mysql2')

const connection = mysql2.createConnection({
    host: 'localhost',
    user: 'root',
    password: '109Inuyash@',
    database: 'proyectoweb',
    port:2413
})


module.exports = connection;


connection.connect((err) => {
        if (err) throw err;
        console.log('Conectado a la base de datos!');
    });

// connection.end((err) => {
//         if (err) throw err;
//         console.log('Desconectado de la base de datos!');
//     });
