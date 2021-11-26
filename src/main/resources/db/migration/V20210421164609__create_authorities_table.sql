CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    PRIMARY KEY (username, authority)
) DEFAULT CHARSET = utf8mb4
  COLLATE utf8mb4_bin;