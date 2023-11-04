INSERT INTO `user` (`name`, `email`, `username`, `password`)
VALUES ('SYSTEM', 'SYSTEM', 'SYSTEM', 'SYSTEM'),
       ('Lucian', 'lucian@email.com', 'lucian', 'password'),
       ('Franciele', 'franciele@email.com', 'franciele', 'password');

INSERT INTO alert_type (`name`, `description`)
VALUEs ('Roubo', 'Veículo Roubado'),
       ('Fuga', 'Veículo fugiu da abordagem policial'),
       ('Clone', 'Veículo clonado');

INSERT INTO location (`address`, `latitude`, `longitude`, `direction`)
VALUES  ('Av. da Serraria, 520', -30.150385, -51.217771, 'Centro/Bairro'),
        ('Av. da Serraria, 520', -30.150385, -51.217771, 'Bairro/Centro'),
        ('BR 116', -29.998848, -51.203873, 'Bairro/Centro'),
        ('Av. Protásio Alvez', -30.040975, -51.157949, 'Centro/Bairro');

INSERT INTO vehicle (`license_plate`, `model`, `color`)
VALUES  ('ABC-1234', 'Gol', 'Branco'),
        ('DEF-5678', 'Celta', 'Preto'),
        ('GHI-9012', 'Palio', 'Prata'),
        ('JKL-3456', 'Uno', 'Vermelho');