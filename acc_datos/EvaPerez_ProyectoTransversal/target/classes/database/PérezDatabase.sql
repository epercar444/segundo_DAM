create database perez_spring_boot;
use perez_spring_boot;

CREATE USER IF NOT EXISTS 'evaSpring'@'172.17.0.1' IDENTIFIED BY 'root1234';
GRANT ALL PRIVILEGES ON perez_spring_boot.* TO 'evaSpring'@'172.17.0.1';

FLUSH PRIVILEGES;
