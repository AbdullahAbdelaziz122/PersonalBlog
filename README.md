# Personal Blogging Platform API

## Overview

This project is a **Personal Blogging Platform API**, designed to handle the backend functionalities of a personal blog. It provides a set of RESTful endpoints for managing blog articles, covering all the basic CRUD (Create, Read, Update, Delete) operations.

## Features

- **List Articles**: Retrieve a list of all blog articles with optional filters such as publishing date or tags.
- **View Single Article**: Fetch the details of a specific article by its unique ID.
- **Create Article**: Add new articles to the blog.
- **Update Article**: Modify an existing article's content or metadata by its ID.
- **Delete Article**: Remove an article from the blog by its ID.

## Tech Stack

- **Backend Framework**: 
  - [Spring Boot](https://spring.io/) (Java)

- **Database**: 
  - **SQL**: [MySQL](https://www.mysql.com/)

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/AbdullahAbdelaziz/personal-blogging-platform-api.git
   cd personal-blogging-platform-api
   ```

2. **Install Dependencies**:
   ```bash
          <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-devtools</artifactId>
      <scope>runtime</scope>
      <optional>true</optional>
    </dependency>
    <dependency>
      <groupId>com.mysql</groupId>
      <artifactId>mysql-connector-j</artifactId>
      <scope>runtime</scope>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
    </dependency>
```

3. **Set Up the Database**:
   - For MySQL:
     - Create a MySQL database and configure the connection settings in the project.


## Usage

### API Endpoints

- **GET** `/articles`: Retrieve a list of all articles.
- **GET** `/articles/:id`: Get a specific article by ID.
- **POST** `/articles`: Create a new article.
- **PUT** `/articles/:id`: Update an existing article by ID.
- **DELETE** `/articles/:id`: Delete an article by ID.

## Contribution

Feel free to fork this repository and submit pull requests. Any contributions that can enhance the functionality or add new features are welcome.


This README gives a comprehensive overview of the project and provides clear instructions for installation and usage.