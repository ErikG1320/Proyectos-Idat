import React, { useEffect, useState } from 'react';
import TablePosts from './TablePosts';
const ListarPosts = () => {
            //Variables de estado que alamacene la lista de posts
        const [lista,setlista] =useState([])

        //Función para obtener los posts
        const obtenerPosts = async () => {
            const respuesta = await fetch('https://jsonplaceholder.typicode.com/posts')
            const posts = await respuesta.json()
            setlista(posts)
        }

        //Ejecutar la función para obtener los posts al cargar la página
        useEffect(() => {
            obtenerPosts()
        }, [])
        // obtenerPosts()
    return (
        <div>
            <TablePosts
                data={lista}
                titulo='Listado de Posts'
            />
        </div>
    );
};

export default ListarPosts;