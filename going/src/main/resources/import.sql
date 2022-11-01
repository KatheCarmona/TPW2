INSERT INTO `goingok`.`usuario` (`id`, `enabled`,`pass`, `username`) VALUES ('1', b'1'," ", 'ka');
INSERT INTO `goingok`.`usuario` (`id`, `enabled`,`pass`, `username`) VALUES ('2', b'1'," ", 'kc');

INSERT INTO `goingok`.`user_role` (`id`, `rol`, `user_id`) VALUES ('1', 'ROLE_1', '1');
INSERT INTO `goingok`.`user_role` (`id`, `rol`, `user_id`) VALUES ('2', 'ROLE_2', '2');


UPDATE `goingok`.`usuario` SET `pass` = '$2a$10$yydIJELlb5wwwzAD6qOB1OWK1efd0OeDqpg53HOGkcs0kB1TDpXZa' WHERE (`id` = '1');
UPDATE `goingok`.`usuario` SET `pass` = '$2a$10$yydIJELlb5wwwzAD6qOB1OWK1efd0OeDqpg53HOGkcs0kB1TDpXZa' WHERE (`id` = '2');

INSERT INTO `goingok`.`avatar` (`id`, `imagen`) VALUES ('1', 'a.png');
INSERT INTO `goingok`.`avatar` (`id`, `imagen`) VALUES ('2', 'b.png');

INSERT INTO `goingok`.`persona` (`id`, `edad`, `email`, `nombre`, `avatar_id`, `usuario_id`) VALUES ('1', '27', 'ka@kmail.com', 'Kathe', '1', '1');
INSERT INTO `goingok`.`persona` (`id`, `edad`, `email`, `nombre`, `avatar_id`, `usuario_id`) VALUES ('2', '20', 'kc@kc.com', 'Catalina', '2', '2');


INSERT INTO `goingok`.`locacion` (`id`, `descripcion`, `direccion`, `nombre`, `valoracion`) VALUES ('1', 'Lugar moderno con platos y cocteles internacionales, y una entrada con temática del metro de Nueva York.', 'Arévalo 2030, Buenos Aires C1414 Argentina', 'Uptown & The Bronx', '4');
INSERT INTO `goingok`.`locacion` (`id`, `descripcion`, `direccion`, `nombre`, `valoracion`) VALUES ('2', 'Tomar un café con la compañia de gatitos es todo lo que está bien.', 'Jean Jaures 687, C1215 CABA', 'Cat cafe Buenos Aires', '4');
INSERT INTO `goingok`.`locacion` (`id`, `descripcion`, `direccion`, `nombre`, `valoracion`) VALUES ('3', 'Restaurante japones', 'Honduras 5902, C1414 CABA', 'Emperador Meiji', '3');
INSERT INTO `goingok`.`locacion` (`id`, `descripcion`, `direccion`, `nombre`, `valoracion`) VALUES ('4', 'Restaurante submarino recubierto de cristal acrílico situado 5 metros bajo el nivel del mar .', 'Conrad Rangali Island 20077, Maldivas', 'Ithaa', '5');
INSERT INTO `goingok`.`locacion` (`id`, `descripcion`, `direccion`, `nombre`, `valoracion`) VALUES ('5', 'Restaurantes con temática de baños, con tres sucursales en Taiwán.', '111, Taiwán, Taipei City, Shilin District, Wenlin Rd', 'Modern Toilet', '2');
INSERT INTO `goingok`.`locacion` (`id`, `descripcion`, `direccion`, `nombre`, `valoracion`) VALUES ('6', 'Osten es un punto de encuentro donde se vive una experiencia que abarca todos los sentidos.', 'Juana Manso 1890, C1107 CABA', 'OSTEN', '5');


INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('1', 'up0.png', '1');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('2', 'up1.png', '1');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('3', 'up2.png', '1');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('4', 'cat1.png', '2');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('5', 'cat2.png', '2');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('6', 'cat3.png', '2');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('7', 'emp1.png', '3');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('8', 'emp2.png', '3');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('9', 'emp3.png', '3');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('10', 'ita1.png', '4');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('11', 'ita2.png', '4');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('12', 'ita3.png', '4');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('13', 'mt1.png', '5');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('14', 'mt2.png', '5');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('15', 'mt3.png', '5');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('16', 'os1.png', '6');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('17', 'os2.png', '6');
INSERT INTO `goingok`.`fotos` (`id`, `imagen`, `locacion_id`) VALUES ('18', 'os3.png', '6');


INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('1', 'Fuimos a cenar. El lugar es original por el estilo pero los valores son elevados para lo que ofrecen. Carta muuuy acotada.', '1');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('2', 'Es lejos mi bar favorito, la ambientación es excelente y te hace sentir por un rato que estás en la ciudad que nunca duerme.', '1');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('3', 'Fuimos el sábado con reserva. La atención es muy buena, los mozos súper atentos, los tragos ricos.', '1');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('4', 'Pase mi cumpleaños numero 16 en este lugar y fue el mejor de mi vida al pasarlo con gatitos.', '2');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('5', 'Lindo lugar y lindas personas. Es ideal para estar un rato con gatitos y relajarse', '2');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('6', 'Linda experiencia, destaco la amabilidad del equipo. Los protagonistas te enamoran. ¡Volveremos pronto!', '2');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('7', 'La comida excelente, la carne muy fresca y con mucho sabor. Los tragos también son un 10 y los chicos te recomiendan según lo que ordenes.', '3');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('8', 'Fui a comer el menú ejecutivo, pensé que iba a bajar un poco la calidad y cantidad de los platos pero no fue así.', '3');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('9', 'Tenía una reserva y cuando llegué (puntual) no había mesa disponible para mí y tuve que esperar 30 minutos.', '3');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('10', 'Degustar una comida a una profundidad de 5 metros sobre el nivel del mar en los arrecifes de coral.', '4');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('11', 'Ubicación única con comida encantadora. el servicio es excepcional', '4');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('12', 'Esta fue una experiencia única, que todos deben probar.', '4');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('13', 'Fuimos porque lo vimos en las guías turísticas, pedimos un helado, nos pidieron que tenía que ser consumición mínima cada persona', '5');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('14', 'Te sientas en un inodoro, la comida se sirve en mini inodoros y algunos incluso parecen caca.', '5');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('15', ' Llevan el tema hasta las servilletas de papel higiénico. ', '5');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('16', 'Buena música, aunque un poco fuerte, ricos platos y muy buena atención.', '6');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('17', 'Arquitectura y diseño: excelente.', '6');
INSERT INTO `goingok`.`comentario` (`id`, `descripcion`, `locacion_id`) VALUES ('18', 'Lindo ambiente, rica comida y tragos. Pero los mozos son demasiados atentos, hasta se hacía incómodo de a ratos', '6');




