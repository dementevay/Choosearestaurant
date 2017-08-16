DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;
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
  userId INTEGER NOT NULL,
  CONSTRAINT user_roles_idx UNIQUE (userId, role),
  FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR NOT NULL
);

CREATE TABLE meals (
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restaurantId   INTEGER NOT NULL,
  date       TIMESTAMP NOT NULL,
  description     TEXT NOT NULL,
  price           INT NOT NULL,
  FOREIGN KEY (restaurantId) REFERENCES restaurants (id) ON DELETE CASCADE
);
CREATE INDEX meals_unique_restaurant_datetime_idx ON meals(restaurantId, date);

CREATE TABLE votes (
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date            TIMESTAMP NOT NULL,
  userId         INTEGER NOT NULL,
  restaurantId   INTEGER NOT NULL,
  FOREIGN KEY (restaurantId) REFERENCES restaurants (id) ON DELETE CASCADE,
  FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE
);
