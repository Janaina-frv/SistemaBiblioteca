drop table if exists aluno CASCADE ;
drop table if exists aluno_disciplina CASCADE ;
drop table if exists avaliacoes CASCADE ;
drop table if exists disciplina CASCADE ;
drop table if exists professor CASCADE ;
drop table if exists turma CASCADE ;

create table aluno (id integer not null AUTO_INCREMENT, nome varchar(255), id_turma integer, primary key (id));
create table aluno_disciplina (id_aluno integer not null AUTO_INCREMENT, id_disciplina integer not null);
create table avaliacoes (conceito varchar(255), disciplina_id integer not null, aluno_id integer not null, primary key (aluno_id, disciplina_id));
create table disciplina (id integer not null AUTO_INCREMENT, nome varchar(255), primary key (id));
create table professor (id integer not null AUTO_INCREMENT, nome varchar(255), primary key (id));
create table turma (id integer not null AUTO_INCREMENT, ano varchar(255), curso varchar(255), nome varchar(255), primary key (id));
alter table aluno add constraint FK6u9nh0rofks23793tl5j0f7v3 foreign key (id_turma) references turma;
alter table aluno_disciplina add constraint FK63wa144etj0sdx5pa9k3dafu4 foreign key (id_disciplina) references disciplina;
alter table aluno_disciplina add constraint FK1k24treo6t0cpruvx66jn25b1 foreign key (id_aluno) references aluno;
alter table avaliacoes add constraint FK84shm6tyijbbe8671yopxoiof foreign key (disciplina_id) references disciplina;
