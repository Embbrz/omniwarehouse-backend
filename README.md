# OmniWarehouse — Global Inventory & Order Fulfillment Engine

OmniWarehouse is an enterprise-grade backend RESTful web service engineered using **Java 21**, **Spring Boot 3+**, **Spring Data JPA**, and **PostgreSQL**. The application models a high-demand inventory management and order fulfillment distribution system, supporting real-time stock allocation, dynamic pagination, and robust error handling.

---

## Key Features

- **Strict 4-Tier Backend Architecture**: Clean separation of concerns across Entity, Repository, Service, and Controller layers.
- **Dynamic Pagination & Sorting**: High-performance inventory browsing powered by Spring Data JPA's `Pageable` and `Page<T>` interface.
- **Order Fulfillment Engine**: Transactional logic ensuring real-time stock deduction with defensive validation against insufficient inventory.
- **Restock & Product Lifecycle Management**: Scalable endpoints (`POST`, `PUT`, `GET`, `DELETE`) for managing global product supply chains.
- **Modern DTO Records**: Safe request payload mapping utilizing modern Java Records and Jackson `@JsonProperty` annotations.
- **Defensive Error Handling**: Exception-driven handling returning standardized REST responses for missing entities or invalid stock requests.

---

## Tech Stack & Tooling

| Component | Technology |
| :--- | :--- |
| **Language** | Java 21 |
| **Framework** | Spring Boot |
| **Persistence** | Spring Data JPA / Hibernate |
| **Database** | PostgreSQL |
| **Build Tool** | Apache Maven |
| **Data Reduction** | Lombok & Java Records |
| **API Testing** | Postman / cURL |
| **Version Control** | Git & GitHub |

---

## REST API Specifications (`/api/inventory-items`)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/inventory-items` | Fetch paginated inventory (`?page=0&size=5`) |
| **GET** | `/api/inventory-items/getItem/{id}` | Fetch specific inventory item by ID |
| **GET** | `/api/inventory-items/getItemName/{itemName}` | Search inventory items by name |
| **POST** | `/api/inventory-items/addItem` | Create a new inventory record |
| **PUT** | `/api/inventory-items/fulfill` | Deduct requested quantity from stock |
| **PUT** | `/api/inventory-items/restock` | Replenish item stock level |
| **DELETE** | `/api/inventory-items/deleteItemById/{id}` | Remove inventory item by ID |

---

## Request Payload Examples

### 1. Add New Item (`POST /api/inventory-items/addItem`)
```json
{
  "sku": "ELEC-9082",
  "itemName": "Mechanical Keyboard",
  "unitPrice": 129.99,
  "quantityAvailable": 50,
  "category": "Electronics"
}
2. Fulfill Order (PUT /api/inventory-items/fulfill)
JSON
{
  "itemId": 1,
  "quantityRequested": 5
}
3. Restock Item (PUT /api/inventory-items/restock)
JSON
{
  "itemId": 1,
  "quantityToAddToStock": 20
}
How to Run Locally
Prerequisites
JDK 17+ or JDK 21

PostgreSQL Installed & Running

Apache Maven

Installation Steps
Clone the repository:

Bash
git clone [https://github.com/Embbrz/omniwarehouse-backend.git](https://github.com/Embbrz/omniwarehouse-backend.git)
cd omniwarehouse-backend

Configure Database Settings:
Update src/main/resources/application.properties with your PostgreSQL credentials:

Properties
spring.datasource.url=jdbc:postgresql://localhost:5432/omniwarehouse_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Build & Run:

Bash
mvn clean install
mvn spring-boot:run