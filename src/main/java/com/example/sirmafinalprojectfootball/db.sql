create table teams
(
    team_id           int         not null
        primary key,
    name              varchar(20) not null,
    manager_full_name varchar(30) not null,
    group_name        varchar(10) not null
)
    collate = utf8mb4_unicode_ci;

create table matches
(
    matches_id int         not null
        primary key,
    aTeam_id   int         not null,
    bTeam_id   int         not null,
    date       datetime    not null,
    score      varchar(10) not null,
    constraint matches_teams_team_id_fk
        foreign key (aTeam_id) references teams (team_id),
    constraint matches_teams_team_id_fk2
        foreign key (bTeam_id) references teams (team_id)
)
    collate = utf8mb4_unicode_ci;

create table players
(
    player_id   int          not null
        primary key,
    team_number int          not null,
    position    varchar(2)   not null,
    full_name   varchar(255) null,
    team_id     int          not null,
    constraint players_teams_team_id_fk
        foreign key (team_id) references teams (team_id)
)
    collate = utf8mb4_unicode_ci;

create table pairs
(
    pair_id    int auto_increment
        primary key,
    playerA_id int not null,
    playerB_id int not null,
    total_time int null,
    constraint pair_players_player_id_fk
        foreign key (playerA_id) references players (player_id),
    constraint pair_players_player_id_fk2
        foreign key (playerB_id) references players (player_id)
);

create table pair_integer_map
(
    pair_id     int not null,
    match_id    int not null,
    time_played int null,
    primary key (pair_id, match_id),
    constraint pair_integer_map_pairs_pair_id_fk
        foreign key (pair_id) references pairs (pair_id)
);

create table records
(
    record_id    int not null
        primary key,
    player_id    int not null,
    match_id     int not null,
    from_minutes int null,
    to_minutes   int null,
    constraint records_matches_matches_id_fk
        foreign key (match_id) references matches (matches_id),
    constraint records_players_player_id_fk
        foreign key (player_id) references players (player_id)
)
    collate = utf8mb4_unicode_ci;