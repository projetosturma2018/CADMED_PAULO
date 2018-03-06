create table paciente(
id_paciente serial not null primary key,
	nome varchar(50),
	cpf varchar(50),
	endereco varchar(50),
	rg varchar(50),
	sexo varchar(20),
	telefone varchar(50),
	medico_responsavel varchar(50),
	id_convenio serial not null,
	id_consulta serial not null
);

create table convenio(
id_convenio serial not null,
	nome varchar(50)
);

create table consulta(
id_consulta serial not null,
	patologia varchar(100)
);