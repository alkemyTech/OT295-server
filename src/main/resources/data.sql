INSERT INTO activities(id,content,create_timestamp,image_url,name,soft_delete) VALUES
('1','content: 1',CURRENT_TIMESTAMP,'image_url: 1','name: 1',false),
('2','content: 2',CURRENT_TIMESTAMP,'image_url: 2','name: 2',false),
('3','content: 3',CURRENT_TIMESTAMP,'image_url: 3','name: 3',false),
('4','content: 4',CURRENT_TIMESTAMP,'image_url: 4','name: 4',false),
('5','content: 5',CURRENT_TIMESTAMP,'image_url: 5','name: 5',false),
('6','content: 6',CURRENT_TIMESTAMP,'image_url: 6','name: 6',false),
('7','content: 7',CURRENT_TIMESTAMP,'image_url: 7','name: 7',false);



INSERT INTO app_roles(id,create_timestamp,description,name) VALUES
('1',CURRENT_TIMESTAMP,'ROL ADMINISTRADOR','ROLE_ADMIN'),
('2',CURRENT_TIMESTAMP,'ROL REGULAR/USUARIO','ROLE_USER');


INSERT INTO app_users(id,create_timestamp,email,first_name,last_name,password,soft_delete,username) VALUES
('1',CURRENT_TIMESTAMP,'grupoalkemyaceleracion@gmail.com','grupo','alkemy','grupoalkemyaceleracion@gmail.com',FALSE,'grupoalkemyaceleracion@gmail.com');


INSERT INTO app_users_roles(user_entity_id,roles_id) VALUES
('1','1');