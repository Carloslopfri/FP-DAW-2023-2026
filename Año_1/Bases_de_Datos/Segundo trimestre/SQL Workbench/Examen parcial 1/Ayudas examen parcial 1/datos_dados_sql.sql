-- Se activa la bdd
USE carloslf_ferreteria;

-- Introducción de los registros en la tabla Empleados
INSERT INTO Empleados (NumEmpleado,Nombre,Edad, Oficina, Titulo, Contrato, Cuota, Ventas) 
		VALUES (106,'Luis Antonio',52,11,'Dir General','1998/06/14',1652,1797);
INSERT INTO Empleados VALUES (104,'Jose Gonzalez',33,12,'Dir Ventas','1997/03/01',106,1202, 859);
INSERT INTO Empleados VALUES (108,'Ana Bustamante',62,21,'Dir Ventas','1989/10/12',106,2103,2169);
INSERT INTO Empleados VALUES (109,'Maria Sunat',31,11,'Representante','2003/10/20',106,1803,2355);
INSERT INTO Empleados VALUES (101,'Antonio viguer',45,12,'Representante','1996/10/20',104,1803,1833);
INSERT INTO Empleados VALUES (102,'Alvaro jaumes',48,21,'Representante','1996/10/20',108,2103,2848);
INSERT INTO Empleados VALUES (103,'Juan Rovira',31,12,'Representante','1997/03/01',104,1652,1718);
INSERT INTO Empleados VALUES (105,'Vicente Pantalla',37,13,'Representante','1998/02/12',104,2103,2211);
INSERT INTO Empleados VALUES (107,'Jorge Gutierrez',49,22,'Representante','1998/11/01',108,1803,1117);
INSERT INTO Empleados (NumEmpleado,Nombre,Edad, Titulo, Contrato, Jefe,Ventas) 
		VALUES (110,'Juan Victor',41,'Representante','2001/01/13',104,456);

-- Introducción de los registros en la tabla Oficinas
INSERT INTO Oficinas VALUES (11,'Valencia','Este',106,3455,4165);
INSERT INTO Oficinas VALUES (12,'Alicante','Este',104,4808,4417);
INSERT INTO Oficinas VALUES (13,'Castellon','Este',105,2103,2211);
INSERT INTO Oficinas VALUES (21,'Badajoz','Oeste',108,4357,5024);
INSERT INTO Oficinas VALUES (22,'A Coruña','Oeste',108,1803,1117);  
INSERT INTO Oficinas (Oficina, ciudad, Region, Director) VALUES (23,'Madrid','Centro',108);
INSERT INTO Oficinas VALUES (24,'Madrid','Centro',108,1502,901);
INSERT INTO Oficinas (Oficina, ciudad, Region) VALUES (26,'Pamplona','Norte');
INSERT INTO Oficinas (Oficina, ciudad, Region, Objetivo) VALUES (28,'Valencia','Este',5409);

-- Introduccion de los registros de Clientes
INSERT INTO Clientes VALUES (2101,'Luis Garcia Anton',106,390.50);
INSERT INTO Clientes VALUES (2102,'Alvaro Rodriguez',101,390.75);
INSERT INTO Clientes VALUES (2103,'Jaime Llorens',105,300.50);
INSERT INTO Clientes VALUES (2105,'Antonio Canales',101,270.12);
INSERT INTO Clientes VALUES (2106,'Juan Suarez',102,390.50);
INSERT INTO Clientes VALUES (2107,'Julian Lopez',110,210.88);
INSERT INTO Clientes VALUES (2108,'Julia Antequera',109,330.50);
INSERT INTO Clientes VALUES (2109,'Alberto Juanes',103,150.50);
INSERT INTO Clientes VALUES (2111,'Cristobal Garcia',103,300.50);
INSERT INTO Clientes VALUES (2112,'Maria Silva',108,300.50);
INSERT INTO Clientes VALUES (2113,'Luisa Maron',104,120.50);
INSERT INTO Clientes VALUES (2114,'Cristina Bulini',102,120.20);
INSERT INTO Clientes VALUES (2115,'Vicente Martinez',101,120.80);
INSERT INTO Clientes VALUES (2117,'Carlos Tena',106,210.70);
INSERT INTO Clientes VALUES (2118,'Junipero Alvarez',108,360.50);
INSERT INTO Clientes VALUES (2119,'Salomon Bueno',109,150.75);
INSERT INTO Clientes VALUES (2120,'Juan Malo',102,300.70);
INSERT INTO Clientes VALUES (2121,'Vicente Rios',103,270.48);
INSERT INTO Clientes VALUES (2122,'Jose Marchante',105,180.55);
INSERT INTO Clientes VALUES (2123,'Jose Libros',102,240.92);
INSERT INTO Clientes VALUES (2124,'Juan Bolto',107,240.60);
	
