CREATE DATABASE IF NOT EXISTS StudentDB;

USE StudentDB;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    roll_number INT NOT NULL
);
