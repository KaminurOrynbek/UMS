CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(20) NOT NULL
);

CREATE TABLE students (
                          id BIGSERIAL PRIMARY KEY,
                          user_id BIGINT UNIQUE NOT NULL,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE courses (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(100) NOT NULL,
                         start_date DATE NOT NULL
);

CREATE TABLE enrollments (
                             id BIGSERIAL PRIMARY KEY,
                             student_id BIGINT NOT NULL,
                             course_id BIGINT NOT NULL,
                             enrollment_date DATE NOT NULL,
                             FOREIGN KEY (student_id) REFERENCES students(id),
                             FOREIGN KEY (course_id) REFERENCES courses(id)
);