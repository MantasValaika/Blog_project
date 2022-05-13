CREATE TABLE IF NOT EXISTS post (
    post_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    posted_text NCHAR(16000) NOT NULL,
    author_name VARCHAR(255) NOT NULL,
    post_time DATE
);
--
--CREATE TABLE IF NOT EXISTS comment (
--    id INTEGER AUTO_INCREMENT PRIMARY KEY,
--    post_id INTEGER,
--    user_name VARCHAR(255) NOT NULL,
--    comment_text VARCHAR(255) NOT NULL,
--    comment_time DATE NOT NULL,
--    FOREIGN KEY (post_id) REFERENCES post(post_id)
--);