INSERT INTO `categorias` (`id`, `detalle`) VALUES (NULL, 'Bebidas'), (NULL, 'Abarrotes'), (NULL, 'Golosinas'), (NULL, 'Galletas'), (NULL, 'Panes');
INSERT INTO `marcas` (`id`, `nombre`, `detalle`) VALUES (NULL, NULL, 'Costa'), (NULL, NULL, 'Coca Cola'), (NULL, NULL, 'Bimbo'), (NULL, NULL, 'Campomar');
INSERT INTO `unidades_medidas` (`id`, `descripcion`) VALUES (NULL, 'Kilo'), (NULL, 'Unidad'), (NULL, 'Six Pack');
INSERT INTO `productos` (`estado`, `id`, `id_cate`, `id_marc`, `id_unid_medi`, `descripcion`, `foto`, `nombre`) VALUES ('1', NULL, '4', '1', '2', 'Galleta sabor Vainilla', '0002.jpg', 'Wafer Costa Vainilla');
INSERT INTO `roles` (`id`, `nombre`) VALUES (NULL, 'ROLE_ADMIN'), (NULL, 'ROLE_USER');
INSERT INTO `usuarios` (`estado`, `id`, `password`, `usuario`) VALUES (true, NULL, '$2a$12$oF2t0lAFRfTu0g.Kc9Iibu1pK/arKQABjRRoS2aNq/K9mUtYt87HG', 'admin'), (true, NULL, '$2a$12$oF2t0lAFRfTu0g.Kc9Iibu1pK/arKQABjRRoS2aNq/K9mUtYt87HG', 'darwin');
INSERT INTO `usuarios_roles` (`rol_id`, `usuario_id`) VALUES ('1', '1'), ('2', '1'), ('2', '2');