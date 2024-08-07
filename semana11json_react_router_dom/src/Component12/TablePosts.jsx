//rsc
import React from 'react';

const TablePosts = (props) => {
    // Implementación de la tabla con los props
    const {data,titulo} = props;

    return (
        <div>
            <h1>{titulo}</h1>
            <table className='table table-striped'>
                <thead className='table-dark'>
                    <tr>
                        <th>Id</th>
                        <th>userId</th>
                        <th>Title</th>
                        <th>Body</th>
                    </tr>
                </thead>
                <tbody>
                    {data.map((post, index) => (
                        <tr key={index}>
                            <td>{post.id}</td>
                            <td>{post.userId}</td>
                            <td>{post.title}</td>
                            <td>{post.body}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default TablePosts;