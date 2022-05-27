INSERT INTO roles(role) VALUES ('USER');
INSERT INTO roles(role) VALUES ('ADMIN');

INSERT INTO users(name, last_name, email, phone_number, username, password) VALUES ('Vytas', 'Vytauskas', 'vytukas@yahoo.com', '+37064294226', 'administrator', '$2a$12$h7IrjjBWq1C1NWOD2SdSNeyZyAQpIGDl/rjNmP0dV3M95dVvP/VhO');
INSERT INTO users(name, last_name, email, phone_number, username, password) VALUES ('Saulius', 'Sauliunas', 'sauliukas@gmail.com', '+37068524220', 'saulenas', '$2a$12$h7IrjjBWq1C1NWOD2SdSNeyZyAQpIGDl/rjNmP0dV3M95dVvP/VhO');

INSERT INTO users_roles(user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles(user_id, roles_id) VALUES (1, 2);

INSERT INTO users_roles(user_id, roles_id) VALUES(2, 1);

INSERT INTO post(title, posted_text, post_time, user_id) VALUES ('Sekmadienis', 'Praėjusį savaitgalį The Sunday Times publikaie yra nemaža Mold M gali griebtis iiii.', '2019-01-21T05:47:08.644', 1);
INSERT INTO post(title, posted_text, post_time, user_id) VALUES ('Vasara', 'Praėjusį savaitgalį The Sunday Times publikaie yra nemaža vrkhfbkdjgfsjkgbhxbgvjlk vgvsg.kjnvgvhtrd dvtr drt bhdvghdbt bfdjh dntbyhrtbth riebtis iiii.', '2022-01-21T05:47:08.644', 2);
INSERT INTO post(title, posted_text, post_time, user_id) VALUES ('Žemaite', 'Pra svrbydstrxghThe Sunday Times publikaie yra nemaža Mold M gali griebtis iiii.', '2022-03-21T08:47:08.644', 2);