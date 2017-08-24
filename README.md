Choose a restaurant for dinner! 
===============================
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4b796156bb2c41b3a72548dabed83a43)](https://www.codacy.com/app/dementevay/Choosearestaurant?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=dementevay/Choosearestaurant&amp;utm_campaign=Badge_Grade)

Проект по выбору ресторана для обеда по [тестовому заданию](https://docs.google.com/document/d/1f8QLJ3S2tUH_o_cKcUcuEedt1pttf04LU46tLUb35Os/edit?usp=sharing)

Приложение в работе можно посмотреть: [http://78.107.252.233:8080/voting/](http://78.107.252.233:8080/voting/)

Технологии : Maven/ Spring/ JPA(Hibernate)/ REST(Jackson)/ PostrgeSQL/ Tomcat/ Logback


### REST API для росторанов, еды и голосов.
Ответы в формате json, post запросы в json.

#### RESTAURANT `/rest/restaurants`:

Метод | Действие | Запрос | Пример
--- | --- | --- | ---
GET | Все рестораны с меню | `/` | /
GET | Все рестораны с меню на дату | `/date/`LocalDate | /date/2017-07-26
GET | Ресторан с меню | `/`id | /100004
GET | Ресторан с меню на дату | `/`id/LocalDate | /100004/2017-07-26
POST | Новый ресторан с меню | `/`{restaurantWithMenu} | /{restaurantWithMenu}
PUT | Обновить ресторан с меню | `/`{restaurantWithMenu} | /{restaurantWithMenu}
DELETE | Удалить  ресторан | `/`id | /100004
DELETE | Удалить все рестораны | `/` | /

Примеры curl:
1.  curl "http://localhost:8080/dem/rest/restaurants/"
2.  curl "http://localhost:8080/dem/rest/restaurants/date/2017-07-26"  
3.  curl "http://localhost:8080/dem/rest/restaurants/100004"
4.  curl "http://localhost:8080/dem/rest/restaurants/100004/2017-07-26"
5.  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d '{"id":0,"name":"New Restaurant","menu":[{"id":0,"restaurantId":0,"description":"Борщ","date":"2017-07-26","price":500},{"id":0,"restaurantId":0,"description":"Шашлык","date":"2017-07-26","price":500},{"id":0,"restaurantId":0,"description":"Картофель жаренный","date":"2017-07-26","price":500},{"id":0,"restaurantId":0,"description":"Водка","date":"2017-07-26","price":540}]}' http://localhost:8080/dem/rest/restaurants
6.  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X PUT -d '{"id":100004,"name":"Берёзка","menu":[{"id":100007,"restaurantId":100004,"description":"Борщ","date":"2017-07-26","price":500},{"id":100008,"restaurantId":100004,"description":"Шашлык","date":"2017-07-26","price":500},{"id":100009,"restaurantId":100004,"description":"Картофель жаренный","date":"2017-07-26","price":500},{"id":100010,"restaurantId":100004,"description":"Водка","date":"2017-07-26","price":540}]}' http://localhost:8080/dem/rest/restaurants
7.  curl -X DELETE http://localhost:8080/dem/rest/restaurants/100005
8.  curl -X DELETE http://localhost:8080/dem/rest/restaurants/

#### VOTE `/rest/votes`:
Ответы в формате json, post запросы в json.

Метод | Действие | Запрос | Пример
--- | --- | --- | ---
GET | Все голоса | `/` | / 
GET | Голоса на дату | `/date/`LocalDate | /date/2017-10-02
GET | id победителя на дату | `/winner/`LocalDate | /winner/2017-10-02
POST | Новый голос | `/`{vote} | /{vote}
PUT | Изменить решение | `/`{vote} | /{vote}

Примеры curl:
1.  curl "http://localhost:8080/dem/rest/votes/"
2.  curl "http://localhost:8080/dem/rest/votes/date/2017-07-26"
3.  curl "http://localhost:8080/dem/rest/votes/100021"
4.  curl "http://localhost:8080/dem/rest/votes/winner/2017-07-26"
5.  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d '{"date":"2017-07-27","userId":100000,"restaurantId":100005}' http://localhost:8080/dem/rest/votes
6.  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X PUT -d '{"id":100021,"date":"2017-07-26","userId":100000,"restaurantId":100005}' http://localhost:8080/dem/rest/votes




#### MEAL `/rest/meals`:
Ответы в формате json, post запросы в json.

Метод | Действие | Запрос | Пример
--- | --- | --- | ---
GET | Блюдо | `/` | /100019
GET | Меню ресторана | `/restaurant/`id | /restaurant/100004
GET | Меню ресторана на дату | `/restaurant/`id/LocalDate | /restaurant/100004/2017-07-26
POST | Новое блюдо | `/create` {meal} | /create {meal}
PUT | Обновить блюдо | `/update` {meal} | /update {meal}
DELETE | Удалить  блюдо | `/`id | `/`100024
DELETE | Удалить все блюда | `/` | /
DELETE | Удалить все блюда за дату | `/date/`LocalDate | /date/2017-07-26
DELETE | Удалить блюда ресторана | `/restaurant/`restaurantId | /restaurant/100004
DELETE | Удалить блюда ресторана за дату | `/restaurant/`restaurantId/LocalDate | /restaurant/100004/2017-07-26

Примеры curl:
1.  curl "http://localhost:8080/dem/rest/meals/100019"
2.  curl "http://localhost:8080/dem/rest/meals/restaurant/100004"
3.  curl "http://localhost:8080/dem/rest/meals/restaurant/100004/2017-07-26"
4.  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST -d '{"id":0,"restaurantId":100004,"description":"Башмачок","date":"2017-07-26","price":200}' http://localhost:8080/dem/rest/meals/create
5.  curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X PUT -d '{"id":100010,"restaurantId":100004,"description":"Башмачок","date":"2017-07-26","price":210}' http://localhost:8080/dem/rest/meals/update
6.  curl -X DELETE http://localhost:8080/dem/rest/meals/100024
7.  curl -X DELETE http://localhost:8080/dem/rest/meals/
8.  curl -X DELETE http://localhost:8080/dem/rest/meals/date/2017-07-26
9.  curl -X DELETE http://localhost:8080/dem/rest/meals/restaurant/100004
10.  curl -X DELETE http://localhost:8080/dem/rest/meals/restaurant/100004/2017-07-26



