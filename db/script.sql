DROP DATABASE IF EXISTS test;

CREATE DATABASE test;

USE test;

DROP TABLE IF EXISTS parts;
CREATE TABLE parts(
  id INT(8) NOT NULL AUTO_INCREMENT,
  name VARCHAR(25) NOT NULL DEFAULT '<None>',
  stock INT NOT NULL DEFAULT '0',
  isRequired BIT(1) NOT NULL DEFAULT b'0',
  createdDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO parts (id, name, stock, isRequired, createdDate)
VALUES
(1,"Корпус",15,1,"2019-05-08 16:00:00"),
(2,"Блок питания",12,1,"2019-05-08 16:00:00"),
(3,"Материнская плата",22,1,"2019-05-08 16:00:00"),
(4,"Процессор",35,1,"2019-05-08 16:00:00"),
(5,"Оперативная память",20,1,"2019-05-08 16:00:00"),
(6,"Видеокарта",16,1,"2019-05-08 16:00:00"),
(7,"HDD диск",28,1,"2019-05-08 16:00:00"),
(8,"Вентилятор для процессора",25,1,"2019-05-08 16:00:00"),
(9,"Вентилятор для корпуса",25,1,"2019-05-08 16:00:00"),
(10,"Кабель SATA",38,1,"2019-05-08 16:00:00"),
(11,"Кабель IDE",35,0,"2019-05-08 16:00:00"),
(12,"Кабель FDD",27,0,"2019-05-08 16:00:00"),
(13,"SSD диск",16,0,"2019-05-08 16:00:00"),
(14,"DVD дисковод",8,0,"2019-05-08 16:00:00"),
(15,"Blu-Ray дисковод",6,0,"2019-05-08 16:00:00"),
(16,"Сетевая карта",5,0,"2019-05-08 16:00:00"),
(17,"Звуковая карта",5,0,"2019-05-08 16:00:00"),
(18,"Кардридер",10,0,"2019-05-08 16:00:00"),
(19,"Контроллер COM",4,0,"2019-05-08 16:00:00"),
(20,"Контроллер USB",3,0,"2019-05-08 16:00:00"),
(21,"Контроллер Firewire",3,0,"2019-05-08 16:00:00"),
(22,"Регулятор оборотов",6,0,"2019-05-08 16:00:00"),
(23,"Термоинтерфейс",5,0,"2019-05-08 16:00:00"),
(24,"Жидкостное охлаждение",5,0,"2019-05-08 16:00:00"),
(25,"Салазки в 3.5 отсек",10,0,"2019-05-08 16:00:00");

DROP TABLE IF EXISTS hibernate_sequence;

CREATE TABLE hibernate_sequence (
  next_val bigint(20) DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;

INSERT INTO hibernate_sequence (next_val)
VALUES (26);