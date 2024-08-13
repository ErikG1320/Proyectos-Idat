const mongodb = require('./cnxMongodb.js');
// Definir el esquema de la colección
const postSchema = new mongodb.Schema({
    nombre: String,
    apellidocompleto: String,
    telefono: String,
    email: String,
    direccion: String,
    ciudad: String,
    pais: String,
    fechaNacimiento: Date,
});

// Crear el modelo de datos (Post)
const Post = mongodb.model('Post', postSchema);

// Crear una nueva instancia de Post con los datos
const datos = new Post({
    nombre: 'Juan',
    apellidocompleto: 'Pérez',
    telefono: '123456789',
    email: 'juan@example.com',
    direccion: 'Calle Principal 123',
    ciudad: 'Lima',
    pais: 'Perú',
    fechaNacimiento: new Date('1990-01-15'),
});

// Guardar la instancia en la base de datos
async function guardarDatos() {
    try {
        await datos.save();
        console.log('Post insertado correctamente');
    } catch (error) {
        console.error('Error al insertar post:', error);
    }
}

guardarDatos();

// Exportar el modelo
// module.exports = Post;
