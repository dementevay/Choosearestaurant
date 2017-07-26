DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS vote;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  enabled    BOOL DEFAULT TRUE
);
/*CREATE UNIQUE INDEX users_unique_email_idx ON users (email);*/

CREATE TABLE user_roles
(
  role    VARCHAR,
  user_id INTEGER NOT NULL,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR NOT NULL
);

CREATE TABLE meals (
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restaurant_id   INTEGER NOT NULL,
  date_time       TIMESTAMP NOT NULL,
  name            TEXT NOT NULL,
  price           INT NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
/*CREATE UNIQUE INDEX meals_unique_user_datetime_idx ON meals(restourant_id, date_time)*/

CREATE TABLE vote (
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date_time       TIMESTAMP NOT NULL,
  user_id         INTEGER NOT NULL,
  restaurant_id   INTEGER NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
