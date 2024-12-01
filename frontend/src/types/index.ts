export interface Item {
    id?: number;
    name: string; 
    description: string;
    price: number;
    quantity: number;
}

export interface Cart {
    id?: number;
    customerName: string;
    currentDate: string;
    cartItems: Item[];
}