CREATE DATABASE ssmbuild;
USE ssmbuild;
CREATE TABLE `books`(
`bookID` INT NOT NULL AUTO_INCREMENT COMMENT '��id',
`bookName` VARCHAR(100) NOT NULL COMMENT '����',
`bookCounts` INT NOT NULL COMMENT '����',
`detail` VARCHAR(200) NOT NULL COMMENT '����',
KEY `bookID`(`bookID`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`) VALUES(1,'Java',1,'�����ŵ�����');
INSERT INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`) VALUES(2,'MySQL',10,'��ɾ�⵽��·');
INSERT INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`) VALUES(3,'Linux',5,'�ӽ��ŵ�����');