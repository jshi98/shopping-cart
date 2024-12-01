import React from 'react';
import { ItemList } from './components/ItemList';
import { Cart } from './components/Cart';  
import './App.css';

function App() {
  return (
    <div className="App">
      <header style={{
        backgroundColor: '#333',
        color: 'white',
        padding: '1rem',
        marginBottom: '2rem'
      }}>
        <h1>E-Commerce Store</h1>
      </header>
      <div style={{
        display: 'grid',
        gridTemplateColumns: '2fr 1fr',
        gap: '2rem',
        padding: '0 2rem'
      }}>
        <ItemList />
        <Cart />
      </div>
    </div>
  );
}

export default App;