INSERT INTO activities(id,content,create_timestamp,image_url,name,soft_delete) VALUES
(UUID(),'content: 1',CURRENT_TIMESTAMP,'image_url: 1','name: 1',false),
(UUID(),'content: 2',CURRENT_TIMESTAMP,'image_url: 2','name: 2',false),
(UUID(),'content: 3',CURRENT_TIMESTAMP,'image_url: 3','name: 3',false),
(UUID(),'content: 4',CURRENT_TIMESTAMP,'image_url: 4','name: 4',false),
(UUID(),'content: 5',CURRENT_TIMESTAMP,'image_url: 5','name: 5',false),
(UUID(),'content: 6',CURRENT_TIMESTAMP,'image_url: 6','name: 6',false),
(UUID(),'content: 7',CURRENT_TIMESTAMP,'image_url: 7','name: 7',false);



INSERT INTO app_roles(id,create_timestamp,description,name) VALUES
(UUID(),CURRENT_TIMESTAMP,'ROL ADMINISTRADOR','ROLE_ADMIN'),
(UUID(),CURRENT_TIMESTAMP,'ROL REGULAR/USUARIO','ROLE_USER');


--ENCRYPTION
--grupoalkemyaceleracion@gmail.com - $2a$10$C.SziKEGeHHu/QjGf3SvYO.40/kV6Ohu47WQuh8m7spYxXo5D5wR.
--11111111 -    $2a$10$QVKqM5Re6thixpdR0EpAI.djGyudBng1axJsHzlJIM0.mqpEW1Kvq
--22222222 -    $2a$10$FiExJtasG6pwRvYKNIFQf.XHOq4GsUYEQjkdOdOCO5OMnRk.SOAPG
--33333333 -    $2a$10$052ZAsmpcrmVI8xh3jfAaeDwTOapqgI3W6PonV34jtU0SixhPgzMy
--44444444 -    $2a$10$tAMoqJCi2unLUbDKaFBdReQgV3Dia.hYjkRN3V8NKbXAxfYvYBAF6
--55555555 -    $2a$10$PQGy3JcdlXS.0TRkosqD0OMaw0aKy4skCE9L8p6JdSKGGArEnmkym
--66666666 -    $2a$10$NJNanOOAhLj/LQdfK60X.uw.rOnCgffhBXCPj72H/28s325bcHrPG
--77777777 -    $2a$10$42O2cpPsTmdSBwXmc6nEDukZz8IGbDDI3a3YnmvfI3JsidnmSC0VC
--88888888 -    $2a$10$lxzIWFbT3LKZ6bxSjSRMDO85pu1U7RKaQpVhyFGGXWznq0KecbuaW
--99999999 -    $2a$10$dM.oyqwKH82GSzN.S8Buk.H9T0YQ.4gq2pPGU8Z0inNt48VLGf/Nq
--123456789 -   $2a$10$CGsmuiuTaGlNSCKeo9Y1g.Gv13vQazR8/AKUSuHl9BQktwfTBL1Om

