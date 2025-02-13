# 🛒 Cart Service

## 📌 Overview
The **Cart Service** is a backend microservice designed to handle shopping cart operations using **AWS DynamoDB** as a NoSQL database. It provides functionalities to add and remove items, manage user carts, and ensure a seamless shopping experience.

## 🚀 Features
- **Add Item to Cart** – Add a product to a user's cart.
- **Create a New Cart** – Initialize a new cart for a user.
- **Delete Item from Cart** – Remove a specific item from a cart.
- **Delete Cart** – Remove all items from a user's cart.
- **AWS DynamoDB Integration** – Ensures high availability and scalability.
- **RESTful API** – Exposes endpoints for easy integration with frontend applications.

## 🏗️ Project Structure
```
src/
│── main/
│   ├── controller/
│   │   ├── CartController.java
│   │   ├── ItemController.java
│   ├── service/
│   │   ├── CartService.java
│   │   ├── ItemService.java
│   ├── repository/
│   │   ├── CartRepository.java
│   │   ├── ItemRepository.java
│   ├── model/
│   │   ├── Cart.java
│   │   ├── Item.java
│── resources/
│   ├── application.yml
```

## 🔧 Technologies Used
- **Java (Spring Boot)** – Core backend framework.
- **AWS DynamoDB** – NoSQL database for scalable storage.
- **AWS SDK for Java** – To interact with DynamoDB.
- **Gradle Kotlin DSL (gradle.kts)** – Build automation.
- **Docker** – Containerized deployment.
- **REST API** – Communication layer.

## 🛠️ Setup Instructions
### Prerequisites
- Java 11+
- Gradle (Kotlin DSL - `gradle.kts`)
- AWS DynamoDB (Local or Cloud)
- Docker (optional)

### Steps to Run Locally
1. **Clone the repository**
   ```sh
   git clone https://github.com/yourusername/cart_service.git
   cd cart_service
   ```
2. **Build the project**
   ```sh
   ./gradlew build
   ```
3. **Run using Docker Compose** (if applicable)
   ```sh
   docker-compose up -d
   ```
4. **Run locally using Gradle**
   ```sh
   ./gradlew bootRun
   ```

## 📖 Notes
- Ensure **AWS credentials** are configured for DynamoDB access.
- Use **AWS DynamoDB Local** for local development.
- Set up **CORS policies** if integrating with a frontend.

## 🤝 Contributing
Contributions are welcome! Please create an issue or submit a pull request.

## 📜 License
This project is licensed under the MIT License.

---
Maintained by **Lesley ZH & Team** 🚀

