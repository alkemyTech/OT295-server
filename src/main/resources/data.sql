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
('1',CURRENT_TIMESTAMP,'grupoalkemyaceleracion@gmail.com','grupo','alkemy','grupoalkemyaceleracion@gmail.com',FALSE,'grupoalkemyaceleracion@gmail.com'),
('2',CURRENT_TIMESTAMP,'enzo@gmail.com','Enzo','Fernandez','11111111',FALSE,'enzo@gmail.com'),
('3',CURRENT_TIMESTAMP,'leandro@gmail.com','Leandro','Paredes','22222222',FALSE,'leandro@gmail.com'),
('4',CURRENT_TIMESTAMP,'lionel@gmail.com','Lionel','Messi','33333333',FALSE,'lionel@gmail.com'),
('5',CURRENT_TIMESTAMP,'admin@gmail.com','Admin','Admin','44444444',FALSE,'admin@gmail.com'),
('6',CURRENT_TIMESTAMP,'enzoP@gmail.com','Enzo','Perez','55555555',FALSE,'enzoP@gmail.com'),
('7',CURRENT_TIMESTAMP,'nicolas@gmail.com','Nicolas','Otamendi','66666666',FALSE,'nicolas@gmail.com'),
('8',CURRENT_TIMESTAMP,'gonzalo@gmail.com','Gonzalo','Montiel','77777777',FALSE,'gonzalo@gmail.com'),
('9',CURRENT_TIMESTAMP,'rodrigo@gmail.com','Rodrigo','De Paul','88888888',FALSE,'rodrigo@gmail.com'),
('10',CURRENT_TIMESTAMP,'lautaro@gmail.com','Lautaro','Martinez','99999999',FALSE,'lautaro@gmail.com'),
('11',CURRENT_TIMESTAMP,'julian@gmail.com','Julian','Alvarez','123456789',FALSE,'julian@gmail.com'),
('12',CURRENT_TIMESTAMP,'cristina@gmail.com','Cristina','Rodriguez','11111111',FALSE,'cristina@gmail.com'),
('13',CURRENT_TIMESTAMP,'maria@gmail.com','Maria','Rivadavia','22222222',FALSE,'maria@gmail.com'),
('14',CURRENT_TIMESTAMP,'sandra@gmail.com','Sandra','Martinez','33333333',FALSE,'sandra@gmail.com'),
('15',CURRENT_TIMESTAMP,'romina@gmail.com','Romina','Gonzales','44444444',FALSE,'romina@gmail.com'),
('16',CURRENT_TIMESTAMP,'rocio@gmail.com','Rocio','Rosales','55555555',FALSE,'rocio@gmail.com'),
('17',CURRENT_TIMESTAMP,'miriam@gmail.com','Miriam','Suarez','66666666',FALSE,'miriam@gmail.com'),
('18',CURRENT_TIMESTAMP,'laura@gmail.com','Laura','Flores','77777777',FALSE,'laura@gmail.com'),
('19',CURRENT_TIMESTAMP,'franco@gmail.com','Franco','Armani','88888888',FALSE,'franco@gmail.com'),
('20',CURRENT_TIMESTAMP,'angel@gmail.com','Angel','Di Maria','99999999',FALSE,'angel@gmail.com'),
('21',CURRENT_TIMESTAMP,'marta@gmail.com','Marta','Ramirez','123456789',FALSE,'marta@gmail.com');


INSERT INTO app_users_roles(user_entity_id,roles_id) VALUES
('1','1'),
('2','1'),
('3','1'),
('4','1'),
('5','1'),
('6','1'),
('7','1'),
('8','1'),
('9','1'),
('10','1'),
('11','1'),
('12','2'),
('13','2'),
('14','2'),
('15','2'),
('16','2'),
('17','2'),
('18','2'),
('19','2'),
('20','1'),
('21','1');