INSERT INTO app_users(id,create_timestamp,email,first_name,last_name,password,soft_delete,username) VALUES
(UUID(),CURRENT_TIMESTAMP,'grupoalkemyaceleracion@gmail.com','grupo','alkemy','$2a$10$C.SziKEGeHHu/QjGf3SvYO.40/kV6Ohu47WQuh8m7spYxXo5D5wR.',FALSE,'grupoalkemyaceleracion@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'enzo@gmail.com','Enzo','Fernandez','$2a$10$QVKqM5Re6thixpdR0EpAI.djGyudBng1axJsHzlJIM0.mqpEW1Kvq',FALSE,'enzo@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'leandro@gmail.com','Leandro','Paredes','$2a$10$FiExJtasG6pwRvYKNIFQf.XHOq4GsUYEQjkdOdOCO5OMnRk.SOAPG',FALSE,'leandro@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'lionel@gmail.com','Lionel','Messi','$2a$10$052ZAsmpcrmVI8xh3jfAaeDwTOapqgI3W6PonV34jtU0SixhPgzMy',FALSE,'lionel@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'admin@gmail.com','Admin','Admin','$2a$10$tAMoqJCi2unLUbDKaFBdReQgV3Dia.hYjkRN3V8NKbXAxfYvYBAF6',FALSE,'admin@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'enzoP@gmail.com','Enzo','Perez','$2a$10$PQGy3JcdlXS.0TRkosqD0OMaw0aKy4skCE9L8p6JdSKGGArEnmkym',FALSE,'enzoP@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'nicolas@gmail.com','Nicolas','Otamendi','$2a$10$NJNanOOAhLj/LQdfK60X.uw.rOnCgffhBXCPj72H/28s325bcHrPG',FALSE,'nicolas@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'gonzalo@gmail.com','Gonzalo','Montiel','$2a$10$42O2cpPsTmdSBwXmc6nEDukZz8IGbDDI3a3YnmvfI3JsidnmSC0VC',FALSE,'gonzalo@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'rodrigo@gmail.com','Rodrigo','De Paul','$2a$10$lxzIWFbT3LKZ6bxSjSRMDO85pu1U7RKaQpVhyFGGXWznq0KecbuaW',FALSE,'rodrigo@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'lautaro@gmail.com','Lautaro','Martinez','$2a$10$dM.oyqwKH82GSzN.S8Buk.H9T0YQ.4gq2pPGU8Z0inNt48VLGf/Nq',FALSE,'lautaro@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'julian@gmail.com','Julian','Alvarez','$2a$10$CGsmuiuTaGlNSCKeo9Y1g.Gv13vQazR8/AKUSuHl9BQktwfTBL1Om',FALSE,'julian@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'cristina@gmail.com','Cristina','Rodriguez','$2a$10$QVKqM5Re6thixpdR0EpAI.djGyudBng1axJsHzlJIM0.mqpEW1Kvq',FALSE,'cristina@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'maria@gmail.com','Maria','Rivadavia','$2a$10$FiExJtasG6pwRvYKNIFQf.XHOq4GsUYEQjkdOdOCO5OMnRk.SOAPG',FALSE,'maria@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'sandra@gmail.com','Sandra','Martinez','$2a$10$052ZAsmpcrmVI8xh3jfAaeDwTOapqgI3W6PonV34jtU0SixhPgzMy',FALSE,'sandra@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'romina@gmail.com','Romina','Gonzales','$2a$10$tAMoqJCi2unLUbDKaFBdReQgV3Dia.hYjkRN3V8NKbXAxfYvYBAF6',FALSE,'romina@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'rocio@gmail.com','Rocio','Rosales','$2a$10$PQGy3JcdlXS.0TRkosqD0OMaw0aKy4skCE9L8p6JdSKGGArEnmkym',FALSE,'rocio@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'miriam@gmail.com','Miriam','Suarez','$2a$10$NJNanOOAhLj/LQdfK60X.uw.rOnCgffhBXCPj72H/28s325bcHrPG',FALSE,'miriam@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'laura@gmail.com','Laura','Flores','$2a$10$42O2cpPsTmdSBwXmc6nEDukZz8IGbDDI3a3YnmvfI3JsidnmSC0VC',FALSE,'laura@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'franco@gmail.com','Franco','Armani','$2a$10$lxzIWFbT3LKZ6bxSjSRMDO85pu1U7RKaQpVhyFGGXWznq0KecbuaW',FALSE,'franco@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'angel@gmail.com','Angel','Di Maria','$2a$10$dM.oyqwKH82GSzN.S8Buk.H9T0YQ.4gq2pPGU8Z0inNt48VLGf/Nq',FALSE,'angel@gmail.com'),
(UUID(),CURRENT_TIMESTAMP,'marta@gmail.com','Marta','Ramirez','$2a$10$CGsmuiuTaGlNSCKeo9Y1g.Gv13vQazR8/AKUSuHl9BQktwfTBL1Om',FALSE,'marta@gmail.com');


INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'grupoalkemyaceleracion@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'enzo@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'leandro@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'lionel@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'admin@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'enzoP@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'nicolas@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'gonzalo@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'rodrigo@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'lautaro@gmail.com' AND app_roles.name = 'ROLE_ADMIN';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'julian@gmail.com' AND app_roles.name = 'ROLE_ADMIN';

INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'cristina@gmail.com' AND app_roles.name = 'ROLE_USER';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'maria@gmail.com' AND app_roles.name = 'ROLE_USER';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'sandra@gmail.com' AND app_roles.name = 'ROLE_USER';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'romina@gmail.com' AND app_roles.name = 'ROLE_USER';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'rocio@gmail.com' AND app_roles.name = 'ROLE_USER';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'miriam@gmail.com' AND app_roles.name = 'ROLE_USER';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'laura@gmail.com' AND app_roles.name = 'ROLE_USER';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'franco@gmail.com' AND app_roles.name = 'ROLE_USER';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'angel@gmail.com' AND app_roles.name = 'ROLE_USER';
INSERT INTO app_users_roles SELECT app_users.id, app_roles.id FROM app_users INNER JOIN app_roles ON app_users.email = 'marta@gmail.com' AND app_roles.name = 'ROLE_USER';


INSERT INTO categories(id,create_timestamp,description,image,name,soft_delete) VALUES
('00000000-0000-0000-0000-000000000001',CURRENT_TIMESTAMP,'This is the description for CATEGORY 1','image CATEGORY 1','CATEGORY 1',FALSE),
('00000000-0000-0000-0000-000000000002',CURRENT_TIMESTAMP,'This is the description for CATEGORY 2','image CATEGORY 2','CATEGORY 2',FALSE),
('00000000-0000-0000-0000-000000000003',CURRENT_TIMESTAMP,'This is the description for CATEGORY 3','image CATEGORY 3','CATEGORY 3',FALSE);


INSERT INTO news(id,content,create_timestamp,image_url,name,soft_delete,category_id) VALUES
('00000000-0000-0000-0000-000000000001','This is the content for NEW 1',CURRENT_TIMESTAMP,'image NEW 1','NEW 1',FALSE,'00000000-0000-0000-0000-000000000001'),
('00000000-0000-0000-0000-000000000002','This is the content for NEW 2',CURRENT_TIMESTAMP,'image NEW 2','NEW 2',FALSE,'00000000-0000-0000-0000-000000000002'),
('00000000-0000-0000-0000-000000000003','This is the content for NEW 3',CURRENT_TIMESTAMP,'image NEW 3','NEW 3',FALSE,'00000000-0000-0000-0000-000000000003');

INSERT INTO comments(id,body,create_timestamp,news_id,user_id) VALUES
('00000000-0000-0000-0000-000000000001','This is the body for COMMENT 1',CURRENT_TIMESTAMP,'00000000-0000-0000-0000-000000000001',(SELECT id FROM app_users WHERE email = 'grupoalkemyaceleracion@gmail.com')),
('00000000-0000-0000-0000-000000000002','This is the body for COMMENT 2',CURRENT_TIMESTAMP,'00000000-0000-0000-0000-000000000002',(SELECT id FROM app_users WHERE email = 'maria@gmail.com')),
('00000000-0000-0000-0000-000000000003','This is the body for COMMENT 3',CURRENT_TIMESTAMP,'00000000-0000-0000-0000-000000000003',(SELECT id FROM app_users WHERE email = 'sandra@gmail.com'));
