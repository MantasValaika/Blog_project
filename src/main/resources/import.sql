INSERT INTO post(title, posted_text, author_name, post_time) VALUES ('Bla bla', 'Praėjusį savaitgalį The Sunday Times publikaie yra nemaža Mold M gali griebtis iiii.', 'Mantello', '2019-01-21T05:47:08.644');

INSERT INTO roles(role) VALUES ('USER');
INSERT INTO roles(role) VALUES ('ADMIN');

INSERT INTO users(name, last_name, email, username, password) VALUES ('Vytas', 'Vytauskas', 'vytukas@yahoo.com', 'vycka', '$2a$12$h7IrjjBWq1C1NWOD2SdSNeyZyAQpIGDl/rjNmP0dV3M95dVvP/VhO');
INSERT INTO users(name, last_name, email, username, password) VALUES ('Saulius', 'Sauliunas', 'sauliukas@gmail.com', 'saulenas', '$2a$12$h7IrjjBWq1C1NWOD2SdSNeyZyAQpIGDl/rjNmP0dV3M95dVvP/VhO');

INSERT INTO users_roles(user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles(user_id, roles_id) VALUES (1, 2);

INSERT INTO users_roles(user_id, roles_id) VALUES(2, 1);