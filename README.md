# 📦 Order Management System 

![Project State](https://img.shields.io/badge/Project_State-Complete-00F0FF?style=for-the-badge)
![Architecture](https://img.shields.io/badge/Architecture-Layered_Architecture-purple?style=for-the-badge)

A clean and production-ready Spring Boot backend application built to manage users, customers, items, and relational order processing using Spring Data JPA and MySQL.

---

### 🗺️ Request Flow Architecture

```text
 🌐 Client (Postman) ──> 🎮 Controller ──> 🧠 Service (DTO) ──> 🗂️ Repository ──> 𛛢 MySQL DB
```
---

### 📊 Backend Core Implementation Progress

#### 🔐 01. User Account Module (100% COMPLETE)
* Configured core user authentication schemas.
* Implemented full REST endpoints for User mapping.
* Verified JSON data payloads successfully via Postman.

#### 👥 02. Customer Registry Module (100% COMPLETE)
* Developed full CRUD endpoints (Controller, Service, Repository).
* Isolated data persistence layers using structured Data Transfer Objects (DTOs).
* Handled client registration and relational profile data tracking.

#### 📦 03. Item Inventory Module (100% COMPLETE)
* Built item management controllers and database repository wiring.
* Mapped complete product catalogs, prices, and live stock counts.
* Standardized REST API custom responses for seamless frontend integration.

---

### 💻 Package Workspace Distribution

```text
📁 src/main/java/com/nrl/ordermanagement
│
├── 📁 controller   --> Handles inbound HTTP REST requests
├── 📁 service      --> Manages core business logic and contracts
├── 📁 repository   --> Executes JPA queries on MySQL database
└── 📁 dto          --> Stateless Data Transfer Objects
```
### 🛠️ Infrastructure Configuration

* **Core Language:** Java (OpenJDK)
* **Framework:** Spring Boot, Spring Data JPA
* **Database:** MySQL Engine
* **API Testing Tool:** Postman Client

---

### 👩‍💻 System Architect

* **Induni Palliyaguru** - Software Engineering Undergraduate
* **LinkedIn:** [Connect on LinkedIn](https://www.linkedin.com/in/induni-palliyaguru-6195a9371)
* **GitHub:** [@InduniPalliyaguru](https://github.com/InduniPalliyaguru)
