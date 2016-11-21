use grotox;

CREATE TABLE Regiao(
	CodReg int,
	NomeReg varchar(255) NOT NULL,
	PRIMARY KEY(CodReg)
);

CREATE TABLE Estado(
	CodEst int,
	NomeEst varchar (255) NOT NULL,
	CodReg int NOT NULL,
	PRIMARY KEY(CodEst),
	constraint fk_est_reg FOREIGN KEY(CodReg) references Regiao(CodReg)
);

CREATE TABLE Empresa(
	CNPJ varchar(14),
	RazaoSocial varchar(255),
	NomeFantasia varchar(255),
	Logo blob,
	PRIMARY KEY(CNPJ)
);

CREATE TABLE Produto(
	CodProd int,
	NomeProd varchar(255) NOT NULL,
	CNPJ varchar(14) NOT NULL,
	PRIMARY KEY(CodProd),
	constraint fk_prod_emp FOREIGN KEY(CNPJ) references Empresa(CNPJ)
);

CREATE TABLE ClasseProd(
	CodClass int,
	Nome varchar(255) NOT NULL,
	Descricao varchar(255),
	CodProd int NOT NULL,
	PRIMARY KEY(CodClass),
	constraint fk_class_prod FOREIGN KEY(CodProd) references Produto(CodProd)
);

CREATE TABLE IngredienteAtivo(
	IngAtivo varchar(255),
	CodProd int,
	PRIMARY KEY (IngAtivo,CodProd),
	constraint fk_ingr_prod FOREIGN KEY(CodProd) references Produto(CodProd)
);

CREATE TABLE Venda(
	Mes int,
	Ano int,
	Quantidade float NOT NULL,
	CodProd int,
	CodEst int,
	PRIMARY KEY(Mes, Ano, CodProd, CodEst),
	constraint fk_venda_est FOREIGN KEY(CodEst) references Estado(CodEst),
	constraint fk_venda_prod FOREIGN KEY(CodProd) references Produto(CodProd)
);
