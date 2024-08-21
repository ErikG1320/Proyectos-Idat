const connection = require('./Mysqlconnect');

function Update(callback, rl) {
    rl.question("Ingrese ID del contacto a actualizar: ", (id) => {
        rl.question("Ingrese Nuevo Nombre: ", (nombre) => {
            rl.question("Ingrese Nuevo Apellido: ", (apellido) => {
                rl.question("Ingrese Nuevo Teléfono: ", (telefono) => {
                    rl.question("Ingrese Nuevo Email: ", (email) => {
                        rl.question("Ingrese Nueva Dirección: ", (direccion) => {
                            rl.question("Ingrese Nueva Ciudad: ", (ciudad) => {
                                rl.question("Ingrese Nuevo País: ", (pais) => {
                                    rl.question("Ingrese Nueva Fecha de Nacimiento (YYYY-MM-DD): ", (fechaNacimiento) => {
                                        const sql = 'UPDATE Personas SET nombre=?, apellido=?, telefono=?, email=?, direccion=?, ciudad=?, pais=?, fechaNacimiento=? WHERE id=?';
                                        connection.query(sql, [nombre, apellido, telefono, email, direccion, ciudad, pais,fechaNacimiento, id], (err, result) => {
                                            if (err) throw err;
                                            console.log(`Se actualizó ${result.affectedRows} registro(s).`);
                                            callback();
                                        });
                                    });
                                });
                            });
                        });
                    });
                });
            });
        });
    });
}

module.exports = Update;
