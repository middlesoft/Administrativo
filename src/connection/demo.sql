/*
MySQL Data Transfer
Source Host: localhost
Source Database: demo
Target Host: localhost
Target Database: demo
Date: 16/03/2016 22:07:18
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
  PRIMARY KEY (`idcategoria`),
  KEY `codigo` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Categoria de Productos';

-- ----------------------------
-- Table structure for colores
-- ----------------------------
CREATE TABLE `colores` (
  `codigo` char(6) NOT NULL DEFAULT '0',
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  CONSTRAINT `producto_ibfk_8` FOREIGN KEY (`cod_grupo`) REFERENCES `grupo` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`cod_almacen`) REFERENCES `almacen` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`cod_categoria`) REFERENCES `categoria` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_3` FOREIGN KEY (`cod_color`) REFERENCES `colores` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_4` FOREIGN KEY (`cod_unidad`) REFERENCES `unidades` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_5` FOREIGN KEY (`cod_tallas`) REFERENCES `tallas` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_6` FOREIGN KEY (`cod_departamento`) REFERENCES `departamento` (`codigo`) ON UPDATE CASCADE,
  CONSTRAINT `producto_ibfk_7` FOREIGN KEY (`cod_ubicacion`) REFERENCES `ubicacion` (`codigo`) ON UPDATE CASCADE
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
-- Procedure structure for getColores
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getColores`()
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
-- Procedure structure for insertColores
-- ----------------------------
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertColores`(IN i_codigo varchar(15),
		OUT P_codigo varchar(15)	)
Begin

	INSERT INTO COLORES (codigo) values (i_codigon);

END;;
DELIMITER ;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `colores` VALUES ('1', 'Azul');
INSERT INTO `usuarios` VALUES ('1', '1', '1');
