CREATE TABLE `Veiculo`
(
    `placa`  varchar(08),
    `modelo` varchar(100),
    `cor`    varchar(50),
    PRIMARY KEY (`placa`)
);

CREATE TABLE `Status`
(
    `id`     int,
    `status` varchar(50),
    PRIMARY KEY (`id`)
);

CREATE TABLE `Tipo_alerta`
(
    `id`        int,
    `nome`      varchar(20),
    `descricao` varchar(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `Local`
(
    `id`        int,
    `endereco`  varchar(100),
    `latitude`  Decimal(8, 6),
    `longitude` Decimal(9, 6),
    `sentido`   varchar(50),
    PRIMARY KEY (`id`)
);

CREATE TABLE `Usuario`
(
    `id`      int,
    `nome`    varchar(100),
    `email`   varchar(100),
    `usuario` varchar(100),
    `senha`   varchar(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `Alerta`
(
    `id`             int,
    `local_id`       int,
    `placa`          varchar(08),
    `tipo_alerta_id` varchar(08),
    `data_hora`      datetime,
    `detalhes`       varchar(100),
    `status_id`      int,
    `foto_url`       varchar(2000),
    PRIMARY KEY (`id`)
);

CREATE TABLE `alerta_usuario`
(
    `id`         int,
    `alerta_id`  int,
    `usuario_id` int,
    `Aceite`     tinyint,
    PRIMARY KEY (`id`)
);

