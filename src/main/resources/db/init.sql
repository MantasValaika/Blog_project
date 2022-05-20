CREATE TABLE IF NOT EXISTS post (
    post_id INTEGER AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    posted_text NCHAR(16000),
    author_name VARCHAR(255),
    post_time TIMESTAMP
);

CREATE TABLE IF NOT EXISTS comment (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(255),
    comment_text VARCHAR(255),
    comment_time TIMESTAMP,
    FOREIGN KEY (id) REFERENCES post(post_id)
);