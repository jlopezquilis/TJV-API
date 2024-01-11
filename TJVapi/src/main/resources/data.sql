-- Insert 10 courses
INSERT INTO course (id, name, capacity, credits) VALUES
                                                     (1, 'Introduction to Programming', 30, 4),
                                                     (2, 'Advanced Mathematics', 25, 3),
                                                     (3, 'Principles of Economics', 30, 4),
                                                     (4, 'World History', 35, 3),
                                                     (5, 'Biology 101', 40, 4),
                                                     (6, 'Introduction to Philosophy', 25, 3),
                                                     (7, 'Social Psychology', 30, 4),
                                                     (8, 'Business Management', 35, 3),
                                                     (9, 'Environmental Science', 30, 3),
                                                     (10, 'Modern Literature', 25, 4);

-- Insert 10 teachers
INSERT INTO teacher (id, name, department) VALUES
                                               (1, 'John Smith', 'Computer Science'),
                                               (2, 'Jane Doe', 'Mathematics'),
                                               (3, 'Emily Johnson', 'Economics'),
                                               (4, 'Michael Brown', 'History'),
                                               (5, 'Rachel Garcia', 'Biology'),
                                               (6, 'Daniel Davis', 'Philosophy'),
                                               (7, 'Laura Miller', 'Psychology'),
                                               (8, 'Robert Wilson', 'Business'),
                                               (9, 'Sarah Moore', 'Environmental Sciences'),
                                               (10, 'James Taylor', 'English');

-- Insert 20 students
INSERT INTO student (id, name, age) VALUES
                                        (1, 'Alice Johnson', 20),
                                        (2, 'Bob Brown', 21),
                                        (3, 'Charlie Davis', 22),
                                        (4, 'Diana Evans', 23),
                                        (5, 'Ethan Smith', 20),
                                        (6, 'Fiona Clark', 21),
                                        (7, 'George Wilson', 22),
                                        (8, 'Hannah Martin', 23),
                                        (9, 'Ian Thompson', 20),
                                        (10, 'Julia Scott', 21),
                                        (11, 'Kevin Lopez', 22),
                                        (12, 'Lily White', 23),
                                        (13, 'Mason Harris', 20),
                                        (14, 'Nora Sanchez', 21),
                                        (15, 'Oscar Martinez', 22),
                                        (16, 'Penelope Lewis', 23),
                                        (17, 'Quincy Allen', 20),
                                        (18, 'Ruby Hall', 21),
                                        (19, 'Steve Young', 22),
                                        (20, 'Tina King', 23);

-- Enroll students in courses
-- Ensure that the course capacity is not exceeded
INSERT INTO course_student (course_id, student_id) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (2, 3),
                                                       (2, 4),
                                                       (3, 5),
                                                       (3, 6),
                                                       (4, 7),
                                                       (4, 8),
                                                       (5, 9),
                                                       (5, 10),
                                                       (6, 11),
                                                       (6, 12),
                                                       (7, 13),
                                                       (7, 14),
                                                       (8, 15),
                                                       (8, 16),
                                                       (9, 17),
                                                       (9, 18),
                                                       (10, 19),
                                                       (10, 20);
