create table paciente(
id_paciente serial not null primary key,
	nome varchar(50) not null,
	cpf varchar(50),
	endereco varchar(50),
	rg varchar(50),
	sexo varchar(20),
	telefone varchar(20),
	medico_responsavel varchar(50),
	id_convenio serial not null,
	id_consulta serial not null
	);
	
	create table convenio(
	id_convenio serial not null primary key,
	nome_convenio varchar(50),
	id_paciente serial not null
	);
	
	create table consulta(
	id_consulta serial not null primary key,
	patologia varchar(50),
	id_paciente serial not null
);

alter table paciente add CONSTRAINT fk_convenio FOREIGN KEY (id_convenio) REFERENCES convenio(id_convenio)
alter table convenio add CONSTRAINT fk_paciente FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
alter table consulta add CONSTRAINT fk_pacienteC FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)