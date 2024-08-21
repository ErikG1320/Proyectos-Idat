const connection = require('./Mysqlconnect');  // Asegúrate de importar tu conexión a la base de datos
// const readline = require('readline');

// const rl = readline.createInterface({
//     input: process.stdin,
//     output: process.stdout
// });

function Insert(callback, rl) {
    rl.question("Ingrese Nombre: ", (nombre) => {
        rl.question("Ingrese Apellido: ", (apellido) => {
            rl.question("Ingrese su teléfono: ", (telefono) => {
                rl.question("Ingrese su email: ", (email) => {
                    rl.question("Ingrese su dirección: ", (direccion) => {
                        rl.question("Ingrese su ciudad: ", (ciudad) => {
                            rl.question("Ingrese su país: ", (pais) => {
                                rl.question("Ingrese su fecha de nacimiento (YYYY-MM-DD): ", (fechaNacimiento) => {
                                    // Realizamos la inserción en la base de datos
                                    const query = 'INSERT INTO personas SET ?';
                                    const data = {
                                        nombre,
                                        apellido,
                                        telefono,
                                        email,
                                        direccion,
                                        ciudad,
                                        pais,
                                        fechaNacimiento
                                    };
                                    connection.query(query, data, (err, result) => {
                                        if (err) {
                                            console.error('Error al agregar el contacto:', err);
                                        } else {
                                            console.log('Persona agregada con éxito!');
                                        }
                                        connection.end((err) => {
                                            if (err) {
                                                console.error('Error al cerrar la conexión:', err);
                                            } else {
                                                console.log('Conexión a la base de datos cerrada.');
                                            }
                                            // // Aquí cerramos readline
                                            // rl.close();
                                            // // Llamamos al callback después de cerrar readline
                                            // callback();
                                            // rl.close();
                                            // Llamar al callback para regresar al menú
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

module.exports = Insert;
