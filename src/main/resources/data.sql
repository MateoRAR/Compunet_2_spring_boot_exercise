ALTER TABLE students ALTER COLUMN id SET DEFAULT nextval('students_id_seq');
ALTER TABLE professors ALTER COLUMN id SET DEFAULT nextval('professors_id_seq');
ALTER TABLE courses ALTER COLUMN id SET DEFAULT nextval('courses_id_seq');
ALTER TABLE enrollments ALTER COLUMN id SET DEFAULT nextval('enrollments_id_seq');

INSERT INTO csbe_users (id, email, password, username)
VALUES (1, 'pengu@edu.co', '$2a$12$LE5wWF2zJKLfE98E4KgJPO.buVfS0xHlSg2F2ciQMnk5kdgEBx506', 'alfa'),
       (2, 'estudiante@gmail.com', '$2a$12$LE5wWF2zJKLfE98E4KgJPO.buVfS0xHlSg2F2ciQMnk5kdgEBx506', 'tuden'),
       (3, 'profesor@gmail.com', '$2a$12$LE5wWF2zJKLfE98E4KgJPO.buVfS0xHlSg2F2ciQMnk5kdgEBx506', 'ticher');

-- Insertar roles
INSERT INTO csbe_roles (id, name)
VALUES (1, 'ROLE_STUDENT'),
       (2, 'ROLE_PROFESSOR');

-- Definir relaciones
INSERT INTO user_roles (user_id, role_id)
VALUES (2, 1),
       (3, 2);




-- Insertar estudiantes sin especificar ID
INSERT INTO students (code, name, program)
VALUES ('A00001', 'Juan Pérez', 'SIS'),
       ('A00002', 'María Gómez', 'SIS'),
       ('A00003', 'Miguel Rodríguez', 'TEL'),
       ('A00004', 'Lucía Fernández', 'DMI'),
       ('A00005', 'Daniela Ramírez', 'TEL'),
       ('A00006', 'Santiago Morales', 'SIS'),
       ('A00007', 'Valentina Castro', 'DMI'),
       ('A00008', 'Carlos Méndez', 'SIS'),
       ('A00009', 'Javier Ortega', 'IBQ'),
       ('A00010', 'Camila Rojas', 'MED'),
       ('A00011', 'Andrés Herrera', 'ENI'),
       ('A00012', 'Natalia Vargas', 'IBQ'),
       ('A00013', 'Emiliano Suárez', 'SIS'),
       ('A00014', 'Sofía León', 'TEL'),
       ('A00015', 'Alejandro Pineda', 'IND'),
       ('A00016', 'Isabela Cárdenas', 'PSI'),
       ('A00017', 'Mateo Torres', 'DIS'),
       ('A00018', 'Gabriela Mendoza', 'TEL'),
       ('A00019', 'Luis Álvarez', 'DIS'),
       ('A00020', 'Fernanda Espinosa', 'ENI');

-- Insertar profesores sin especificar ID
INSERT INTO professors (name)
VALUES ('Gabriel Tamura'),
       ('Ángela Villota'),
       ('Andrés Aristizábal'),
       ('Rocío Segovia'),
       ('Claudia Castiblanco');

-- Insertar cursos sin especificar ID
INSERT INTO courses (name, professor_id)
VALUES ('Ingeniería de Software IV', 1),
       ('Computación y estructuras discretas III', 2),
       ('Computación y estructuras discretas II', 3),
       ('Ingeniería de Software III', 4),
       ('Proyecto Integrador I', 5);

-- Insertar matrículas sin especificar ID
INSERT INTO enrollments (student_id, course_id)
VALUES
    -- Ingeniería de Software IV
    (1, 1), (2, 1), (6, 1), (8, 1), (13, 1),

    -- Computación y estructuras discretas III
    (1, 2), (2, 2), (3, 2), (6, 2), (14, 2),

    -- Computación y estructuras discretas II
    (3, 3), (5, 3), (10, 3), (12, 3), (18, 3),

    -- Ingeniería de Software III
    (1, 4), (4, 4), (6, 4), (9, 4), (13, 4),

    -- Proyecto Integrador I
    (7, 5), (8, 5), (11, 5), (15, 5), (20, 5);


SELECT setval('csbe_users_seq', (SELECT MAX(id) FROM csbe_users));
SELECT setval('csbe_roles_seq', (SELECT MAX(id) FROM csbe_roles));