import React, { useState, useEffect } from 'react';
import { createClient, getClientById, updateClient } from '../services/ClientService';
import { useNavigate, useParams } from 'react-router-dom';

const ClientForm = () => {
  const [name, setName] = useState('');
  const [cpf, setCpf] = useState('');
  const [age, setAge] = useState('');
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id) {
      getClientById(id)
        .then(response => {
          setName(response.data.name);
          setCpf(response.data.cpf);
          setAge(response.data.age);
        })
        .catch(error => console.error('Erro ao listar os clientes:', error));
    }
  }, [id]);

  const handleSubmit = (event) => {
    event.preventDefault();
    const client = { name, cpf, age };

    if (id) {
      updateClient(id, client)
        .then(() => navigate('/'))
        .catch(error => console.error('Erro ao atualizar o cliente:', error));
    } else {
      createClient(client)
        .then(() => navigate('/'))
        .catch(error => console.error('Erro ao adicionar novo cliente:', error));
    }
  };

  return (
    <div className="container">
      <h2>{id ? 'Editar Cliente' : 'Adicionar Novo Cliente'}</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="name" className="form-label">Nome</label>
          <input
            type="text"
            className="form-control"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="cpf" className="form-label">CPF</label>
          <input
            type="text"
            className="form-control"
            id="cpf"
            value={cpf}
            onChange={(e) => setCpf(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="age" className="form-label">Idade</label>
          <input
            type="number"
            className="form-control"
            id="age"
            value={age}
            onChange={(e) => setAge(e.target.value)}
          />
        </div>
        <button type="submit" className="btn btn-primary">
          {id ? 'Atualizar' : 'Adicionar'}
        </button>
      </form>
    </div>
  );
};

export default ClientForm;

