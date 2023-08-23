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
	UsuEmail char(50) not null unique,
    UsuSenha char(10) not null,
    IgrejaFav int
);

alter table tbUsuario add constraint fkIgrejaFav foreign key (IgrejaFav) references tbIgrejaFav(idIgreja);

delimiter $$
create procedure spInsertUsuario(vEmail char(50), vSenha char(10), vIgreja char(50))
begin
	set @IgrejaFavorita = (select idIgreja from tbIgrejaFav where NomeIgreja = vIgreja);
	insert into tbUsuario values(default, vEmail, vSenha, @IgrejaFavorita);
end;
$$

create procedure spSelectIgrejaFav(vEmail char(50))
begin
	Select NomeIgreja as "Igreja Favorita", RuaIgreja as "Endereço da Igreja", CEPIgreja as "CEP da Igreja", UFIgreja as "UF", TelIgreja as "Telefone" FROM tbIgrejaFav inner join tbUsuario where tbUsuario.IgrejaFav = tbIgrejaFav.idIgreja and UsuEmail = vEmail;
end;
$$

delimiter $$
create procedure spInsertIgrejaFav(vNomeIgreja char(50), vRuaIgreja char(50), vCEPIgreja char(8), vUFIgreja char(2), vTelIgreja char(11)) begin
	set @vIgrejaExistente = (select nomeIgreja from tbIgrejaFav where vNomeIgreja = NomeIgreja); 
		if not exists(select @vIgrejaExistente) then 
			insert into tbIgrejaFav values (default, vNomeIgreja, vRuaIgreja, vCEPIgreja, vUFIgreja, vTelIgreja);
		else (select("Igreja já Cadastrada!"));
        end if;
		
end;
$$

spInsertUsuario("alezito@gmail.com", "345678", "");
call spSelectIgrejaFav("pedrinhe.laurzite@gmail.com");

delimiter ;
insert into tbIgrejaFav values(default,"Capelo Nossa Senhora da Conceição", "Rua Nossa Senhora da Conceição", "06894822", "SP", "11865294568");
call spInsertUsuario("pedrinhe.laurzite@gmail.com", "2345MEIA78", "Capelo Nossa Senhora da Conceição");
call spSelectIgrejaFav("pedrinhe.laurzite@gmail.com");
call spInsertIgrejaFav("Igreja Matriz Jaraguá", "Rua Nossa Senhora das Graças", "09568433", "SP", "11596623458");


select * from tbUsuario;
select * from tbIgrejaFav;