create table public.address
(
    id          serial
        primary key,
    coordinatex real,
    coordinatey real
);


create table public.depot
(
    id         bigserial
        primary key,
    name       varchar(255),
    address_id integer
        constraint fkp9tu1432l5dfxslndgy0mduh5
            references public.address
);


create table public.supplier
(
    id   bigserial
        primary key,
    name varchar(255)
);


create table public.plan
(
    id             bigint not null
        primary key,
    plan_status    integer,
    start_time     timestamp,
    total_distance double precision,
    depot_id       bigint
        constraint fkkl1a34nc5ffoqlfyeoq3xtbv7
            references public.depot
);

create table public.custom_order
(
    id           bigserial
        primary key,
    order_name   varchar(255),
    order_number bigint,
    order_status integer,
    supplier_id  bigint
        constraint fkl84ct46gyvnajfm2fhccjke70
            references public.supplier,
    order_date   timestamp,
    retry        integer,
    plan_id      bigint
        constraint fk5qyfh9jli2qo622hv3952cujq
            references public.plan
);


create table public.package
(
    id              bigserial
        primary key,
    status          integer,
    address_id      integer
        constraint fkrehlwn0jrrmeh9mxlno2nhonv
            references public.address,
    custom_order_id bigint
        constraint fk3kahqoi0eqmiw9ei9h2jn97ek
            references public.custom_order
);

