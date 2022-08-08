create database alkemy;
use alkemy;
create table personaje(
id INT auto_increment,
imagen blob,
nombre VARCHAR(50) NOT NULL,
edad INT,
peso float,
historia VARCHAR(200),
pelicula_serie_id INT,
primary key (id));
alter table personaje
add CONSTRAINT fk_personaje_pelicula_serie
FOREIGN KEY (pelicula_serie_id) REFERENCES pelicula_serie(id);

create table pelicula_serie(
id INT auto_increment,
imagen blob,
titulo VARCHAR(50) NOT NULL,
fecha_creacion date,
calificacion INT,
personajes_asociados_id INT,
primary key (id),
CONSTRAINT fk_pelicula_serie_personaje
FOREIGN KEY (personajes_asociados_id) REFERENCES personaje(id));
SET SQL_SAFE_UPDATES = 0;
-- drop table pelicula_serie;
alter table pelicula_serie drop personajes_asociados_id;

create table genero(
id INT auto_increment,
nombre VARCHAR(50) NOT NULL,
imagen blob,
pelicula_serie_id INT,
primary key (id),
CONSTRAINT fk_genero_pelicula_serie
FOREIGN KEY (pelicula_serie_id) REFERENCES pelicula_serie(id));

select * from genero;
select * from personaje;
select * from pelicula_serie;

INSERT INTO personaje
(id,imagen, nombre, edad,peso,historia,pelicula_serie_id)
values
-- (1,null,'elsa',15,50,'Elsa es mencionada como portadora de poderes criogénicos, los cuales involuntariamente crean un eterno invierno en Arendelle el día de su coronación',null),
-- (2, null,'Anna',18,52,' Anna es la princesa menor de Arendelle',1),
-- (3, null,'Mirabel',18,60,' ella es una joven que no tiene ningún don especial, cuando todos los miembros de la familia Madrigal cuentan con un don',2),
(4, null,'Mirabel',18,60,' ella es una joven que no tiene ningún don especial, cuando todos los miembros de la familia Madrigal cuentan con un don',2);

INSERT INTO pelicula_serie
(id,imagen,titulo,fecha_creacion,calificacion)
VALUES
-- (1,null, 'Frozen','2013-02-02',4,1),
-- (2,null, 'Encanto','2021-02-02',5,3),
(3,null, 'Encanto','2021-03-02',5);

INSERT INTO genero(nombre,imagen,pelicula_serie_id)
values
('infantil',null,1);
 select *from genero;

select p.nombre,p.imagen from personaje as p;
select p.id,p.nombre,p.edad,p.peso,p.imagen , ps.titulo as pelicula from pelicula_serie as ps, personaje as p where p.pelicula_serie_id =ps.id;

select * from personaje where nombre like '%elsa%';
select * from personaje where edad like '%15%';

select ps.titulo, ps.fecha_creacion from pelicula_serie as ps where ps.titulo like '%infantil%' order by fecha_creacion desc;
select ps.titulo, ps.fecha_creacion from pelicula_serie as ps order by fecha_creacion asc;
select g.nombre as genero,g.pelicula_serie_id,ps.titulo from genero as g,pelicula_serie as ps where g.pelicula_serie_id=ps.id ;

select * from pelicula_serie as ps where ps.titulo like '%en%' order by ps.fecha_creacion;

select ps.id,ps.imagen,ps.titulo,ps.fecha_creacion,ps.calificacion, p.nombre as personaje from personaje as p, pelicula_serie as ps where p.pelicula_serie_id=ps.id ;