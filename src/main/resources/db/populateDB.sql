DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM votes;
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

INSERT INTO user_roles (role, userId) VALUES
  ('ROLE_ADMIN', 100000),
  ('ROLE_USER', 100001),
  ('ROLE_USER', 100002),
  ('ROLE_USER', 100003);

INSERT INTO restaurants (name) VALUES
  ('Берёзка'),
  ('McBurger'),
  ('Prague');

INSERT INTO meals (restaurantId, date, description, price) VALUES
  ('100004','2017-07-26', 'Борщец', 100),
  ('100004','2017-07-26', 'Шашлычок', 200),
  ('100004','2017-07-26', 'Картофель жаренный', 50),
  ('100004','2017-07-26', 'Водка "Походка"', 150),
  ('100005','2017-07-26', 'Happy fat', 120),
  ('100005','2017-07-26', 'Burger diet', 80),
  ('100005','2017-07-26', 'Greek salad', 200),
  ('100005','2017-07-26', 'Potatoes', 90),
  ('100005','2017-07-26', 'Smoothies', 800),
  ('100005','2017-07-26', 'Muffin', 350),
  ('100006','2017-07-26', 'Окрошка', 2500),
  ('100006','2017-07-26', 'Котлета от шефа', 1500),
  ('100006','2017-07-26', 'Морс', 800),
  ('100006','2017-07-26', 'Хлеб', 250);

INSERT INTO votes (date, userId, restaurantId) VALUES
  ('2017-07-26', 100000, 100006),
  ('2017-07-26', 100001, 100004),
  ('2017-07-26', 100002, 100006);
