import axios from 'axios';
import { Item, Cart } from '../types';

const API_BASE_URL = 'http://localhost:8080/api';

export const api = {
    getItems: () => axios.get<Item[]>(`${API_BASE_URL}/items`),
    addItem: (item: Item) => axios.post<Item>(`${API_BASE_URL}/items`, item),
    getCart: (customerName: string) => axios.get<Cart>(`${API_BASE_URL}/cart/${customerName}`),
    addToCart: (customerName: string, itemId: number, quantity: number) => 
        axios.post<Cart>(`${API_BASE_URL}/cart/${customerName}/items/${itemId}?quantity=${quantity}`)
};