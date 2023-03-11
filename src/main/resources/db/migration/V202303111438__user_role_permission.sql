create table template.user
(
    user_id      varchar(36)  not null primary key,
    username     varchar(64)  not null unique,
    display_name varchar(64)  not null,
    is_enabled   bit          not null,
    password     varchar(255) not null,
    created_at   timestamp    not null default current_timestamp,
    updated_at   timestamp    not null default current_timestamp on update current_timestamp
);

create table template.role
(
    role_id     varchar(36)  not null primary key,
    name        varchar(64)  not null unique,
    description varchar(255) not null,
    created_at  timestamp    not null default current_timestamp,
    updated_at  timestamp    not null default current_timestamp on update current_timestamp
);

create table template.user_role
(
    user_id    varchar(36) not null,
    role_id    varchar(36) not null,
    created_at timestamp   not null default current_timestamp,
    updated_at timestamp   not null default current_timestamp on update current_timestamp,
    primary key `p_user_role` (user_id, role_id)
);

create table template.permission
(
    permission_id varchar(36)  not null primary key,
    name          varchar(64)  not null unique,
    description   varchar(255) not null,
    created_at    timestamp    not null default current_timestamp,
    updated_at    timestamp    not null default current_timestamp on update current_timestamp
);

create table template.role_permission
(
    role_id       varchar(36)  not null,
    permission_id varchar(36)  not null,
    description   varchar(255) not null,
    created_at    timestamp    not null default current_timestamp,
    updated_at    timestamp    not null default current_timestamp on update current_timestamp,
    primary key `p_role_permission` (role_id, permission_id)
);
