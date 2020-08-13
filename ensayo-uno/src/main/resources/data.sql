INSERT INTO Ciudades VALUES (1,'Santiago');
INSERT INTO Ciudades VALUES (2,'Viña del Mar');
INSERT INTO Ciudades VALUES (3,'Concepción');
INSERT INTO Ciudades VALUES (4,'Rancagua');
INSERT INTO Ciudades VALUES (5,'Temuco');

INSERT INTO Beneficiarios (beneficiarioid, nombre, edad, ciudadid)
VALUES (1,'Juan Perez',23,1);
INSERT INTO Beneficiarios (beneficiarioid, nombre, edad, ciudadid)
VALUES (2,'Pedro López',30,3);
INSERT INTO Beneficiarios (beneficiarioid, nombre, edad, ciudadid)
VALUES (3,'Diego González',18,2);
INSERT INTO Beneficiarios (beneficiarioid, nombre, edad, ciudadid)
VALUES (4,'Martín Sánchez',45,1);
INSERT INTO Beneficiarios (beneficiarioid, nombre, edad, ciudadid)
VALUES (5,'Samuel Reyes',30,4);
INSERT INTO Beneficiarios (beneficiarioid, nombre, edad, ciudadid)
VALUES (6,'Matías Donoso',60,5);

INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(1, 3,250000,'Insumos');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(2, 2,50000,'Alimentación');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(3, 2,40000,'Cuentas');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(4, 4,240000,'Alimentación');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(5, 1,80000,'Cuentas');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(6, 2,150000,'Insumos');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(7, 4,100000,'Cuentas');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(8, 3,50000,'Cuentas');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(9, 3,50000,'Alimentación');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(10, 1,25000,'Insumos');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(11, 5,25000,'Alimentación');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(12, 6,38500,'Cuentas');
INSERT INTO Ayudas (ayudaid, beneficiarioid, monto, motivo) VALUES
(13, 5,20000,'Insumos');

ALTER SEQUENCE HIBERNATE_SEQUENCE INCREMENT BY 100;
SELECT HIBERNATE_SEQUENCE.nextval FROM dual;
ALTER SEQUENCE HIBERNATE_SEQUENCE INCREMENT BY 1;