drop database API_SpreadBible;
create database API_SpreadBible;
use API_SpreadBible;

create table tbIgrejaFav(
    idIgreja int primary key auto_increment,
    NomeIgreja char(50) not null,
    RuaIgreja char(50) not null,
    CEPIgreja char(8) not null,
    UFIgreja char(2) not null,
    TelIgreja char(11) not null
);

create table tbUsuario(
	IdUsu int primary key auto_increment,
	UsuEmail char(50) not null,
    UsuSenha char(10) not null,
    IgrejaFav int,
    foreign key (IgrejaFav) references tbIgrejaFav(idIgreja)
);

insert into tbIgrejaFav values(default,"Capela Nossa Senhora da Conceição", "Rua Nossa Senhora da Conceição", "06894822", "SP", "11865294568");


create procedure spInsereIgreja (@NomeIgreja)
begin
set @IgrejaFavorita = (select idIgreja from tbIgrejaFav where NomeIgreja = @NomeIgreja);
end

insert into tbUsuario values(default, "pedrinho@gmail.com", "158575", @IgrejaFavorita);






Select * from tbUsuario;