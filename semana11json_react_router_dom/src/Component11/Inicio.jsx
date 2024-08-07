//rsc
import React from 'react';
import { Link } from 'react-router-dom';

const Inicio = () => {
    return (
        <div>
            <h1>Menu de consultas Json</h1>
            <div className="btn btn-group">
                <Link to="/" className="btn btn-primary">Inicio</Link>
                &nbsp; &nbsp;
                <Link to="ListarClientes" className="btn btn-secondary">Listar Clientes</Link>
                &nbsp; &nbsp;
                <Link to="Clientes-por-pais" className="btn btn-success">Clientes Por País</Link>
                &nbsp; &nbsp;
                <Link to="Tabla_Clientes" className="btn btn-warning">Tabla clientes </Link>
            </div>
        </div>
    );
};

export default Inicio;