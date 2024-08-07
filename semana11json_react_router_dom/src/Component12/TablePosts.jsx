//rsc
import React from 'react';

const TablePosts = () => {
    // Implementación de la tabla con los props
    const {data,titulo} = this.props;

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
                            <td>{post.Id}</td>
                            <td>{post.userId}</td>
                            <td>{post.Title}</td>
                            <td>{post.Body}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default TablePosts;