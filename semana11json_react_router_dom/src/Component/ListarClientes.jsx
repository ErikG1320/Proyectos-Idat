import React from 'react';
import Data from '../DataJson/dataclientes2024.json';
//Importar componentes
import TableClientes from './TableClientes';
import { Link } from 'react-router-dom';

const ListarClientes = () => {
    return (
        <div>
            <Link to="/" className="btn btn-primary">Inicio</Link>
            <TableClientes data={Data}
            titulo="Listado de Clientes"
            /> 
        </div>
    );
};

export default ListarClientes;