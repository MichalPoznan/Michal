create table todo (
    ID int unsigned primary key auto_increment,
    text varchar(100) not null,
    done bit
    -- bool lub bit
);


insert into todo (text, done) values ('todo1', 1);
insert into todo (text, done) values ('todo2', 0);

