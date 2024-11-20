
# **PruebaBackend Application**

## **Overview**

PruebaBackend is a Spring Boot application designed to manage products and orders using a simple, clean architecture. It supports CRUD operations for products, order generation, and includes a user-friendly web interface built with Thymeleaf and styled with CSS.

---

## **Technologies Used**

### Backend

- **Java 21**
- **Spring Boot 3.x**:
  - Spring Web (for controllers and REST endpoints)
  - Spring Data JPA (for database interactions)
- **PostgreSQL**: Relational database for data persistence.
- **Flyway**: Database migration management.
- **Maven**: Dependency management and build tool.

### Frontend

- **Thymeleaf**: HTML template engine for rendering dynamic content.
- **CSS**: For styling and enhancing the user interface.

---

## **Architecture**

The application follows a **layered architecture**:

1. **Controller Layer**:
   - Handles HTTP requests and returns views or redirects.
   - Example: `ProductController` and `OrderController`.

2. **Service Layer**:
   - Contains business logic.
   - Example: `ProductServiceImpl` and `OrderServiceImpl`.

3. **Repository Layer**:
   - Interacts with the database using JPA.
   - Example: `ProductRepository` and `OrderRepository`.

4. **Entity Layer**:
   - Defines the data model.
   - Example: `Product` and `Order` entities.

5. **DTOs and Mappers**:
   - **DTOs**: Transfer data between layers.
   - **Mappers**: Convert entities to DTOs and vice versa.

---

## **How It Works**

### **Features**

1. **Products**:
   - View all products.
   - Add new products.
   - Remove existing products.

2. **Orders**:
   - View all orders.
   - Generate orders by selecting a product.

### **Endpoints**

| **Feature**         | **Method** | **URL**                    | **Description**                   |
|----------------------|------------|----------------------------|-----------------------------------|
| View Products        | `GET`      | `/products`                | List all products.               |
| Add Product          | `POST`     | `/products/add`            | Add a new product.               |
| Remove Product       | `POST`     | `/products/remove/{id}`    | Remove a product by ID.          |
| View Orders          | `GET`      | `/orders`                  | List all orders.                 |
| Generate Order       | `POST`     | `/orders/generate`         | Generate a new order.            |

### **Links for Access**

1. **Products**: [http://localhost:8080/products](http://localhost:8080/products)
2. **Orders**: [http://localhost:8080/orders](http://localhost:8080/orders)

---

## **Setup and Installation**

### Prerequisites

- **Java 21** installed.
- **PostgreSQL** installed and running.
- **Maven** installed.

### Steps

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-repository/prueba-backend.git
   cd prueba-backend
   ```

2. **Configure the database**:
   - Create a PostgreSQL database named `prueba_backend`.
   - Update `application.properties` with your database credentials:

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/prueba_backend
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```

3. **Run migrations with Flyway**:
   - Flyway will automatically create tables and insert initial data when the application starts.

4. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```

5. **Access the application**:
   - Products: [http://localhost:8080/products](http://localhost:8080/products)
   - Orders: [http://localhost:8080/orders](http://localhost:8080/orders)

---

## **Project Structure**

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── Symplifica/PruebaBackend/
│   │   │   ├── Controller/
│   │   │   │   ├── ProductController.java
│   │   │   │   ├── OrderController.java
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   ├── Services/
│   │   │   │   ├── ProductService.java
│   │   │   │   ├── ProductServiceImpl.java
│   │   │   │   ├── OrderService.java
│   │   │   │   ├── OrderServiceImpl.java
│   │   │   ├── Repository/
│   │   │   │   ├── ProductRepository.java
│   │   │   │   ├── OrderRepository.java
│   │   │   ├── Entity/
│   │   │   │   ├── Product.java
│   │   │   │   ├── Order.java
│   │   │   ├── DTO/
│   │   │   │   ├── ProductDto.java
│   │   │   │   ├── OrderDto.java
│   │   │   ├── Mapper/
│   │   │   │   ├── ProductMapper.java
│   │   │   │   ├── OrderMapper.java
├── resources/
│   ├── static/
│   │   ├── css/
│   │   │   ├── styles.css
│   ├── templates/
│   │   ├── index.html
│   │   ├── products.html
│   │   ├── orders.html
│   │   ├── error.html
│   ├── db/
│   │   ├── migration/
│   │   │   ├── V1__Create_Tables.sql
│   │   │   ├── V2__Insert_Initial_Data.sql
│   ├── application.properties
```

---

## **Database Schema**

- **Products Table**:

  ```sql
  CREATE TABLE products (
      id SERIAL PRIMARY KEY,
      name VARCHAR(255),
      description VARCHAR(255),
      price VARCHAR(50),
      current_stock INT
  );
  ```

- **Orders Table**:

  ```sql
  CREATE TABLE orders (
      id SERIAL PRIMARY KEY,
      product_id INT,
      FOREIGN KEY (product_id) REFERENCES products (id)
  );
  ```

---

## **How It Works**

### Products

- Users can add, view, and delete products from the **Products** page.
- Each product has fields: `name`, `description`, `price`, and `currentStock`.

### Orders

- Users can generate an order by selecting a product from the dropdown in the **Orders** page.
- The application ensures all required data (like `productId`) is validated before processing.

---

## **Styling**

The UI is styled using CSS for better usability:

- **Tables**: Responsive with alternating row colors.
- **Forms**: Modern design with rounded inputs and buttons.

---
