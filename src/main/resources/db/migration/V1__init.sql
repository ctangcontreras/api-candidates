 
 
CREATE TABLE candidatos.users(
	id int auto_increment,
	name varchar(80),
	email varchar(80),
	password varchar(20),
	active char(1),
	date_create datetime,
	date_modify datetime,
	date_eliminate datetime,
	primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE candidatos.candidates(
	id int auto_increment,
	id_user int not null,
	name varchar(80),
	email varchar(80),
	phone varchar(9),
	address varchar(80),
	gender char(1),
	salary_expected decimal(8,2),
	active char(1),
	date_create datetime,
	date_modify datetime,
	date_eliminate datetime,
	primary key (id),
	foreign key (id_user) references candidatos.users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;