INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (1, 'Tanner', 'Ferrell', '44685362-7', 'Duis.a@estac.ca',
        'mattis velit justo nec ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate, lacus. Cras interdum. Nunc sollicitudin commodo ipsum.');
INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (2, 'Oren', 'Jacobs', '32120645-K', 'semper@augueut.edu',
        'Donec elementum, lorem ut aliquam iaculis, lacus pede sagittis augue, eu tempor erat neque non quam. Pellentesque habitant');
INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (3, 'Serena', 'Franco', '39809883-8', 'ultricies.dignissim@egestas.co.uk',
        'nisl sem, consequat nec, mollis vitae, posuere at, velit. Cras lorem lorem, luctus ut, pellentesque eget, dictum placerat, augue. Sed');
INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (4, 'Marcia', 'Contreras', '39531090-9', 'sed@augueacipsum.com',
        'Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque.');
INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (5, 'Teegan', 'Newton', '9621505-3', 'vulputate.mauris@diamvelarcu.org',
        'arcu ac orci. Ut semper pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in faucibus orci luctus et');
INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (6, 'Cynthia', 'Wade', '19459442-9', 'Sed.et.libero@mitemporlorem.org',
        'sed consequat auctor, nunc nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc interdum feugiat. Sed nec metus facilisis');
INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (7, 'Ivy', 'Dunn', '22259297-6', 'gravida@massaSuspendisseeleifend.com',
        'vitae purus gravida sagittis. Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim');
INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (8, 'Zoe', 'Douglas', '11451206-0', 'Nullam@nulla.ca',
        'et magnis dis parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu');
INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (9, 'Walter', 'Rich', '40142458-K', 'sit.amet.risus@massa.net',
        'pede ac urna. Ut tincidunt vehicula risus. Nulla eget metus eu erat semper rutrum. Fusce dolor quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede. Nunc');
INSERT INTO postulantes (idPostulante, nombre, apellido, rut, email, resumen)
VALUES (10, 'Camilla', 'Albert', '28866327-0', 'sagittis.Nullam.vitae@quisturpisvitae.com',
        'at pretium aliquet, metus urna convallis erat, eget tincidunt dui augue eu tellus. Phasellus elit pede, malesuada vel, venenatis vel, faucibus id, libero. Donec consectetuer mauris id sapien. Cras dolor dolor, tempus non, lacinia');

INSERT INTO reclutadores (idReclutador, nombreFantasia, razonSocial, rut, email)
VALUES (1, 'Non Vestibulum LLP', 'Non Dui Nec Foundation', '17221249-2', 'Lorem.ipsum@utmi.co.uk');
INSERT INTO reclutadores (idReclutador, nombreFantasia, razonSocial, rut, email)
VALUES (2, 'Metus In Limited', 'Rhoncus Inc.', '20687799-5', 'eu@senectus.ca');
INSERT INTO reclutadores (idReclutador, nombreFantasia, razonSocial, rut, email)
VALUES (3, 'Risus In Institute', 'Vel Corp.', '43188905-6', 'sed.dui.Fusce@duinecurna.edu');
INSERT INTO reclutadores (idReclutador, nombreFantasia, razonSocial, rut, email)
VALUES (4, 'Diam Sed Corp.', 'Quisque LLP', '7773197-0', 'sodales.purus@ametloremsemper.com');
INSERT INTO reclutadores (idReclutador, nombreFantasia, razonSocial, rut, email)
VALUES (5, 'Porttitor Corp.', 'Vel Venenatis Vel Ltd', '48140321-9', 'metus.eu@acorciUt.com');

INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (1, 1, TO_DATE('05/08/2020', 'DD/MM/YYYY'), 'in magna. Phasellus dolor elit',
        'sem molestie sodales. Mauris blandit enim consequat purus. Maecenas libero est, congue a, aliquet', 9967.16);
INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (2, 2, TO_DATE('22/07/2020', 'DD/MM/YYYY'), 'neque pellentesque massa lobortis ultrices',
        'parturient montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod', 4650.67);
INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (3, 3, TO_DATE('14/08/2020', 'DD/MM/YYYY'), 'arcu. Sed eu nibh vulputate mauris',
        'lectus. Nullam suscipit, est ac facilisis facilisis, magna tellus faucibus leo, in lobortis tellus justo sit amet nulla. Donec',
        7067.09);
INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (4, 4, TO_DATE('15/08/2020', 'DD/MM/YYYY'), 'mauris sit amet lorem semper auctor.',
        'enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed',
        9156.64);
INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (5, 5, TO_DATE('21/07/2020', 'DD/MM/YYYY'), 'mollis dui, in sodales elit erat',
        'arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec, eleifend',
        8422.61);
INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (6, 1, TO_DATE('19/08/2020', 'DD/MM/YYYY'), 'Suspendisse ac metus vitae velit egestas',
        'eu turpis. Nulla aliquet. Proin velit. Sed malesuada augue ut lacus. Nulla tincidunt,', 8932.68);
INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (7, 2, TO_DATE('05/08/2020', 'DD/MM/YYYY'), 'accumsan laoreet ipsum. Curabitur consequat',
        'tincidunt aliquam arcu. Aliquam ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget metus. In nec orci. Donec nibh.',
        4402.33);
INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (8, 3, TO_DATE('11/08/2020', 'DD/MM/YYYY'), 'feugiat tellus lorem eu metus. In',
        'Nulla dignissim. Maecenas ornare egestas ligula. Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam',
        8347.08);
INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (9, 4, TO_DATE('23/07/2020', 'DD/MM/YYYY'), 'orci lobortis augue scelerisque mollis. Phasellus',
        'Fusce diam nunc, ullamcorper eu, euismod ac, fermentum vel, mauris. Integer sem elit, pharetra', 1194.04);
INSERT INTO ofertas (idOferta, idReclutador, fecha, titulo, descripcion, salario)
VALUES (10, 5, TO_DATE('01/08/2020', 'DD/MM/YYYY'), 'Sed pharetra, felis eget varius ultrices,',
        'erat, eget tincidunt dui augue eu tellus. Phasellus elit pede, malesuada vel,', 1057.59);

INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (1, 1, TO_DATE('24/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (2, 2, TO_DATE('20/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (3, 3, TO_DATE('22/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (4, 4, TO_DATE('25/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (5, 5, TO_DATE('25/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (6, 6, TO_DATE('19/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (7, 7, TO_DATE('20/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (8, 8, TO_DATE('22/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (9, 9, TO_DATE('16/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (10, 10, TO_DATE('24/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (1, 10, TO_DATE('16/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (2, 9, TO_DATE('19/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (3, 8, TO_DATE('21/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (4, 7, TO_DATE('18/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (5, 6, TO_DATE('26/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (6, 5, TO_DATE('21/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (7, 4, TO_DATE('23/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (8, 3, TO_DATE('24/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (9, 2, TO_DATE('22/08/2020', 'DD/MM/YYYY'));
INSERT INTO postulaciones (idPostulante, idOferta, fecha)
VALUES (10, 1, TO_DATE('18/08/2020', 'DD/MM/YYYY'));