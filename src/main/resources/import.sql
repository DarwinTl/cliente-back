INSERT INTO `ttcate` (`id_cate`, `de_cate`) VALUES (NULL, 'Bebidas'), (NULL, 'Aseo Personal'), (NULL, 'Menestras'), (NULL, 'Lácteos');
INSERT INTO `ttunid_medi` (`id_unid_medi`, `de_unid_medi`) VALUES (NULL, 'Kilo'), (NULL, 'Gramo'), (NULL, 'Six Pack'), (NULL, 'Docena');
INSERT INTO `ttmarc` (`id_marc`, `de_marc`, `no_marc`) VALUES (NULL, 'Colgate', ''), (NULL, 'Marcas de todo tipo', 'Colgate');

INSERT INTO `tmprod` (`id_cate`, `id_esta`, `id_marc`, `id_prod`, `id_unid_medi`, `de_prod`, `de_ruta_imag`, `no_prod`) VALUES ('5', '1', '1', NULL, '4', 'Galleta soda', 'sdads', 'Galleta soda V');
INSERT INTO `tmprod` (`id_cate`, `id_esta`, `id_marc`, `id_prod`, `id_unid_medi`, `de_prod`, `de_ruta_imag`, `no_prod`) VALUES ('2', '1', '2', NULL, '3', 'Caja pasta dental', 'ewew', 'Pasta dental fluor');