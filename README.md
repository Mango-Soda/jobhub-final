# JobHub - Job Vacancy Management API

JobHub is an API developed in Java with Spring Boot, designed to manage job vacancies. It allows the creation, search, and filtering of job postings based on various parameters.

## Technologies Used
- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database (for development)**
- **PostgreSQL (for production)**

## How to Run the Project Locally

1. **Clone the repository**
    ```bash
    git clone https://github.com/your-username/jobhub.git
    ```

2. **Navigate to the project directory**
    ```bash
    cd jobhub
    ```

3. **Build and run the project with Maven**
    ```bash
    mvn spring-boot:run
    ```

    The server will start at `http://localhost:8080`.

## API Endpoints

### 1. Create a job vacancy
- **Method**: `POST`
- **Endpoint**: `/vacancies`
- **Request body example (JSON)**:
    ```json
    {
        "title": "Software Engineer",
        "companyName": "Tech Company",
        "location": "New York",
        "salary": 120000.0,
        "remote": true,
        "technologies": ["Java", "Spring Boot"]
    }
    ```

### 2. Get all vacancies
- **Method**: `GET`
- **Endpoint**: `/vacancies`
- **Description**: Returns all registered job vacancies.

### 3. Get vacancy by ID
- **Method**: `GET`
- **Endpoint**: `/vacancies/id`
- **Parameters**: `id` (vacancy ID)
- **Example**: `GET /vacancies?id=1`

### 4. Filter vacancies with parameters
- **Method**: `GET`
- **Endpoint**: `/vacancies/search`
- **Parameters**:
  - `title` (optional)
  - `company` (optional)
  - `location` (optional)
  - `minSalary` (optional)
  - `remote` (optional)
  - `technology` (optional)
- **Example**:
`GET /vacancies/search?title=Software&company=Tech&technology=Java`

## How to Test

Use **Postman** or any other tool of your choice to test the endpoints. Make sure to send the correct parameters when testing filtered searches.

---