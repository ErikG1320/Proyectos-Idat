import React from 'react';
// Importar componentes
import ListarClientes from "./Component/ListarClientes";
import Clientes_Pais from "./Component/Clientes_Pais";
import { Routes, Route } from 'react-router-dom';
import Inicio from './Component/Inicio';
import TableClientes from './Component/TableClientes';

function App() {
  return (
    <div className="container">
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="Listar-Clientes" element={<ListarClientes />} />
        <Route path="Clientes-por-pais" element={<Clientes_Pais />} />
        <Route path='Tabla_Clientes' element={<TableClientes />} />
      </Routes>
    </div>
  );
}

export default App;
