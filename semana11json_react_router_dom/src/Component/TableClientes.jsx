import React from 'react';
import { Link } from 'react-router-dom';

const TableClientes = (props) => {
    // Recuperar las variables 'props' enviadas desde el componente padre
    const { data, titulo } = props;

    return (
        <div>
            <Link to="/" className="btn btn-primary">Inicio</Link>
            <h2>{titulo}</h2>
            <table className='table table-striped'>
                <thead className='table-dark'>
                    <tr>
                        <th>#</th>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Celular</th>
                        <th>País</th>
                        <th>Imagen</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((item, index) => (
                        <tr key='{index}'>
                            <td>{index + 1}</td>
                            <td>{item.codcli}</td>
                            <td>{item.nomcli}</td>
                            <td>{item.celular}</td>
                            <td>{item.pais}</td>
                            <td>
                                <img src={item.imgcli} width='80px' height='80px'/>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <div className='alert alert-primary'>
                <p>
                    <b>Cant. De clientes: {data.length}</b>
                </p>
            </div>
        </div>
    );
};

export default TableClientes;