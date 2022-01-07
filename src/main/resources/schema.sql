drop table if exists branch cascsde;
CREATE TABLE Branch (
    id serial NOT NULL PRIMARY KEY,
    city text unique NOT NULL,
    index integer NOT NULL constraint min_index check (index > 0),
    number integer NOT NULL constraint min_num check (number > 0),
    address text NOT NULL
);