/*
MySQL Data Transfer
Source Host: localhost
Source Database: demo
Target Host: localhost
Target Database: demo
Date: 01/04/2016 15:25:25
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for almacen
-- ----------------------------
CREATE TABLE `almacen` (
  `codigo` char(6) NOT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `cod_sucursal` char(6) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for categoria
-- ----------------------------
CREATE TABLE `categoria` (
  `idcategoria` int(6) NOT NULL,
  `codigo` char(6) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `codigoimpuesto` char(6) DEFAULT NULL,
  `codigoconcepto` char(6) DEFAULT NULL,
  PRIMARY KEY (`idcategoria`),
  KEY `codigo` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Categoria de Productos';

-- ----------------------------
-- Table structure for colores
-- ----------------------------
CREATE TABLE `colores` (
  `idcolores` int(6) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `codigo` varchar(6) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`idcolores`,`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for departamento
-- ----------------------------
CREATE TABLE `departamento` (
  `codigo` char(6) NOT NULL DEFAULT '0',
  `descripcion` varchar(60) DEFAULT NULL,
  `comi_vent` decimal(2,0) DEFAULT NULL,
  `comi_cob` decimal(2,0) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for grupo
-- ----------------------------
CREATE TABLE `grupo` (
  `codigo` char(6) NOT NULL DEFAULT '0',
  `descripcion` varchar(60) DEFAULT NULL,
  `cod_departamento` char(6) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for producto
-- ----------------------------
CREATE TABLE `producto` (
  `codigo` char(6) NOT NULL DEFAULT '',
  `descripcion` varchar(60) DEFAULT NULL,
  `tipo` char(1) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  `cod_categoria` char(6) DEFAULT NULL,
  `cod_unidad` char(6) DEFAULT NULL,
  `cod_color` char(6) DEFAULT NULL,
  `fecha_reg` datetime DEFAULT NULL,
  `referencia` char(20) DEFAULT NULL,
  `procedencia` char(6) DEFAULT NULL,
  `cod_prov` char(10) DEFAULT NULL,
  `cod_grupo` char(6) DEFAULT NULL,
  `cod_almacen` char(6) DEFAULT NULL,
  `cod_tallas` char(6) DEFAULT NULL,
  `cod_ubicacion` char(6) DEFAULT NULL,
  `cod_departamento` char(6) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `cod_departamento` (`cod_departamento`),
  KEY `cod_almacen` (`cod_almacen`),
  KEY `cod_categoria` (`cod_categoria`),
  KEY `cod_color` (`cod_color`),
  KEY `cod_unidad` (`cod_unidad`),
  KEY `cod_tallas` (`cod_tallas`),
  KEY `cod_ubicacion` (`cod_ubicacion`),
  KEY `cod_grupo` (`cod_grupo`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`cod_almacen`) REFERENCES `almacen` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_4` FOREIGN KEY (`cod_unidad`) REFERENCES `unidades` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_5` FOREIGN KEY (`cod_tallas`) REFERENCES `tallas` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_6` FOREIGN KEY (`cod_departamento`) REFERENCES `departamento` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_7` FOREIGN KEY (`cod_ubicacion`) REFERENCES `ubicacion` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_8` FOREIGN KEY (`cod_grupo`) REFERENCES `grupo` (`codigo`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for subcategoria
-- ----------------------------
CREATE TABLE `subcategoria` (
  `codigo` char(6) NOT NULL DEFAULT '',
  `descripcion` varchar(45) DEFAULT NULL,
  `cod_categoria` char(6) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for subgrupos
-- ----------------------------
CREATE TABLE `subgrupos` (
  `codigo` char(6) NOT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  `cod_grupo` char(6) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for tallas
-- ----------------------------
CREATE TABLE `tallas` (
  `codigo` char(6) NOT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for ubicacion
-- ----------------------------
CREATE TABLE `ubicacion` (
  `codigo` char(6) NOT NULL DEFAULT '0',
  `descripcion` varchar(60) DEFAULT NULL,
  `cod_almacen` char(6) DEFAULT NULL,
  `pasillo` varchar(6) DEFAULT NULL,
  `anaquel` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for unidades
-- ----------------------------
CREATE TABLE `unidades` (
  `codigo` char(6) NOT NULL,
  `descripcion` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
CREATE TABLE `usuarios` (
  `id_usuario` int(6) NOT NULL,
  `usuario` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Procedure structure for deletColores
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deletColores`(IN i_codigo varchar(6))
BEGIN 

	DELETE FROM COLORES WHERE CODIGO=i_codigo;

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for findColores
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `findColores`(IN i_codigo varchar(45), OUT o_codigo varchar(6), OUT o_descri varchar(45))
BEGIN

	SELECT CODIGO, DESCRIPCION FROM COLORES WHERE CODIGO=i_codigo OR DESCRIPCION=i_codigo;

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for getColores
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getColores`(OUT o_codigo varchar(6), OUT o_descri varchar(45))
BEGIN
	SELECT CODIGO, DESCRIPCION FROM COLORES;
END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for getUsuarios
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getUsuarios`(
		IN p_user varchar(15),
		IN p_pass varchar(15),
		OUT p_usuario varchar(15),
		OUT p_passwd varchar(15))
BEGIN
	
	select usuario, password from usuarios 
		where usuario=p_user and password=p_pass;

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertAlmacen
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertAlmacen`(IN codigo varchar(6), IN descripcion varchar(45), IN codsuc varchar(6))
BEGIN
	INSERT INTO ALMACEN(codigo, descripcion, cod_sucursal)
		values (codigo,descripcion, codsuc);
END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertCategoria
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertCategoria`(IN cod varchar(6), IN des varchar(45), IN codimp  varchar(6), IN codcon varchar(6))
BEGIN 
	
	INSERT INTO CATEGORIA(codigo, descripcion, codigoimpuesto, codigoconcepto) values(cod, des, codimp, codcon);

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertColores
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertColores`(IN i_codigo varchar(6),
    IN i_descri varchar(45))
Begin

	INSERT INTO COLORES (codigo, descripcion) values (i_codigo, i_descri);

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertDepartament
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertDepartament`(IN cod varchar(6), IN descrip varchar(6), IN vent varchar(6), IN cob varchar(6))
BEGIN
	INSERT INTO DEPARTAMENTO(codigo, descripcion, comi_vent, comi_cob) 
		VALUES(cod, descrip, vent, cob);

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertGrupos
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertGrupos`(IN codigo varchar(6), IN descripcion varchar(45), IN codsuc varchar(6))
BEGIN
	INSERT INTO ALMACEN(codigo, descripcion, cod_sucursal)
		values (codigo,descripcion, codsuc);
END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertSubCategoria
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSubCategoria`(IN cod varchar(6), IN des varchar(45), IN codimp  varchar(6), IN codcat varchar(6))
BEGIN

	INSERT INTO SUBCATEGORIA(codigo, descripcion, cod_categoria)
		VALUES(cod, des, codcat);

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertSubGrupos
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertSubGrupos`(IN codigo varchar(6), IN descri varchar(45), IN codgrup varchar(6))
BEGIN

	INSERT INTO subgrupos(codigo, descripcion, cod_grupo) 
			VALUES (codigo, descrip, codgrup);
	
END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertTallas
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertTallas`(IN codigo varchar(6), IN descri varchar(45))
BEGIN

	INSERT INTO tallas(codigo, descripcion)
			VALUES (codigo, descrip);

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertUbicacion
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUbicacion`(IN codigo varchar(6), IN descri varchar(45), IN codalm varchar(6),  IN pasi varchar(6),  IN anaq varchar(6))
BEGIN

	INSERT INTO UBICACION(codigo, descripcion, cod_almacen, pasillo, anaquel)
			VALUES (codigo, descrip, codalm, pasi, anaq);

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertUnidades
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertUnidades`(IN codigo varchar(6), IN descri varchar(45))
BEGIN

	INSERT INTO unidades(codigo, descripcion)
			VALUES (codigo, descrip);

END;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for updatColores
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updatColores`(IN i_codigo varchar(6),
    IN i_descri varchar(45))
BEGIN

	UPDATE COLORES SET CODIGO= i_codigo, DESCRIPCION= i_descri Where CODIGO=i_codigo;

END;;
DELIMITER ;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `colores` VALUES ('000001', 'AZ1', 'Azul');
INSERT INTO `colores` VALUES ('000009', 'RO2', 'Rojo');
INSERT INTO `departamento` VALUES ('00001', 'indefinido', '20', '20');
INSERT INTO `grupo` VALUES ('1', 'indefinido', '1');
INSERT INTO `grupo` VALUES ('2', 'KJKJKJ', '00001');
INSERT INTO `usuarios` VALUES ('1', '1', '1');
