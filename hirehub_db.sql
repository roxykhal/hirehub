--- Create Database
CREATE Database IF NOT EXISTS hirehub_db;
USE hirehub_db;

--=======================================
-- 1. Users Table (Internal Staff)
--=======================================

CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP

    -- ENUM is a special data type used to define a column that can only store one value from a predefined list of options--
    role ENUM('ADMIN', 'RECRUITER', 'HIRING MANAGER', 'INTERVIEWER') NOT NULL;


)