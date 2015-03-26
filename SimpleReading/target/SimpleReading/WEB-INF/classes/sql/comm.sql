CREATE DATABASE IF NOT EXISTS SimpleReading DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

/* create table Role 
 * 
 * private String id;
	
	private int roleLevel;
	
	private String roleName;
 * 
 * */

create table Roles(

	RoleId varchar(36) CHARACTER SET utf8  NOT NULL DEFAULT '',
	
	RoleLevel INT not null,
	
	RoleName VARCHAR(30) not null,
	
	PRIMARY KEY ( RoleId )
);

insert into roles (RoleId,RoleLevel,RoleName) values (uuid(),1,"test level");
insert into roles (RoleId,RoleLevel,RoleName) values (uuid(),2,"test level 2");
insert into roles (RoleId,RoleLevel,RoleName) values (uuid(),3,"test level 3");

insert into users(UserId,UserName,UserPassword,RoleLevel) values(uuid(),"SimpleReadingAdmin",MD5(MD5('admin9901828928')),1);


create table Users(

	UserId varchar(36) CHARACTER SET utf8  NOT NULL DEFAULT '',

	UserName VARCHAR(30) not null,
	
	UserPassword VARCHAR(200) not null,
	
	RoleLevel int not null,
	
	PRIMARY KEY ( UserId )
	
);

create table Articals(

	ArticalId varchar(36) CHARACTER SET utf8  NOT NULL DEFAULT '',

	Title VARCHAR(100) not null,
	
	Content text ,
	
	ReadSavePath VARCHAR(200) not null,
	
	CreatedDate Date not null,
	
	ChangedDate Date not null,
	
	UserId varchar(36) not null,
	
	PRIMARY KEY ( ArticalId )
	/*
	CONSTRAINT users_fk foreign key(UserId) references Users(UserId) on delete cascade
	*/
)
