import React, { useEffect, useState } from 'react';

interface Item {
    id?: number;
    name: string;
    description: string;
    price: number;
    quantity: number;
}

export const ItemList = () => {
    const [items, setItems] = useState<Item[]>([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/items')
            .then(response => response.json())
            .then(data => setItems(data))
            .catch(error => console.error('Error:', error));
    }, []);

    const handleAddToCart = async (itemId: number) => {
        try {
            await fetch(`http://localhost:8080/api/cart/defaultUser/items/${itemId}?quantity=1`, {
                method: 'POST'
            });
            alert('Item added to cart!');
        } catch (error) {
            console.error('Error adding to cart:', error);
        }
    };

    return (
        <div style={{ padding: '20px' }}>
            <h2 style={{ 
                color: '#2c3e50',
                borderBottom: '2px solid #eee',
                paddingBottom: '10px',
                marginBottom: '20px'
            }}>Available Items</h2>
            <div style={{ 
                display: 'grid', 
                gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))',
                gap: '20px',
                padding: '10px'
            }}>
                {items.map(item => (
                    <div key={item.id} style={{ 
                        border: '1px solid #e1e8ed',
                        borderRadius: '10px',
                        padding: '20px',
                        textAlign: 'center',
                        backgroundColor: 'white',
                        boxShadow: '0 2px 5px rgba(0,0,0,0.05)',
                        transition: 'transform 0.2s, box-shadow 0.2s',
                        cursor: 'pointer',
                    }}>
                        <h3 style={{ color: '#2c3e50', marginBottom: '10px' }}>{item.name}</h3>
                        <p style={{ color: '#7f8c8d', marginBottom: '15px' }}>{item.description}</p>
                        <p style={{ 
                            fontSize: '24px', 
                            color: '#2980b9', 
                            fontWeight: 'bold',
                            marginBottom: '20px'
                        }}>${item.price}</p>
                        <button 
                            onClick={() => item.id && handleAddToCart(item.id)}
                            style={{
                                backgroundColor: '#3498db',
                                color: 'white',
                                border: 'none',
                                padding: '10px 20px',
                                borderRadius: '5px',
                                cursor: 'pointer',
                                transition: 'background-color 0.2s',
                                width: '100%',
                            }}
                        >
                            Add to Cart
                        </button>
                    </div>
                ))}
            </div>
        </div>
    );
};