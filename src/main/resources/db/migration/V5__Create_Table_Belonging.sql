create table tb_belonging (
    position integer,
    game_id bigint not null,
    list_id bigint not null,
    primary key (game_id, list_id)
);