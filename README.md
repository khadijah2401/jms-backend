# Coin Change API – JMS Backend

This is the backend service for the JMS Coin Change Calculator. Built with Spring Boot, it exposes a simple RESTful API that determines the minimum number of coins needed to make up a given amount, using a greedy algorithm.

---

## Tech Stack

- Java 17  
- Spring Boot 3  
- Maven  
- NGINX (reverse proxy)  
- HTTPS via Let's Encrypt  
- Deployed on AWS EC2 (Ubuntu)

---

## Getting Started

### 1. Clone the Repository

```

git clone [https://github.com/khadiijah2401/jms-backend.git](https://github.com/khadiijah2401/jms-backend.git)
cd jms-backend/backend

```

### 2. Build the Project

```

mvn clean package

```

### 3. Run the Application

Development mode:

```

mvn spring-boot\:run

```

Production mode (background):

```

nohup mvn spring-boot\:run &

````

---

## API Usage

**POST** `/api/change`

### Request Example

```json
{
  "targetAmount": 30.0,
  "denominations": [25.0, 10.0, 5.0]
}
````

### Response Example

```json
{
  "coins": [5.0, 25.0]
}
```

---

## Deployment Details

* Hosted on AWS EC2 (Ubuntu)
* Public endpoint: `https://khadiijah.duckdns.org`
* NGINX handles HTTPS (port 443) and proxies to Spring Boot (port 8080)
* SSL certificates are managed via Let’s Encrypt (Certbot)

---

## How It Works

* Parses the amount and available denominations from the request
* Sorts denominations in descending order
* Applies a greedy algorithm to select coins
* Returns the selected coins, sorted in ascending order

---

## Contact

Questions? Suggestions? Reach out on GitHub → [@khadiijah2401](https://github.com/khadiijah2401)
