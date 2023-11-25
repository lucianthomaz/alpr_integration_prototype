CREATE TABLE `vehicle`
(
    `license_plate` varchar(08),
    `model`         varchar(100),
    `color`         varchar(50),
    PRIMARY KEY (`license_plate`)
);

CREATE TABLE `alert_type`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `name`        varchar(20),
    `description` varchar(100),
    PRIMARY KEY (`id`)
);

CREATE TABLE `location`
(
    `id`        int NOT NULL AUTO_INCREMENT,
    `address`   varchar(100),
    `latitude`  Decimal(8, 6),
    `longitude` Decimal(9, 6),
    `direction` varchar(50),
    PRIMARY KEY (`id`)
);

CREATE TABLE `user`
(
    `id`       int NOT NULL AUTO_INCREMENT,
    `name`     varchar(100),
    `email`    varchar(100),
    `username` varchar(100),
    `password` varchar(100),
    `last_known_latitude`  Decimal(8, 6),
    `last_known_longitude` Decimal(9, 6),
    `device_fcm_token` varchar(200),
    `last_modified` datetime,
    PRIMARY KEY (`id`)
);

CREATE TABLE `alert`
(
    `id`            int NOT NULL AUTO_INCREMENT,
    `location_id`   int,
    `license_plate` varchar(08),
    `alert_type_id` int,
    `creation_date` datetime,
    `details`       varchar(100),
    `status`        varchar(20),
    `picture_url`   varchar(2000),
    `last_modified` datetime,
    `last_modified_by` int,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`location_id`) REFERENCES location(`id`),
    FOREIGN KEY (`license_plate`) REFERENCES vehicle(`license_plate`),
    FOREIGN KEY (`alert_type_id`) REFERENCES alert_type(`id`),
    FOREIGN KEY (`last_modified_by`) REFERENCES user(`id`)
);

CREATE TABLE `user_alert`
(
    `alert_id` int,
    `user_id`  int,
    `Accepted` tinyint,
    PRIMARY KEY (`alert_id`, `user_id`),
    FOREIGN KEY (`alert_id`) REFERENCES alert (`id`),
    FOREIGN KEY (`user_id`) REFERENCES user (`id`)
);

