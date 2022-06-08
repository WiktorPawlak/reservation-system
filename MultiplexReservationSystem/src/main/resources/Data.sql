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

insert into SCREENINGS(id, movie_id, room_id, date) values (1, 1, 1, '2022-04-027T11:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (2, 2, 2, '2023-04-019T11:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (3, 3, 3, '2023-04-019T11:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (4, 4, 1, '2023-04-020T11:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (5, 5, 2, '2023-04-020T10:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (6, 6, 3, '2023-04-020T11:00:00.00');
insert into SCREENINGS(id, movie_id, room_id, date) values (7, 7, 2, '2023-04-020T12:20:00.00');

insert into RESERVATIONS(id, screening_id, name, surname, expiration_time)
values (1, 1, 'Jan', 'Ziutek', '2022-04-027T12:30:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, expiration_time)
values (2, 2, 'Bolek', 'Student', '2023-04-019T13:56:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, expiration_time)
values (3, 3, 'Adaś', 'Bajer', '2023-04-019T12:32:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, expiration_time)
values (4, 4, 'Oskar', 'Boski', '2023-04-020T11:45:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, expiration_time)
values (5, 5, 'Jan', 'Ziutek', '2023-04-020T11:30:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, expiration_time)
values (6, 6, 'Jan', 'Ziutek', '2023-04-020T14:50:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, expiration_time)
values (7, 7, 'Oskar', 'Boski', '2023-04-020T12:53:00.00');
insert into RESERVATIONS(id, screening_id, name, surname, expiration_time)
values (8, 7, 'Bolek', 'Student', '2023-04-020T12:53:00.00');

insert into SEATS(id, row_number, seat_number, room_id) values (1, 1, 1, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (2, 1, 2, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (3, 1, 3, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (4, 1, 4, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (5, 1, 5, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (6, 2, 1, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (7, 2, 2, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (8, 2, 3, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (9, 2, 4, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (10, 2, 5, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (11, 3, 1, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (12, 3, 2, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (13, 3, 3, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (14, 3, 4, 1);
insert into SEATS(id, row_number, seat_number, room_id) values (15, 3, 5, 1);

insert into SEATS(id, row_number, seat_number, room_id) values (16, 1, 1, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (17, 1, 2, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (18, 1, 3, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (19, 1, 4, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (20, 1, 5, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (21, 2, 1, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (22, 2, 2, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (23, 2, 3, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (24, 2, 4, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (25, 2, 5, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (26, 3, 1, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (27, 3, 2, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (28, 3, 3, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (29, 3, 4, 2);
insert into SEATS(id, row_number, seat_number, room_id) values (30, 3, 5, 2);

insert into SEATS(id, row_number, seat_number, room_id) values (31, 1, 1, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (32, 1, 2, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (33, 1, 3, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (34, 1, 4, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (35, 1, 5, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (36, 2, 1, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (37, 2, 2, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (38, 2, 3, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (39, 2, 4, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (40, 2, 5, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (41, 3, 1, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (42, 3, 2, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (43, 3, 3, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (44, 3, 4, 3);
insert into SEATS(id, row_number, seat_number, room_id) values (45, 3, 5, 3);

insert into BOOKED_SEAT(id, seat_id, screening_id) values (1, 1, 1);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (2, 16, 2);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (3, 31, 3);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (4, 2, 4);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (5, 17, 5);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (6, 32, 6);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (7, 18, 7);
insert into BOOKED_SEAT(id, seat_id, screening_id) values (8, 19, 7);

insert into TICKETS(id, reservation_id, seat_id, type) values (1, 1, 1, 'ADULT');
insert into TICKETS(id, reservation_id, seat_id, type) values (2, 2, 16, 'STUDENT');
insert into TICKETS(id, reservation_id, seat_id, type) values (3, 3, 31, 'CHILD');
insert into TICKETS(id, reservation_id, seat_id, type) values (4, 4, 10, 'STUDENT');
insert into TICKETS(id, reservation_id, seat_id, type) values (5, 5, 20, 'ADULT');
insert into TICKETS(id, reservation_id, seat_id, type) values (6, 6, 33, 'ADULT');
insert into TICKETS(id, reservation_id, seat_id, type) values (7, 7, 28, 'STUDENT');
insert into TICKETS(id, reservation_id, seat_id, type) values (8, 8, 29, 'STUDENT');
