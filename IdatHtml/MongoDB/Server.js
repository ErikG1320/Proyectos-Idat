const serverex = require('express');
const bodyparser = require('body-parser');
const mongoose = require('./cnxMongodb');
const port = 1324;


const app =serverex();

app.use(bodyparser.urlencoded({ extended:true }));
app.set('view engine ' ,'ejs');
//definir esquema y modelo
const postSchema = new mongoose.Schema({
    nombre: String,
    apellidocompleto: String,
    telefono: String,
    email: String,
    direccion: String,
    ciudad: String,
    pais: String,
    fechaNacimiento: Date,
});

const Usuario = mongoose.model('Usuario', postSchema);

app.use(serverex.static('Htmls'));

//Ruta para manejar la inserción de datos

app.post('./Insert.js', async(req,res)=>{
    const {nombre,
        apellidocompleto,
        telefono,
        email,
        direccion,
        ciudad,
        pais,
        fechaNacimiento}=req.body;
    try{
        const nuevoUsuario=new Usuario({nombre,
            apellidocompleto,
            telefono,
            email,
            direccion,
            ciudad,
            pais,
            fechaNacimiento});
        await nuevoUsuario.save();
        res.redirect('./Views/Mostrar.ejs');

    }catch(err){
        res.status(500).send('Error al insertar los datos');
    }
});

//Ruta para mostrar los registros
app.get('/mostrar', async(req,res)=>{
    try{
        const usuarios= await Usuario.find();
        res.render('mostrar', {usuarios});
    }catch(err){
        res.status(500).send('Error al obtener los datos');
    }
});

//Iniciar el servidor
app.listen(port,()=>{
    console.log('Servidor inciado');
})


