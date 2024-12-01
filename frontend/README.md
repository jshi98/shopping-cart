# Shopping Cart Application

A full-stack shopping cart application with Spring Boot backend and React TypeScript frontend.

## Project Structure
shopping-cart/
├── backend/  (Spring Boot)
└── frontend/ (React)

## Backend (Spring Boot)

### Technologies Used
- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database

### Running Backend ###API ENDpoints
```bash
cd backend
./mvnw spring-boot:run

Server runs on http://localhost:8080


API Endpoints
GET /api/items - Get all items
POST /api/items - Create new item
GET /api/cart/{customerName} - Get user's cart
POST /api/cart/{customerName}/items/{itemId} - Add item to cart


Frontend (React)
Technologies Used

React 18
TypeScript
Axios
Chakra UI

Running Frontend
cd frontend
npm install
npm start

Application runs on http://localhost:3001