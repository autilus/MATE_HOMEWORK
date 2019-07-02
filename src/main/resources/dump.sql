create database hw0307
    with owner maksymskripai;

create table users
(
    id       bigserial not null
        constraint users_pk
            primary key,
    login    varchar   not null,
    password varchar   not null
);

alter table users
    owner to maksymskripai;

