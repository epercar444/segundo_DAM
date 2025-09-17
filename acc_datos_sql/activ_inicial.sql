create database activ_inicial;
use activ_inicial;
create table usuario (
id_usuario int primary key,
nombre varchar(250) not null,
isStreamer bit not null,
email varchar(250) not null,
fecha_registro  datetime not null
);
create table canal (
id_canal int primary key,
fecha_creacion  datetime not null,
foreign key (id_canal) references usuario(id_usuario)
);
create table retransmision (
id_retrans int primary key,
duracion time not null,
foreign key (id_retrans) references canal(id_canal)
);
create table sigue (
id_usuario int,
id_canal int,
foreign key (id_usuario) references canal(id_canal),
foreign key (id_canal) references usuario(id_usuario)
);
