INSERT INTO chat.users (login, password)
VALUES ('Bob', '111');
INSERT INTO chat.users (login, password)
VALUES ('Billy', '222');
INSERT INTO chat.users (login, password)
VALUES ('Logan', '333');
INSERT INTO chat.users (login, password)
VALUES ('Gachi', '444');
INSERT INTO chat.users (login, password)
VALUES ('Andrew', '555');

INSERT INTO chat.rooms (name, owner)
VALUES ('Random', 1);
INSERT INTO chat.rooms (name, owner)
VALUES ('General', 2);
INSERT INTO chat.rooms (name, owner)
VALUES ('dungeon', 3);
INSERT INTO chat.rooms (name, owner)
VALUES ('Lols', 4);
INSERT INTO chat.rooms (name, owner)
VALUES ('NMA', 5);

INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (1, 1, 'kek', '1970-01-01 00:00:01');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (2, 3, 'lmao', '1970-01-01 00:00:01');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (5, 3, '300 bucks', '1970-01-01 00:00:02');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (4, 4, 'RIPPERONI', '1970-01-01 00:00:04');
INSERT INTO chat.messages (author, room, text, timestamp)
VALUES (5, 5, 'NMA', '1970-01-01 00:00:05');