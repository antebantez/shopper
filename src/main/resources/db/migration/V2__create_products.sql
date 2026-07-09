CREATE TABLE products
(
    id         UUID PRIMARY KEY,
    name       varchar(255)             NOT NULL UNIQUE,
    created_at TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);

INSERT INTO products (id, name, created_at, updated_at)
VALUES ('00000000-0000-0000-0000-000000000001', 'Mjölk', now(), now()),
       ('00000000-0000-0000-0000-000000000002', 'Smör', now(), now()),
       ('00000000-0000-0000-0000-000000000003', 'Bröd', now(), now()),
       ('00000000-0000-0000-0000-000000000004', 'Ägg', now(), now()),
       ('00000000-0000-0000-0000-000000000005', 'Kaffe', now(), now());