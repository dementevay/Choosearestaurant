DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM vote;
DELETE FROM restaurants;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

-- user1
INSERT INTO users (name, email, password, enabled)
VALUES ('User1', 'user1@yandex.ru', 'password1', TRUE );
-- user2
INSERT INTO users (name, email, password, enabled)
VALUES ('User2', 'user2@yandex.ru', 'password2', TRUE );
-- user3
INSERT INTO users (name, email, password, enabled)
VALUES ('User3', 'user3@yandex.ru', 'password3', TRUE );
-- admin
INSERT INTO users (name, email, password, enabled)
VALUES ('Admin', 'admin@gmail.com', 'password', TRUE );

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_ADMIN', 100000),
  ('ROLE_USER', 100001),
  ('ROLE_USER', 100002),
  ('ROLE_USER', 100003);

INSERT INTO restaurants (name) VALUES
  ('Берёзка'),
  ('McBurger'),
  ('Prague');

INSERT INTO meals (restaurant_id, date_time, description, price) VALUES
  ('100004','2017-07-26 10:00:00', 'Борщ', 100),
  ('100004','2017-07-26 10:00:00', 'Шашлык', 200),
  ('100004','2017-07-26 10:00:00', 'Картофель жаренный', 50),
  ('100004','2017-07-26 10:00:00', 'Водка', 150),
  ('100005','2017-07-26 10:00:00', 'happy fat', 120),
  ('100005','2017-07-26 10:00:00', 'hamburger', 80),
  ('100005','2017-07-26 10:00:00', 'Greek salad', 200),
  ('100005','2017-07-26 10:00:00', 'potatoes', 90),
  ('100006','2017-07-26 10:00:00', 'Окрошка', 2500),
  ('100006','2017-07-26 10:00:00', 'Котлета от шефа', 1500),
  ('100006','2017-07-26 10:00:00', 'Морс', 800),
  ('100006','2017-07-26 10:00:00', 'Хлеб', 250);

INSERT INTO vote (date_time, user_id, restaurant_id) VALUES
  ('2017-07-26 10:00:00', 100000, 100006),
  ('2017-07-26 10:00:00', 100001, 100004),
  ('2017-07-26 10:00:00', 100002, 100006);
