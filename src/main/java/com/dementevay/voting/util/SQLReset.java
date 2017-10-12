package com.dementevay.voting.util;

/**
 * Created by Andrey Dementev on 12.10.17.
 */
public class SQLReset {
    public static String init = "DROP TABLE IF EXISTS user_roles;\n" +
            "DROP TABLE IF EXISTS meals;\n" +
            "DROP TABLE IF EXISTS votes;\n" +
            "DROP TABLE IF EXISTS restaurants;\n" +
            "DROP TABLE IF EXISTS users;\n" +
            "DROP SEQUENCE IF EXISTS global_seq;\n" +
            "\n" +
            "CREATE SEQUENCE global_seq START 100000;\n" +
            "\n" +
            "CREATE TABLE users\n" +
            "(\n" +
            "  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),\n" +
            "  name       VARCHAR NOT NULL,\n" +
            "  email      VARCHAR NOT NULL,\n" +
            "  password   VARCHAR NOT NULL,\n" +
            "  enabled    BOOL DEFAULT TRUE\n" +
            ");\n" +
            "/*CREATE UNIQUE INDEX users_unique_email_idx ON users (email);*/\n" +
            "\n" +
            "CREATE TABLE user_roles\n" +
            "(\n" +
            "  role    VARCHAR,\n" +
            "  userId INTEGER NOT NULL,\n" +
            "  CONSTRAINT user_roles_idx UNIQUE (userId, role),\n" +
            "  FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE restaurants (\n" +
            "  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),\n" +
            "  name        VARCHAR NOT NULL\n" +
            ");\n" +
            "\n" +
            "CREATE TABLE meals (\n" +
            "  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),\n" +
            "  restaurantId   INTEGER NOT NULL,\n" +
            "  date       TIMESTAMP NOT NULL,\n" +
            "  description     TEXT NOT NULL,\n" +
            "  price           INT NOT NULL,\n" +
            "  FOREIGN KEY (restaurantId) REFERENCES restaurants (id) ON DELETE CASCADE\n" +
            ");\n" +
            "CREATE INDEX meals_unique_restaurant_datetime_idx ON meals(restaurantId, date);\n" +
            "\n" +
            "CREATE TABLE votes (\n" +
            "  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),\n" +
            "  date            TIMESTAMP NOT NULL,\n" +
            "  userId         INTEGER NOT NULL,\n" +
            "  restaurantId   INTEGER NOT NULL,\n" +
            "  FOREIGN KEY (restaurantId) REFERENCES restaurants (id) ON DELETE CASCADE,\n" +
            "  FOREIGN KEY (userId) REFERENCES users (id) ON DELETE CASCADE\n" +
            ");\n";

    public static String populate = "DELETE FROM user_roles;\n" +
            "DELETE FROM meals;\n" +
            "DELETE FROM votes;\n" +
            "DELETE FROM restaurants;\n" +
            "DELETE FROM users;\n" +
            "ALTER SEQUENCE global_seq RESTART WITH 100000;\n" +
            "\n" +
            "-- user1\n" +
            "INSERT INTO users (name, email, password, enabled)\n" +
            "VALUES ('User1', 'user1@yandex.ru', '$2a$10$ZMJUBhToLuVGtgUVhkIHPualk847/f1Bb3n5KbU5ItANRu/1/t6QO', TRUE );\n" +
            "-- user2\n" +
            "INSERT INTO users (name, email, password, enabled)\n" +
            "VALUES ('User2', 'user2@yandex.ru', '$2a$10$6oqp.fW9j7z7EKIpCKIgUekqEmS/A8Y.cQdlWb49Rm5sJGCL7NZ5W', TRUE );\n" +
            "-- user3\n" +
            "INSERT INTO users (name, email, password, enabled)\n" +
            "VALUES ('User3', 'user3@yandex.ru', '$2a$10$RhAiGzRlORqCFiafVbQgC.8loRkDewSSdxbK/UJOtZ0lnm7mVdwfu', TRUE );\n" +
            "-- admin\n" +
            "INSERT INTO users (name, email, password, enabled)\n" +
            "VALUES ('Admin', 'admin@gmail.com', '$2a$10$9ifN7k1EP.VntL16LiIWgu3uT/aF4//c0xl.AO0Z.hIGhd.b/IEGy', TRUE );\n" +
            "\n" +
            "INSERT INTO user_roles (role, userId) VALUES\n" +
            "  ('ROLE_USER', 100000),\n" +
            "  ('ROLE_USER', 100001),\n" +
            "  ('ROLE_USER', 100002),\n" +
            "  ('ROLE_ADMIN', 100003);\n" +
            "\n" +
            "INSERT INTO restaurants (name) VALUES\n" +
            "  ('Берёзка'),\n" +
            "  ('McBurger'),\n" +
            "  ('Prague');\n" +
            "\n" +
            "INSERT INTO meals (restaurantId, date, description, price) VALUES\n" +
            "  ('100004','2017-07-26', 'Борщец', 100),\n" +
            "  ('100004','2017-07-26', 'Шашлычок', 200),\n" +
            "  ('100004','2017-07-26', 'Картофель жаренный', 50),\n" +
            "  ('100004','2017-07-26', 'Водка Походка', 150),\n" +
            "  ('100005','2017-07-26', 'Happy fat', 120),\n" +
            "  ('100005','2017-07-26', 'Burger diet', 80),\n" +
            "  ('100005','2017-07-26', 'Greek salad', 200),\n" +
            "  ('100005','2017-07-26', 'Potatoes', 90),\n" +
            "  ('100005','2017-07-26', 'Smoothies', 800),\n" +
            "  ('100005','2017-07-26', 'Muffin', 350),\n" +
            "  ('100006','2017-07-26', 'Окрошка', 2500),\n" +
            "  ('100006','2017-07-26', 'Котлета от шефа', 1500),\n" +
            "  ('100006','2017-07-26', 'Морс', 800),\n" +
            "  ('100006','2017-07-26', 'Хлеб', 250);\n" +
            "\n" +
            "INSERT INTO votes (date, userId, restaurantId) VALUES\n" +
            "  ('2017-07-26', 100000, 100006),\n" +
            "  ('2017-07-26', 100001, 100004),\n" +
            "  ('2017-07-26', 100002, 100006);\n";
}
