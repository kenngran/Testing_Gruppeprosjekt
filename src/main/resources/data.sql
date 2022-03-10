--
-- Dataark for tabell `Konto`
--

INSERT INTO `Konto` (`Kontonummer`, `Personnummer`, `Saldo`, `Type`, `Valuta`) VALUES
('105010123456', '01010110523', 720, 'Lonnskonto', 'NOK'),
('105020123456', '01010110523', 100500, 'Sparekonto', 'NOK'),
('105024412345', '01010110523', 10234.5, 'Brukskonto', 'NOK'),
('304010123456', '12345678901', 4300, 'Lonnskonto', 'NOK'),
('304010123453', '12345678901', 10, 'Sparekonto', 'NOK'),
('304010123445', '12345678901', 1501, 'Matkonto', 'NOK');

--
-- Dataark for tabell `Kunde`
--

INSERT INTO `Kunde` (`Personnummer`, `Fornavn`, `Etternavn`, `Adresse`, `Postnr`, `Telefonnr`, `Passord`) VALUES
('01010110523', 'Lene', 'Jensen', 'Askerveien 22', '3270', '22224444', 'HeiHei'),
('05068787102', 'Lena', 'Jonson', 'Stokkanhaugen 178', '7048', '91374682', 'PaaPaa'),
('12345678901', 'Per', 'Hansen', 'Osloveien 82', '1234', '12345678', 'DegDeg');

--
-- Dataark for tabell `Poststed`
--

INSERT INTO `Poststed` (`Postnr`, `Poststed`) VALUES
('1234', 'Oslo'),
('7048', 'Trondheim'),
('3270', 'Asker');

--
-- Dataark for tabell `Transaksjon`
--

INSERT INTO `Transaksjon` (`TxID`, `FraTilKontonummer`, `Belop`, `Dato`, `Melding`, `Kontonummer`, `Avventer`) VALUES
(1, '20102012345', 100.5, '2015-03-15', 'Fjordkraft', '105010123456', 0),
(2, '30102012345', 400.4, '2015-03-20', 'Skagen', '105010123456', 0),
(3, '20102012345', -1400.7, '2015-03-13', 'Innbetaling', '105010123456', 1),
(4, '20102012347', 5000.5, '2015-03-30', 'Husleie', '105024412345', 0),
(5, '20102012345', 345.56, '2015-03-13', 'Kinobillett x2', '304010123445', 0),
(6, '12312340005', 700, '2012-12-12', 'Fretex klaer', '105024412345', 1),
(7, '34567890008', 3000, '2012-12-12', 'Pensumboker', '304010123453', 1),
(8, '23453467008', 11, '2012-12-12', 'Eventyrsjokolade', '304010123445', 0),
(9, '12342543605', 125, '2012-12-12', 'Pizza', '304010123445', 0),
(10, '12312340005', 1200, '2012-12-12', 'Finn sofa', '105024412345', 1);