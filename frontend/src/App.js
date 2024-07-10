import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import ClientList from './components/ClientList';
import ClientForm from './components/ClientForm';

const App = () => (
  <Router>
    <Routes>
      <Route path="/" element={<ClientList />} />
      <Route path="/add" element={<ClientForm />} />
      <Route path="/edit/:id" element={<ClientForm />} />
    </Routes>
  </Router>
);

export default App;

