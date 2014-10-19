# --- !Ups
CREATE TABLE events (
    id long auto_increment,
    startDate timestamp,
    endDate timestamp,
    venue long,
    eventType int,
    name varchar,
    description varchar
    );

CREATE TABLE venues (
    id long auto_increment,
    x long,
    y long,
    name varchar,
    address varchar,
    description varchar
    );

# --- !Downs
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS venues;