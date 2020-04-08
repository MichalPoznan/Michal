create table todo (
    ID int unsigned primary key auto_increment,
    text varchar(100) not null,
    done bool not null
    -- bool lub bit
);
