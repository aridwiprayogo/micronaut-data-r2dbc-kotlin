CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE news(
    id          UUID            default uuid_generate_v4(),
    title       varchar not null,
    body        varchar not null,
    description text    not null
);

ALTER TABLE public.news ADD PRIMARY KEY(id);
