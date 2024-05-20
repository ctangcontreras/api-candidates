INSERT INTO candidatos.users (name, email, password, active, date_create) values ('Carlos', 'ctangcontreras@gmail.com','123456', 1, sysdate() );
INSERT INTO candidatos.users (name, email, password, active, date_create) values ('Pepe', 'pepito@gmail.com','123456', 1, sysdate() );


INSERT INTO candidatos.candidates (id_user, name, email, phone, address, gender, salary_expected, active, date_create) 
values (1, 'Carlos', 'ctang@gmail.com', '971718180' , 'lima', 'M', 10000, 1, sysdate());