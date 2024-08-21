const readline = require('readline');
const Insert = require('./Insert')
const Update = require('./Update');
const Delete = require('./Delete');
const Select = require('./Select');


const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function mainMenu() {
    // console.log(`
    // 1. Insertar Contacto
    // 2. Modificar Contacto
    // 3. Eliminar Contacto
    // 4. Consultar Contactos
    // 5. Salir
    // `);
    console.log('\nMenu Principal');
    console.log('1. Insertar un nuevo cliente');
    console.log('2. Modificar un cliente');
    console.log('3. Eliminar un cliente');
    console.log('4. Consultar todos los clientes de la tabla');
    console.log('5. Salir');
    rl.question("Seleccione una opción: ", (option) => {
        switch (option) {
            case '1':
                Insert(mainMenu, rl);
                break;
            case '2':
                Update(mainMenu, rl);
                break;
            case '3':
                Delete(mainMenu, rl);
                break;
            case '4':
                Select(mainMenu);
                break;
            case '5':
                rl.close();
                console.log('Salio del programa');
                process.exit();//para detener el proceso
            default:
                console.log('Opción no válida.');
                mainMenu();
                break;
        }
    });
}
mainMenu();