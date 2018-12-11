create table file (
    id bigint not null,
    date_load bigint not null,
    file_condition bit not null,
    name varchar(255),
    save_time bigint not null,
    weight bigint not null,
    primary key (id)
    ) engine=MyISAM;

create table hibernate_sequence (
    next_val bigint
    ) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table statistic (
    id bigint not null,
    class_name varchar(255),
    end_time bigint not null,
    method_name varchar(255),
    start_time bigint not null,
    user varchar(255),
    file_id bigint not null,
    primary key (id)
    ) engine=MyISAM;

alter table statistic
    add constraint statistic_file_fk
    foreign key (file_id) references file (id);