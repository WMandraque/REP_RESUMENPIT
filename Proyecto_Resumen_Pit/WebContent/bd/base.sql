DROP DATABASE IF EXISTS base;
-- creamos la bd
CREATE DATABASE base;
-- activamos la bd
USE base;
-- creamos las tablas

DROP TABLE IF EXISTS tb_estado;
CREATE TABLE tb_estado 
(
  idestado INT(11) NOT NULL,
  descripcion VARCHAR(70) NOT NULL
  );


CREATE TABLE tb_usuario
(
usuario  CHAR(4) NOT NULL,
clave    CHAR(5),
nombre VARCHAR(15),
apellido VARCHAR(15),
facceso DATE  NULL,
idestado  INT NOT NULL
);


CREATE TABLE tb_productos
(
idprod      CHAR(5) NOT NULL,
descripcion VARCHAR(30),
precio		DECIMAL(8,2),
idestado		int not null
);

CREATE TABLE tb_ventas
(
numvta   INT(8) not null AUTO_INCREMENT,
fchvta  DATE  NULL,
vendedor CHAR(4),
Constraint pk_tb_ventas  primary key(numvta)
);

CREATE TABLE tb_detventas
(
numvta   INT NOT NULL,
idprod   CHAR(5) NOT NULL ,
cant     INT(3)  NULL,
precio   DECIMAL(8,2)
);



-- creamos la pk
ALTER TABLE  tb_usuario ADD CONSTRAINT pk_tb_usuario_usuario PRIMARY KEY (usuario);
ALTER TABLE tb_estado ADD constraint pk_tb_estado_idestado primary key(idestado);
ALTER TABLE  tb_productos ADD constraint pk_tb_productos_idprod primary key(idprod);

-- creamos los fk
ALTER TABLE tb_ventas ADD constraint fk_tb_vendedor_usuario  foreign key (vendedor) references tb_usuario(usuario);
alter table tb_usuario add constraint fk_tb_usuario_idestado foreign key(idestado) references tb_estado(idestado);
ALTER TABLE tb_detventas ADD constraint fk_detventas_numvta foreign key (numvta) references tb_ventas(numvta);
ALTER TABLE tb_detventas ADD constraint fk_detventas_idpord foreign key (idprod) references tb_productos(idprod);
ALTER TABLE tb_productos ADD CONSTRAINT fk_tb_productos_idestado foreign key(idestado) references tb_estado(idestado);

-- LLaves compuestas
ALTER TABLE tb_detventas ADD PRIMARY KEY (numvta,idprod);


insert into tb_estado values (1, 'Activo'), (2, 'no activo');
-- inserts
INSERT INTO tb_usuario 	VALUES ('U001', '10001', 'Juan', 'Perez','2014/10/01',1);
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso, idestado)	VALUES ('U002', '10002', 'Candy', 'Millet', curdate(), 1);
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso, idestado)	VALUES ('U003', '10003', 'Luisa', 'Falcon', curdate(), 1);
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso, idestado)	VALUES ('U004', '10004', 'Miguel', 'Pangus', curdate(), 1);
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso, idestado)	VALUES ('U005', '10005', 'Kevin', 'Ramirez', curdate(), 1);
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso, idestado)	VALUES ('U006', '10006', 'Diego', 'Mattas', curdate(), 1);
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso, idestado)	VALUES ('U007', '10007', 'German', 'Garmendia', curdate(), 1);
INSERT INTO tb_usuario 	(usuario,clave,nombre,apellido, facceso, idestado)	VALUES ('U008', '10008', 'David', 'Revila', curdate(), 1);






insert into tb_productos values ('P0001','Pizza familiar',35,1);
insert into tb_productos values ('P0002','Pizza suprema',45,1);
insert into tb_productos values ('P0003','Pizza personal',8,1);
insert into tb_productos values ('P0004','Pizza hawaiana',8,1);
insert into tb_productos values ('P0005','Pizza norteña',8,1);
insert into tb_productos values ('P0006','Pizza chiclayana',8,1);
insert into tb_productos values ('P0007','Pizza puneña',8,1);
insert into tb_productos values ('P0008','Pizza limeña',8,1);
insert into tb_productos values ('P0009','Pizza cuzqueña',8,1);
insert into tb_productos values ('P0010','Pizza tarmeña',8,1);
insert into tb_productos values ('P0011','Inca Kola',2.5,1);
insert into tb_productos values ('P0012','Rolls',7.5,1);

INSERT INTO tb_ventas (fchvta, vendedor) VALUES ('2014/10/01','U002');
INSERT INTO tb_ventas (numvta,fchvta,vendedor) VALUES (02,curdate(),'U001');

INSERT INTO tb_detventas VALUES (01,'P0001',1,35);
INSERT INTO tb_detventas VALUES (02,'P0003',2,8);
    



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




Call usp_registrarVenta('U001', @salida);
select @salida;