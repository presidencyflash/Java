-- Q2: Create database userDB and table user
-- Run these commands in your MySQL client before executing JDBC programs

CREATE DATABASE USERDB;

USE USERDB;

CREATE TABLE USER (
    id VARCHAR(30) NOT NULL PRIMARY KEY,
    pwd VARCHAR(30) NOT NULL,
    fullname VARCHAR(50),
    email VARCHAR(50)
);

-- Verify table structure
DESCRIBE USER;
