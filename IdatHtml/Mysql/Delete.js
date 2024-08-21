const connection = require('./Mysqlconnect');

function Delete(callback, rl){
    rl.question("Ingrese el ID del Personas a eliminar: ", (id) => {
        const sql = `DELETE FROM Personas WHERE id = ${id}`;
        connection.query(sql, (err, result) => {
            if(err) throw err;
            console.log(`Persona con ID ${id} eliminado.`);
            callback();
        });
    });
}

module.exports = Delete;