/* ----------------------- Database and users ---------------------------------------------------- */
/* ----------------------- DROP EXISTING / DO NOT USE IN LIVE PRODUCTION SITE -------------------- */
drop keyspace if exists securityDemo;
CREATE KEYSPACE securityDemo WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
use securityDemo;

/* ----------------------- Tables and test data -------------------------------------------------- */
drop table if exists users;

CREATE TABLE users (
    email varchar primary key,
    password varchar,
    enabled boolean,
);

INSERT INTO users(email, password, enabled)
VALUES('test@johntestusers.org',
  '5950fdef2ec5e081d21b23e61f14340c006c9905da7038c109f9364deb3c6442121965af32ecfaf4', true);









/*
    Ignore below here
    -------------------------------------------------------------------------------------------------------------
*/

/*
create table UserConnection (userId varchar(255) not null,
                           providerId varchar(255) not null,
                           providerUserId varchar(255),
                           rank int not null,
                           displayName varchar(255),
                           profileUrl varchar(512),
                           imageUrl varchar(512),
                           accessToken varchar(255) not null,
                           secret varchar(255),
                           refreshToken varchar(255),
                           expireTime bigint,
primary key (userId, providerId, providerUserId))
ENGINE=InnoDB DEFAULT CHARSET=utf8;
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

CREATE TABLE users (
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(80) NULL,
  userName VARCHAR(45) NOT NULL,
  password VARCHAR(90) NOT NULL,
  enabled tinyint(1) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE userRoles (
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  userId INT(10) UNSIGNED NOT NULL,
  authority VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  KEY FK_userRoles (userId),
  CONSTRAINT FK_userRoles FOREIGN KEY (userId) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tokens (
  token VARCHAR(40),
  userName VARCHAR(45) NOT NULL,
  tokenType INT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

*/

/* Password is "6kenpBYxZ5#"; */
/*
INSERT INTO users(userName, password, name, enabled)
VALUES('test@johntestusers.org', 
  '5950fdef2ec5e081d21b23e61f14340c006c9905da7038c109f9364deb3c6442121965af32ecfaf4','Just Another Test User', true);
INSERT INTO userRoles (userId, authority) VALUES (1, 'admin');
commit;
*/