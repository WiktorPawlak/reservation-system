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

insert into SEATS(id, room_id, isOccupied) values (11, 1, false);
insert into SEATS(id, room_id, isOccupied) values (12, 1, false);
insert into SEATS(id, room_id, isOccupied) values (13, 1, false);
insert into SEATS(id, room_id, isOccupied) values (14, 1, false);
insert into SEATS(id, room_id, isOccupied) values (15, 1, false);
insert into SEATS(id, room_id, isOccupied) values (21, 1, false);
insert into SEATS(id, room_id, isOccupied) values (22, 1, false);
insert into SEATS(id, room_id, isOccupied) values (23, 1, false);
insert into SEATS(id, room_id, isOccupied) values (24, 1, false);
insert into SEATS(id, room_id, isOccupied) values (25, 1, false);
insert into SEATS(id, room_id, isOccupied) values (31, 1, false);
insert into SEATS(id, room_id, isOccupied) values (32, 1, false);
insert into SEATS(id, room_id, isOccupied) values (33, 1, false);
insert into SEATS(id, room_id, isOccupied) values (34, 1, false);
insert into SEATS(id, room_id, isOccupied) values (35, 1, false);

insert into SEATS(id, room_id, isOccupied) values (11, 2, false);
insert into SEATS(id, room_id, isOccupied) values (12, 2, false);
insert into SEATS(id, room_id, isOccupied) values (13, 2, false);
insert into SEATS(id, room_id, isOccupied) values (14, 2, false);
insert into SEATS(id, room_id, isOccupied) values (15, 2, false);
insert into SEATS(id, room_id, isOccupied) values (21, 2, false);
insert into SEATS(id, room_id, isOccupied) values (22, 2, false);
insert into SEATS(id, room_id, isOccupied) values (23, 2, false);
insert into SEATS(id, room_id, isOccupied) values (24, 2, false);
insert into SEATS(id, room_id, isOccupied) values (25, 2, false);
insert into SEATS(id, room_id, isOccupied) values (31, 2, false);
insert into SEATS(id, room_id, isOccupied) values (32, 2, false);
insert into SEATS(id, room_id, isOccupied) values (33, 2, false);
insert into SEATS(id, room_id, isOccupied) values (34, 2, false);
insert into SEATS(id, room_id, isOccupied) values (35, 2, false);

insert into SEATS(id, room_id, isOccupied) values (11, 3, false);
insert into SEATS(id, room_id, isOccupied) values (12, 3, false);
insert into SEATS(id, room_id, isOccupied) values (13, 3, false);
insert into SEATS(id, room_id, isOccupied) values (14, 3, false);
insert into SEATS(id, room_id, isOccupied) values (15, 3, false);
insert into SEATS(id, room_id, isOccupied) values (21, 3, false);
insert into SEATS(id, room_id, isOccupied) values (22, 3, false);
insert into SEATS(id, room_id, isOccupied) values (23, 3, false);
insert into SEATS(id, room_id, isOccupied) values (24, 3, false);
insert into SEATS(id, room_id, isOccupied) values (25, 3, false);
insert into SEATS(id, room_id, isOccupied) values (31, 3, false);
insert into SEATS(id, room_id, isOccupied) values (32, 3, false);
insert into SEATS(id, room_id, isOccupied) values (33, 3, false);
insert into SEATS(id, room_id, isOccupied) values (34, 3, false);
insert into SEATS(id, room_id, isOccupied) values (35, 3, false);
