import React, { useState } from 'react';
import TableClientes from './TableClientes';
import Data from '../DataJson/dataclientes2024.json';
import { Link } from 'react-router-dom';

const Clientes_Pais = () => {
    const [pais, setPais] = useState('');
    const [clientesFiltrados, setClientesFiltrados] = useState([]);
    const paises = ["Peru", "Ecuador", "Argentina", "Chile"];

    const paisesSelect = paises.map((pais, index) => (
        <option key={index} value={pais}>{pais}</option>
    ));

    const handlerpais = (e) => {
        setPais(e.target.value);
    };

    const query = (e) => {
        e.preventDefault();
        // Filtrar los clientes según el país
        const clientesPorPais = Data.filter((cliente) =>
            cliente.pais.toLowerCase().includes(pais.toLowerCase())
        );
        setClientesFiltrados(clientesPorPais);
    };

    return (
        <div>
            <Link to="/" className="btn btn-primary">Inicio</Link>
            <p>
                Seleccione País: <select className="form-select" value={pais} onChange={handlerpais}>
                    {paisesSelect} 
                </select>
            </p>
            <button className='btn btn-primary' onClick={query}>Buscar</button>
            <TableClientes data={clientesFiltrados} titulo={`Clientes del país: ${pais}`} />
            <p>Total de Clientes: {clientesFiltrados.length}</p>
            <p>Total de Clientes por País: {clientesFiltrados.reduce((total,cliente) => total + 1, 0)}</p>
            {/* <p>Promedio de Edad: {clientesFiltrados.length > 0 ? (clientesFiltrados.reduce((total, cliente) => total + parseInt(cliente.edad), 0) / clientesFiltrados.length) : 0}</p>
            <p>Promedio de Ingresos: {clientesFiltrados.length > 0 ? (clientesFiltrados.reduce((total, cliente) => total + parseInt(cliente.ingresos), 0) / clientesFiltrados.length) : 0}</p> */}
        </div>
    );

    // return (
    //     <div>
    //         <p>
    //             Nombre del País: <input type="text" name="pais" value={pais} onChange={handlerpais} />
    //         </p>
    //         <button className='btn btn-primary' onClick={query}>Buscar</button>
    //         <TableClientes data={clientesFiltrados} titulo={Clientes del país: ${pais}} />
    //     </div>
    // );
};

export default Clientes_Pais;
