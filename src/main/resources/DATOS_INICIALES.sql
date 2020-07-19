INSERT INTO public.estado(
	id, nombre)
	VALUES (1, 'ACTIVO');
INSERT INTO public.estado(
	id, nombre)
	VALUES (2, 'INACTIVO');

INSERT INTO public.perfil(
	id, nombre, id_estado)
	VALUES (1, 'ADMINISTRADOR', 1);
INSERT INTO public.perfil(
	id, nombre, id_estado)
	VALUES (2, 'USUARIO', 1);


INSERT INTO public.usuario(
	id, email, nombre, password, id_estado, id_perfil)
	VALUES (1,'felipe.monti@gmail.com', 'Felipe Monti', '123', 1, 1);


commit;