import React from 'react';
import ListarPosts from './Component12/ListarPosts';
import PostsUsuario from './Component12/PostsUsuario';
// Importar componentes

function App() {
  return (
    <div className="container">
      {/* <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="Listar-Clientes" element={<ListarClientes />} />
        <Route path="Clientes-por-pais" element={<Clientes_Pais />} />
        <Route path='Tabla_Clientes' element={<TableClientes />} />
      </Routes> */}
      <ListarPosts></ListarPosts>
      <PostsUsuario></PostsUsuario>
    </div>
  );
}

export default App;
