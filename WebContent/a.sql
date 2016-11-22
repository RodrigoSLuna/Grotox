CREATE DATABASE if not exists grotox;

use grotox;

CREATE SCHEMA if not exists agro;

CREATE TABLE if not exists agro.Regiao(
	CodReg int NOT NULL AUTO_INCREMENT,
	NomeReg varchar(255) NOT NULL,
	PRIMARY KEY(CodReg)
) ENGINE = INNODB;

CREATE TABLE if not exists agro.Estado(
	CodEst int NOT NULL AUTO_INCREMENT,
	NomeEst varchar(255) NOT NULL,
	CodReg int NOT NULL,
	PRIMARY KEY(CodEst),
	constraint fk_est_reg FOREIGN KEY(CodReg) references agro.Regiao(CodReg)
) ENGINE = INNODB;

CREATE TABLE if not exists agro.Empresa(
	CNPJ varchar(14) NOT NULL,
	RazaoSocial varchar(255) NULL,
	NomeFantasia varchar(255) NULL,
	Logo blob NOT NULL,
	PRIMARY KEY(CNPJ)
) ENGINE = INNODB;

CREATE TABLE if not exists agro.Produto(
	CodProd int NOT NULL AUTO_INCREMENT,
	NomeProd varchar(255) NOT NULL,
	CNPJ varchar(14) NOT NULL,
	PRIMARY KEY(CodProd),
	constraint fk_prod_emp FOREIGN KEY(CNPJ) references agro.Empresa(CNPJ)
);

CREATE TABLE if not exists agro.ClasseProd(
	CodClass int NOT NULL AUTO_INCREMENT,
	Nome varchar(255) NOT NULL,
	Descricao varchar(255) NULL,
	CodProd int NOT NULL,
	PRIMARY KEY(CodClass),
	constraint fk_class_prod FOREIGN KEY(CodProd) references Produto(CodProd)
);

CREATE TABLE if not exists agro.IngredienteAtivo(
	IngAtivo varchar(255) NOT NULL,
	CodProd int NOT NULL,
	PRIMARY KEY (IngAtivo,CodProd),
	constraint fk_ingr_prod FOREIGN KEY(CodProd) references Produto(CodProd)
);

CREATE TABLE if not exists agro.Venda(
	Mes int NOT NULL,
	Ano int NOT NULL,
	Quantidade float NOT NULL,
	CodProd int NOT NULL,
	CodEst int NOT NULL,
	PRIMARY KEY(Mes, Ano, CodProd, CodEst),
	constraint fk_venda_est FOREIGN KEY(CodEst) references Estado(CodEst),
	constraint fk_venda_prod FOREIGN KEY(CodProd) references Produto(CodProd)
);
