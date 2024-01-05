-- Table for storing students
CREATE TABLE IF NOT EXISTS students (
                          id INT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          age INT NOT NULL
);

-- Table for storing teachers
CREATE TABLE IF NOT EXISTS teachers (
                          id INT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          department VARCHAR(255) NOT NULL
);

-- Table for storing courses
CREATE TABLE IF NOT EXISTS courses (
                         id INT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         credits INT NOT NULL,
                         capacity INT NOT NULL
);

-- Table for storing the relationship between students and courses (many-to-many)
CREATE TABLE IF NOT EXISTS student_courses (
                                 student_id INT,
                                 course_id INT,
                                 PRIMARY KEY (student_id, course_id),
                                 FOREIGN KEY (student_id) REFERENCES student (id),
                                 FOREIGN KEY (course_id) REFERENCES course (id)
);

-- Table for storing the relationship between teachers and courses (one-to-many)
CREATE TABLE IF NOT EXISTS teacher_courses (
                                 teacher_id INT,
                                 course_id INT,
                                 PRIMARY KEY (teacher_id, course_id),
                                 FOREIGN KEY (teacher_id) REFERENCES teacher (id),
                                 FOREIGN KEY (course_id) REFERENCES course (id)
);

ALTER TABLE course
    ADD COLUMN teacher_id INT;

CREATE SEQUENCE course_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE student_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE teacher_seq START WITH 1 INCREMENT BY 1;

