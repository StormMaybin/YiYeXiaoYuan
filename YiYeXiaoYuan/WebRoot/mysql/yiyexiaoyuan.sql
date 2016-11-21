CREATE DATABSE yiyexiaoyuan;

USE yiyexiaoyuan;

# 创建用户表
CREATE TABLE user(
	id INT AUTO_INCREMENT,
	userName VARCHAR(20) UNIQUE,
	passWord VARCHAR(64) NOT NULL,
	mobile VARCHAR(20) UNIQUE,
	goodApprise INT DEFAULT 0,
	badApprise INT DEFAULT 0,
	PRIMARY KEY (id)
);

# 创建拼车信息表

CREATE TABLE information (
	id INT AUTO_INCREMENT,
	uid INT NOT NULL,
	startDate DATE NOT NULL,
	startPos VARCHAR(40) NOT NULL,
	arrivePos VARCHAR(40) NOT NULL,
	startTime_min_hour SMALLINT  NOT NULL CHECK (startTime_min_hour >= 0 AND startTime_min_hour <= 23),
	startTime_min_min SMALLINT NOT NULL CHECK (startTime_min_min >= 0 AND startTime_min_min <= 59) ,
	startTime_max_hour SMALLINT NOT NULL CHECK (startTime_max_hour >= 0 AND startTime_max_hour <= 23) ,
	startTime_max_min SMALLINT NOT NULL CHECK (startTime_max_min >= 0 AND startTime_max_min <= 59) ,
	maxMember SMALLINT  NOT NULL CHECK (maxMember >= 1 AND maxMember <= 6),
	curtMember SMALLINT NOT NULL CHECK (maxMember >= 0 AND maxMember <= 6),
	message TINYTEXT, # 备注
	pubtime DATE NOT NULL,
	retroaction TEXT,
	PRIMARY KEY (id),
	FOREIGN KEY (uid) REFERENCES user(id)
);
# 成员表
CREATE TABLE member (
	main_id INT NOT NULL,
	id1 INT,
	id2 INT,
	id3 INT,
	id4 INT,
	id5 INT,
	FOREIGN KEY (main_id) REFERENCES information(id),
	FOREIGN KEY (id1) REFERENCES user(id),
	FOREIGN KEY (id2) REFERENCES user(id),
	FOREIGN KEY (id3) REFERENCES user(id),
	FOREIGN KEY (id4) REFERENCES user(id),
	FOREIGN KEY (id5) REFERENCES user(id)
);
# 创建用户报的触发器，实现userName默认值为mobile
CREATE TRIGGER Insert_begin BEFORE INSERT ON user
	FOR EACH ROW
	BEGIN
		IF (new.userName is null) THEN 
			set new.userName = new.mobile;
		END IF;
	END;

INSERT INTO user(passWord, mobile) VALUES (123456, 18288888888);
INSERT INTO information (id, startDate,startPos,arrivePos, startTime_min_hour, startTime_min_min, startTime_max_hour, startTime_max_min, maxMember, curtMember, message, pubTime)  VALUES (1, '2016-11-8', '西电南校区','火车站',00,00,23,59,6,3,'我人很准时','2016-11-8');
               