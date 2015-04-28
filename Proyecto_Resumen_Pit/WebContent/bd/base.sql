DROP DATABASE IF EXISTS base;
-- creamos la bd
CREATE DATABASE base;
-- activamos la bd
USE base;
-- creamos las tablas
CREATE TABLE tb_usuario
(
usuario  char(4) NOT NULL,
clave    char(5),
nombre varchar(15),
apellido varchar(15),
facceso date  null,
estado  int(1) DEFAULT 1
);

create table tb_productos(
idprod      char(5) not null primary key,
descripcion varchar(30),
precio		decimal(8,2),
estado		boolean
);

CREATE TABLE tb_ventas(
numvta   int(8) AUTO_INCREMENT NOT NULL primary KEY,
fchvta  date  null,
vendedor char(4)
);

CREATE TABLE tb_detventas(
numvta   int(8) NOT NULL,
idprod   char(5) not null ,
cant     int(3)  null,
precio   decimal(8,2)
);


-- creamos la pk
ALTER TABLE tb_usuario ADD PRIMARY KEY (usuario);
ALTER TABLE tb_detventas ADD PRIMARY KEY (numvta,idprod);
-- creamos la fk
ALTER TABLE tb_ventas ADD foreign key (vendedor) references tb_usuario(usuario);
ALTER TABLE tb_detventas ADD foreign key (numvta) references tb_ventas(numvta);
ALTER TABLE tb_detventas ADD foreign key (idprod) references tb_productos(idprod);

-- inserts
INSERT INTO tb_usuario 	VALUES ('U001', '10001', 'Juan', 'Perez','2014/10/01',1);
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso)	VALUES ('U002', '10002', 'Candy', 'Millet', curdate());
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso)	VALUES ('U003', '10003', 'Luisa', 'Falcon', curdate());
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso)	VALUES ('U004', '10004', 'Miguel', 'Pangus', curdate());
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso)	VALUES ('U005', '10005', 'Kevin', 'Ramirez', curdate());
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso)	VALUES ('U006', '10006', 'Diego', 'Mattas', curdate());
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso)	VALUES ('U007', '10007', 'German', 'Garmendia', curdate());
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso)	VALUES ('U008', '10008', 'David', 'Revila', curdate());




INSERT INTO tb_ventas (fchvta, vendedor) VALUES ('2014/10/01','U002');
INSERT INTO tb_ventas (numvta,fchvta,vendedor) VALUES (02,curdate(),'U001');

insert into tb_productos values ('P0001','Pizza familiar',35,1);
insert into tb_productos values ('P0002','Pizza suprema',45,0);
insert into tb_productos values ('P0003','Pizza personal',8,1);
insert into tb_productos values ('P0004','Pizza hawaiana',8,1);
insert into tb_productos values ('P0005','Pizza norteña',8,1);
insert into tb_productos values ('P0006','Pizza chiclayana',8,1);
insert into tb_productos values ('P0007','Pizza puneña',8,1);
insert into tb_productos values ('P0008','Pizza limeña',8,1);
insert into tb_productos values ('P0009','Pizza cuzqueña',8,1);
insert into tb_productos values ('P0010','Pizza tarmeña',8,1);
insert into tb_productos values ('P0011','Inca Kola',2.5,1);
insert into tb_productos values ('P0012','Rolls',7.5,0);

INSERT INTO tb_detventas VALUES (01,'P0001',1,35);
INSERT INTO tb_detventas VALUES (02,'P0003',2,8);




-- consultas
SELECT * FROM tb_usuario;
SELECT * FROM tb_ventas;
SELECT * FROM tb_detventas;

    



DROP procedure IF EXISTS usp_buscausuario;
DELIMiTER $$
create procedure usp_buscausuario(usr char(4), pas char(5))
begin
select * from tb_usuario where usuario= usr and clave = pas;
end$$
DELIMiTER  ;

-- llamar al sp
-- CALL usp_buscausuario('U001','10001');

-- Procedure para ingresar usuarios
DROP procedure IF EXISTS usp_insertarUsuario;
DELIMiTER $$
create procedure usp_insertarUsuario(usr char(4), pass varchar(5), nom varchar(70), ape varchar(70), fecha date )
begin
      insert into tb_usuario values (usr, pass, nom, ape, fecha, default);
end$$
DELIMiTER ;


-- Procedure para actualizar datos de los usuarios
DROP PROCEDURE IF EXISTS usp_modificarUsuarios;
DELIMITER $$
create procedure usp_modificarUsuarios(usr char(4), pass varchar(5), nom varchar(70), ape varchar(70))
begin
     update tb_usuario set  clave=pass, nombre=nom, apellido=ape where usuario=usr;
end$$
DELIMITER ;


DROP PROCEDURE IF EXISTS usp_registrarVenta;
DELIMITER $$
create procedure usp_registrarVenta(idVendedor char(5), inout op_numvta int(8))
begin
	INSERT INTO tb_ventas(fchvta, vendedor) VALUES (curdate(), idVendedor);
    set op_numvta=concat((SELECT count(*)FROM  tb_ventas));
end$$
DELIMITER ;

DROP PROCEDURE IF EXISTS usp_registrarDetalleVenta;
DELIMITER $$
create procedure usp_registrarDetalleVenta(ip_numvta int(8),p_idprod char(5), p_cant int, p_precio decimal(8,2))
begin


	INSERT INTO  tb_detventas(numvta, idprod, cant, precio) VALUES (ip_numvta, p_idprod, p_cant, p_precio);

end$$
DELIMITER ;



SELECT * FROM tb_ventas;
SELECT * FROM tb_detventas;

Call usp_registrarVenta('U001', @salida);
select @salida;