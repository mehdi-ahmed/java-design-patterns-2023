CREATE TABLE `test_database`.`user`
(
    `id`      INT         NOT NULL,
    `name`    VARCHAR(45) NOT NULL,
    `address` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
);


INSERT INTO `test_database`.`user` (`id`, `name`, `address`)
VALUES ('1', 'Marcus', 'Pattaya, Thailand');
