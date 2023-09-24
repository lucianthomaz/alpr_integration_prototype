CREATE TABLE `vehicle`
(
    `license_plate`  varchar(08),
    `model` varchar(100),
    `color`    varchar(50),
    PRIMARY KEY (`license_plate`)
);

CREATE TABLE `status`
(
    `id`     int NOT NULL AUTO_INCREMENT,
    `status` varchar(50),
    PRIMARY KEY (`id`)
);

CREATE TABLE `alert_type`
(
    `id`        int NOT NULL AUTO_INCREMENT,
    `name`      varchar(20),
    `description` varchar(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `location`
(
    `id`        int NOT NULL AUTO_INCREMENT,
    `address`  varchar(100),
    `latitude`  Decimal(8, 6),
    `longitude` Decimal(9, 6),
    `direction`   varchar(50),
    PRIMARY KEY (`id`)
);

CREATE TABLE `user`
(
    `id`      int NOT NULL AUTO_INCREMENT,
    `name`    varchar(100),
    `email`   varchar(100),
    `username` varchar(100),
    `password`   varchar(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `alert`
(
    `id`             int NOT NULL AUTO_INCREMENT,
    `location`       int,
    `license plate`  varchar(08),
    `alertType` varchar(08),
    `date_time`      datetime,
    `details`       varchar(100),
    `status`      int,
    `picture_url`       varchar(2000),
    PRIMARY KEY (`id`)
);

CREATE TABLE `user_alert`
(
    `id`         int NOT NULL AUTO_INCREMENT,
    `alert_id`  int,
    `user_id` int,
    `Accepted`     tinyint,
    PRIMARY KEY (`id`)
);

