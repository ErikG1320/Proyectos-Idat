import React, { useEffect, useState } from 'react';
import TablePosts from './TablePosts';

const PostsUsuario = () => {
    // Variables de estado
    const [usuarios, setUsuarios] = useState([]);
    const [posts, setPosts] = useState([]);
    // Obtener usuario seleccionado
    const [codigo, setCodigo] = useState([]);

    // Función para obtener los posts de un usuario
    const obtenerPostsUsuario = async (codigo) => {
        const respuesta = await fetch(`https://jsonplaceholder.typicode.com/posts?userId=${codigo}`);
        const posts = await respuesta.json();
        setPosts(posts);
    };

    useEffect(() => {
        obtenerPostsUsuario(codigo);
    }, [codigo]);

    // const handlercodigo =(e) =>{
    //     setCodigo(e.target.value);
    // }
    // const titulo = "Listado de Posts del Usuario"; + codigo
    // Obtener todos los usuarios
    const obtenerUsuarios = async () => {
        const respuesta = await fetch('https://jsonplaceholder.typicode.com/users');
        const usuarios2 = await respuesta.json();
        setUsuarios(usuarios2);
    };

    useEffect(() => {
        obtenerUsuarios();
    }, []);

    // Evento al seleccionar un usuario
    const seleccionarUsuario = (e) => {
        setCodigo(e.target.value);
        // obtenerPostsUsuario(e.target.value);
    };

    // Mostrar los usuarios
    const mostrarUsuarios = () => {
        return usuarios.map((usuario) => (
            <option key={usuario.id} value={usuario.id}>
                {usuario.name}
            </option>
        ));
    };

    return (
        <div className='container'>
            <div className='row'>
                <label>Seleccione Usuario:</label>
                <select onChange={seleccionarUsuario}>
                    <option value=''>Todos los usuarios</option>
                    {mostrarUsuarios()}
                </select>
                <hr />
                <TablePosts titulo='Listado de Json' data={posts}></TablePosts>
                {/* <TablePosts>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Título</th>
                            <th>Contenido</th>
                        </tr>
                    </thead>
                    <tbody>
                        {posts.map((post) => (
                            <tr key={post.id}>
                                <td>{post.id}</td>
                                <td>{post.title}</td>
                                <td>{post.body}</td>
                            </tr>
                        ))}
                    </tbody>
                </TablePosts> */}
            </div>
        </div>
        
    );
};

export default PostsUsuario;
