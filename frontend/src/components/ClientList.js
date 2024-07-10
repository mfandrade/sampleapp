import React, { useState, useEffect } from 'react';
import { getClients, deleteClient } from '../services/ClientService';
import { Link } from 'react-router-dom';

const ClientList = () => {
  const [clients, setClients] = useState([]);

  useEffect(() => {
    getClients()
      .then((response) => setClients(response.data))
      .catch((error) => console.error('Erro ao listar os clientes:', error));
  }, []);

  const handleDelete = (id) => {
    if (window.confirm('Deseja deletar este cliente?')) {
      deleteClient(id)
        .then(() => setClients(clients.filter(client => client.cod !== id)))
        .catch((error) => console.error('Erro ao deletar o cliente:', error));
    }
  };

  return (
    <div className="container">
      <h2>Client List</h2>
      <Link to="/add" className="btn btn-primary mb-2">Adicionar Novo Cliente</Link>
      <table className="table">
        <thead>
          <tr>
            <th>Cod</th>
            <th>Nome</th>
            <th>CPF</th>
            <th>Idade</th>
            <th>&nbsp;</th>
          </tr>
        </thead>
        <tbody>
          {clients.map(client => (
            <tr key={client.cod}>
              <td>{client.cod}</td>
              <td>{client.name}</td>
              <td>{client.cpf}</td>
              <td>{client.age}</td>
              <td>
                <Link to={`/edit/${client.cod}`} className="btn btn-warning btn-sm me-2">Edit</Link>
                <button onClick={() => handleDelete(client.cod)} className="btn btn-danger btn-sm">Deletar</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ClientList;

