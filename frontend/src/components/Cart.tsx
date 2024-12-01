import React, { useEffect, useState } from 'react';
import { Item } from '../types';

interface CartType {
    id?: number;
    customerName: string;
    cartItems: Item[];
}

export const Cart = () => {
    const [cart, setCart] = useState<CartType | null>(null);

    useEffect(() => {
        fetch('http://localhost:8080/api/cart/defaultUser')
            .then(response => response.json())
            .then(data => setCart(data))
            .catch(error => console.error('Error loading cart:', error));
    }, []);

    const calculateTotal = () => {
        if (!cart) return 0;
        return cart.cartItems.reduce((total, item) => total + (item.price * item.quantity), 0);
    };

    if (!cart) return <div>Loading cart...</div>;

    return (
        <div style={{ 
            padding: '20px',
            backgroundColor: '#f8f9fa',
            borderRadius: '10px',
            boxShadow: '0 2px 5px rgba(0,0,0,0.05)'
        }}>
            <h2 style={{ 
                color: '#2c3e50',
                borderBottom: '2px solid #e1e8ed',
                paddingBottom: '10px',
                marginBottom: '20px'
            }}>Shopping Cart</h2>
            {cart.cartItems.map((item, index) => (
                <div key={index} style={{
                    backgroundColor: 'white',
                    border: '1px solid #e1e8ed',
                    padding: '15px',
                    margin: '10px 0',
                    borderRadius: '8px',
                    boxShadow: '0 1px 3px rgba(0,0,0,0.05)'
                }}>
                    <h3 style={{ color: '#2c3e50', marginBottom: '10px' }}>{item.name}</h3>
                    <div style={{ 
                        display: 'flex', 
                        justifyContent: 'space-between',
                        alignItems: 'center'
                    }}>
                        <p style={{ color: '#7f8c8d' }}>Quantity: {item.quantity}</p>
                        <p style={{ color: '#2980b9', fontWeight: 'bold' }}>
                            ${(item.price * item.quantity).toFixed(2)}
                        </p>
                    </div>
                </div>
            ))}
            <div style={{
                borderTop: '2px solid #e1e8ed',
                marginTop: '20px',
                paddingTop: '20px',
                textAlign: 'right'
            }}>
                <h3 style={{ color: '#2c3e50' }}>
                    Total: ${calculateTotal().toFixed(2)}
                </h3>
            </div>
        </div>
    );
};