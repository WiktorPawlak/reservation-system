insert into MOVIES(id, title, duration) values (1, 'Fantastic Beasts: The Secrets of Dumbledore', '01:30:00');
insert into MOVIES(id, title, duration) values (2, 'Batman', '02:56:00');
insert into MOVIES(id, title, duration) values (3, 'Morbius', '01:32:00');
insert into MOVIES(id, title, duration) values (4, 'Nogi w pokrzywach', '00:45:00');
insert into MOVIES(id, title, duration) values (5, 'Dwa samce na klamce', '01:30:00');
insert into MOVIES(id, title, duration) values (6, 'Zabili go i uciekł', '03:50:00');
insert into MOVIES(id, title, duration) values (7, 'Głowa w betoniarce', '00:33:00');
insert into MOVIES(id, title, duration) values (8, 'Suche majtki na dnie morza', '01:56:00');

insert into ROOMS(id) values (1);
insert into ROOMS(id) values (2);
insert into ROOMS(id) values (3);

insert into SCREENINGS(id, movie_id, room_id, date) values (1, 1, 1, '2022-04-019T11:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (4, 4, 1, '2022-04-020T11:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (2, 2, 2, '2022-04-019T11:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (5, 5, 2, '2022-04-020T10:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (7, 7, 2, '2022-04-020T12:20:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (3, 3, 3, '2022-04-019T11:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (6, 6, 3, '2022-04-020T11:00:00.00');

insert into RESERVATIONS(id, screening_id, name, surname, price, expiration_time)
values (1, 1, 'Jan', 'Ziutek', 25, '2022-04-019T12:30:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, price, expiration_time)
values (2, 2, 'Bolek', 'Student', 18, '2022-04-019T13:56:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, price, expiration_time)
values (3, 3, 'Adaś', 'Bajer', 12.50, '2022-04-019T12:32:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, price, expiration_time)
values (4, 4, 'Oskar', 'Boski', 18, '2022-04-019T11:45:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, price, expiration_time)
values (5, 5, 'Jan', 'Ziutek', 25, '2022-04-019T11:30:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, price, expiration_time)
values (6, 6, 'Jan', 'Ziutek', 25, '2022-04-019T14:50:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, price, expiration_time)
values (7, 7, 'Oskar', 'Boski', 18, '2022-04-019T12:53:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, price, expiration_time)
values (8, 7, 'Bolek', 'Student', 18, '2022-04-019T12:53:00.00');

insert into SEATS(id, seat_number, room_id) values (1, 11, 1);
insert into SEATS(id, seat_number, room_id) values (2, 12, 1);
insert into SEATS(id, seat_number, room_id) values (3, 13, 1);
insert into SEATS(id, seat_number, room_id) values (4, 14, 1);
insert into SEATS(id, seat_number, room_id) values (5, 15, 1);
insert into SEATS(id, seat_number, room_id) values (6, 21, 1);
insert into SEATS(id, seat_number, room_id) values (7, 22, 1);
insert into SEATS(id, seat_number, room_id) values (8, 23, 1);
insert into SEATS(id, seat_number, room_id) values (9, 24, 1);
insert into SEATS(id, seat_number, room_id) values (10, 25, 1);
insert into SEATS(id, seat_number, room_id) values (11, 31, 1);
insert into SEATS(id, seat_number, room_id) values (12, 32, 1);
insert into SEATS(id, seat_number, room_id) values (13, 33, 1);
insert into SEATS(id, seat_number, room_id) values (14, 34, 1);
insert into SEATS(id, seat_number, room_id) values (15, 35, 1);

insert into SEATS(id, seat_number, room_id) values (16, 11, 2);
insert into SEATS(id, seat_number, room_id) values (17, 12, 2);
insert into SEATS(id, seat_number, room_id) values (18, 13, 2);
insert into SEATS(id, seat_number, room_id) values (19, 14, 2);
insert into SEATS(id, seat_number, room_id) values (20, 15, 2);
insert into SEATS(id, seat_number, room_id) values (21, 21, 2);
insert into SEATS(id, seat_number, room_id) values (22, 22, 2);
insert into SEATS(id, seat_number, room_id) values (23, 23, 2);
insert into SEATS(id, seat_number, room_id) values (24, 24, 2);
insert into SEATS(id, seat_number, room_id) values (25, 25, 2);
insert into SEATS(id, seat_number, room_id) values (26, 31, 2);
insert into SEATS(id, seat_number, room_id) values (27, 32, 2);
insert into SEATS(id, seat_number, room_id) values (28, 33, 2);
insert into SEATS(id, seat_number, room_id) values (29, 34, 2);
insert into SEATS(id, seat_number, room_id) values (30, 35, 2);

insert into SEATS(id, seat_number, room_id) values (31, 11, 3);
insert into SEATS(id, seat_number, room_id) values (32, 12, 3);
insert into SEATS(id, seat_number, room_id) values (33, 13, 3);
insert into SEATS(id, seat_number, room_id) values (34, 14, 3);
insert into SEATS(id, seat_number, room_id) values (35, 15, 3);
insert into SEATS(id, seat_number, room_id) values (36, 21, 3);
insert into SEATS(id, seat_number, room_id) values (37, 22, 3);
insert into SEATS(id, seat_number, room_id) values (38, 23, 3);
insert into SEATS(id, seat_number, room_id) values (39, 24, 3);
insert into SEATS(id, seat_number, room_id) values (40, 25, 3);
insert into SEATS(id, seat_number, room_id) values (41, 31, 3);
insert into SEATS(id, seat_number, room_id) values (42, 32, 3);
insert into SEATS(id, seat_number, room_id) values (43, 33, 3);
insert into SEATS(id, seat_number, room_id) values (44, 34, 3);
insert into SEATS(id, seat_number, room_id) values (45, 35, 3);

insert into BOOKED_SEAT(id, seat_id, screening_id) values (1, 1, 1);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (2, 2, 1);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (3, 3, 1);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (4, 6, 5);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (5, 7, 5);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (6, 8, 5);

