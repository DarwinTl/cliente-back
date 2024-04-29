INSERT INTO `ttcate` (`id_cate`, `de_cate`) VALUES (NULL, 'Bebidas'), (NULL, 'Aseo Personal'), (NULL, 'Menestras'), (NULL, 'Lácteos');
INSERT INTO `ttunid_medi` (`id_unid_medi`, `de_unid_medi`) VALUES (NULL, 'Kilo'), (NULL, 'Gramo'), (NULL, 'Six Pack'), (NULL, 'Docena');
INSERT INTO `ttmarc` (`id_marc`, `de_marc`, `no_marc`) VALUES (NULL, 'Colgate', ''), (NULL, 'Marcas de todo tipo', 'Colgate');
INSERT INTO `roles` (`id`, `nombre`) VALUES (NULL, 'ROLE_ADMIN'), (NULL, 'ROLE_USER');
INSERT INTO `usuarios` (`estado`, `id`, `password`, `usuario`) VALUES (b'1', NULL, '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 'admin'), (b'1', NULL, '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS', 'darwin');
INSERT INTO `usuarios_roles` (`rol_id`, `usuario_id`) VALUES ('1', '1');
INSERT INTO `usuarios_roles` (`rol_id`, `usuario_id`) VALUES ('2', '1');
INSERT INTO `usuarios_roles` (`rol_id`, `usuario_id`) VALUES ('2', '2');