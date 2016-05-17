
create table person (
	PERSON_ID int(10) unsigned not null auto_increment,
    login varchar(10) not null,
    passw varchar(20) not null,
    primary key (person_id) using btree,
    unique key (login)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;


CREATE TABLE  animals (
  animal_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  animal_name varchar(20) not null,  
  date_birth date NOT NULL,
  sex varchar(1) not null,
  PERSON_ID int(10) unsigned NOT NULL,
  PRIMARY KEY (animal_id) USING BTREE, 
  unique key (animal_name),
  KEY `FK_PERSON_TRANSACTION_PERSON_ID` (PERSON_ID),
  CONSTRAINT `FK_PERSON_TRANSACTION_PERSON_ID` FOREIGN KEY (PERSON_ID) 
  REFERENCES person (PERSON_ID) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;



CREATE TABLE  autoriz_detail (
  aut_det_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  date_start date default NULL,
  date_end date default NULL,
  cnt_aut bigint(20) default null,
  PERSON_ID int(10) unsigned NOT NULL,
  PRIMARY KEY (aut_det_id) USING BTREE,  
  KEY `FK_PERSON_AUT_PERSON_ID` (PERSON_ID),
  CONSTRAINT `FK_PERSON_AUT_PERSON_ID` FOREIGN KEY (PERSON_ID) 
  REFERENCES person (PERSON_ID) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;




CREATE TABLE  operations (
  oper_id int(10) unsigned NOT NULL AUTO_INCREMENT,
  oper_code varchar(10) not null,
  oper_name varchar(30) not null,
  PRIMARY KEY (oper_id) USING BTREE,
  unique key (oper_code)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;