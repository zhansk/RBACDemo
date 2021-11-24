-- init users
INSERT INTO users (id, username,password)
VALUES (1, 'zhansikai',123);

-- init role
INSERT INTO role (id, role)
VALUES (1, 'admin');

-- init role
INSERT INTO permission (id, permission)
VALUES (1, 'read'),(2,'write'),(3,'update'),(4,'delete');

INSERT INTO user_role (id,uid,rid)
values (1,1,1);

INSERT INTO role_permission (id,rid,pid)
values (1,1,1),(2,1,2),(3,1,3),(4,1,4);