-- Introduccion de los registros de Productos
INSERT INTO Productos VALUES ('aci','41001','arandela',15.78,250);
INSERT INTO Productos VALUES ('aci','41002','bisagra',3.60,167);
INSERT INTO Productos VALUES ('aci','41003','art 13',1.50,207);
INSERT INTO Productos VALUES ('aci','41004','art 14',1.00,139);
INSERT INTO Productos VALUES ('aci','4100x','junta',1.50,37);
INSERT INTO Productos VALUES ('aci','4100y','extractor',6.00,25);
INSERT INTO Productos VALUES ('aci','4100z','artefacto',6.50,28);
INSERT INTO Productos VALUES ('bic','41003','manivela',1.00,3);
INSERT INTO Productos VALUES ('bic','41089','rodamiento',6.50,78);
INSERT INTO Productos VALUES ('bic','41672','plato a',0.50,0);
INSERT INTO Productos VALUES ('fea','112','cubo',0.35,115);
INSERT INTO Productos VALUES ('fea','114','cubeta',0.48,15);
INSERT INTO Productos VALUES ('imm','773c','destornillador',0.25,28);
INSERT INTO Productos VALUES ('imm','775c','destornillador2',3.00,5);
INSERT INTO Productos VALUES ('imm','779c','destornillador3',2.00,0);
INSERT INTO Productos VALUES ('imm','887h','caja clavos',1.00,223);
INSERT INTO Productos VALUES ('imm','887p','perno',1.00,24);
INSERT INTO Productos VALUES ('imm','887x','manivela2',2.00,32);
INSERT INTO Productos VALUES ('qsa','xk47','red 1',30.00,38);
INSERT INTO Productos VALUES ('qsa','xk48','red 2',30.00,203);
INSERT INTO Productos VALUES ('qsa','xk48a','red 3',0.50,37);
INSERT INTO Productos VALUES ('rei','2a441','bomba 1',0.65,12);
INSERT INTO Productos VALUES ('rei','2a44g','tuerca',0.74,14);
INSERT INTO Productos VALUES ('rei','2a44r','bomba r',0.16,12);
INSERT INTO Productos VALUES ('rei','2a45c','juntaB',17.36,210);

-- Introduccion de los registros de Pedidos
INSERT INTO Pedidos VALUES ('1','110036','1997/01/02',2107,110,'aci','4100z',9,58.50);
INSERT INTO Pedidos VALUES ('3','112963','1997/05/10',2103,105,'aci','41004',28,28.00);
INSERT INTO Pedidos VALUES ('4','112968','1990/10/11',2102,101,'aci','41004',34,34.50);
INSERT INTO Pedidos VALUES ('6','112979','1989/10/12',2114,108,'aci','4100z',6,39.00);
INSERT INTO Pedidos VALUES ('7','112983','1997/05/10',2103,105,'aci','41004',6,6.50);
INSERT INTO Pedidos VALUES ('8','112987','1997/01/01',2103,105,'aci','4100y',11,66.50);
INSERT INTO Pedidos VALUES ('10','112992','1990/04/15',2118,108,'aci','41002',10,36.50);
INSERT INTO Pedidos VALUES ('15','113012','1997/05/05',2111,105,'aci','41003',35,52.50);
INSERT INTO Pedidos VALUES ('18','113027','1997/02/05',2103,105,'aci','41002',54,194.40);
INSERT INTO Pedidos VALUES ('25','113055','2009/04/01',2108,101,'aci','4100x',6,9.00);
INSERT INTO Pedidos VALUES ('26','113057','1997/08/06',2111,103,'aci','4100x',24,36.50);
INSERT INTO Pedidos VALUES ('12','112997','1997/07/04',2124,107,'bic','41003',1,1.50);
INSERT INTO Pedidos VALUES ('16','113013','1997/12/10',2118,108,'bic','41003',1,1.50);
INSERT INTO Pedidos VALUES ('28','113062','1989/07/04',2124,107,'bic','41003',10,2430.50);
INSERT INTO Pedidos VALUES ('9','112989','1997/02/05',2101,106,'fea','114',6,2.88);
INSERT INTO Pedidos VALUES ('27','113058','1997/01/01',2108,109,'fea','112',10,3.00);
INSERT INTO Pedidos VALUES ('13','113003','1997/02/02',2108,109,'imm','779c',3,6.50);
INSERT INTO Pedidos VALUES ('14','113007','1997/08/01',2112,108,'imm','773c',3,0.75);
INSERT INTO Pedidos VALUES ('22','113048','1997/11/01',2120,102,'imm','779c',2,4.00);
INSERT INTO Pedidos VALUES ('30','113069','1997/08/01',2109,107,'imm','773c',22,5.50);
INSERT INTO Pedidos VALUES ('17','113024','1997/07/04',2114,108,'qsa','xk47',20,600.00);
INSERT INTO Pedidos VALUES ('23','113049','1997/04/04',2118,108,'qsa','xk47',2,60.00);
INSERT INTO Pedidos VALUES ('24','113051','1997/07/06',2118,108,'qsa','xk47',4,120.00);
INSERT INTO Pedidos VALUES ('29','113065','1997/06/03',2106,102,'qsa','xk48',6,180.00);
INSERT INTO Pedidos VALUES ('2','110036','1997/01/02',2117,106,'rei','2a441',7,4.55);
INSERT INTO Pedidos VALUES ('5','112975','1997/02/11',2111,103,'rei','2a44g',6,4.44);
INSERT INTO Pedidos VALUES ('11','112993','1997/03/10',2106,102,'rei','2a45c',24,416.64);
INSERT INTO Pedidos VALUES ('19','113034','1997/11/05',2107,110,'rei','2a45c',8,138.88);
INSERT INTO Pedidos VALUES ('20','113042','1997/01/01',2113,101,'rei','2a44r',5,0.80);
INSERT INTO Pedidos VALUES ('21','113045','1997/07/02',2112,108,'rei','2a44r',10,1.60);