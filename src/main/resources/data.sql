-- Insertar estudiantes
INSERT INTO domi_students (id, code, name, program)
VALUES (1, 'A00001', 'Juan Pérez', 'SIS'),
       (2, 'A00002', 'María Gómez', 'SIS'),
       (3, 'A00003', 'Miguel Rodríguez', 'TEL'),
       (4, 'A00004', 'Lucía Fernández', 'DMI'),
       (5, 'A00005', 'Daniela Ramírez', 'TEL'),
       (6, 'A00006', 'Santiago Morales', 'SIS'),
       (7, 'A00007', 'Valentina Castro', 'DMI'),
       (8, 'A00008', 'Carlos Méndez', 'SIS'),
       (9, 'A00009', 'Javier Ortega', 'IBQ'),
       (10, 'A00010', 'Camila Rojas', 'MED'),
       (11, 'A00011', 'Andrés Herrera', 'ENI'),
       (12, 'A00012', 'Natalia Vargas', 'IBQ'),
       (13, 'A00013', 'Emiliano Suárez', 'SIS'),
       (14, 'A00014', 'Sofía León', 'TEL'),
       (15, 'A00015', 'Alejandro Pineda', 'IND'),
       (16, 'A00016', 'Isabela Cárdenas', 'PSI'),
       (17, 'A00017', 'Mateo Torres', 'DIS'),
       (18, 'A00018', 'Gabriela Mendoza', 'TEL'),
       (19, 'A00019', 'Luis Álvarez', 'DIS'),
       (20, 'A00020', 'Fernanda Espinosa', 'ENI');

-- Insertar profesores
INSERT INTO domi_professors (id, name)
VALUES (1, 'Gabriel Tamura'),
       (2, 'Ángela Villota'),
       (3, 'Andrés Aristizábal'),
       (4, 'Rocío Segovia'),
       (5, 'Claudia Castiblanco');

-- Insertar cursos
INSERT INTO domi_courses (id, name, professor_id)
VALUES (1, 'Ingeniería de Software IV', 1),
       (2, 'Computación y estructuras discretas III', 2),
       (3, 'Computación y estructuras discretas II', 3),
       (4, 'Ingeniería de Software III', 4),
       (5, 'Proyecto Integrador I', 5);