USE BancoAluminios

create table disco(
	id bigint identity primary key,
	descricao varchar(100) not null,
	tamanho float not null,
	espessura float not null
)

create table alca(
	id bigint identity primary key,
	descricao varchar(100) not null
)

create table pomel(
	id bigint identity primary key,
	descricao varchar(100) not null,
	material varchar(100) not null
)

create table tampa(
	id bigint identity primary key,
	descricao varchar(100) not null,
	idDisco bigint references disco not null,
	idPomel bigint references pomel not null
)

create table panela(
	id bigint identity primary key,
	descricao varchar(100) not null,
	idDisco bigint references disco not null,
	idAlca bigint references alca not null,
	idTampa bigint references tampa not null,
	preco float not null
)

