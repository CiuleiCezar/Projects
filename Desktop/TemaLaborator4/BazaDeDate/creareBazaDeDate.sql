
CREATE TABLE [Employee](

	[ID] int NOT NULL IDENTITY(1,1),
	[Name] nvarchar(150) NOT NULL,
	[Position] nvarchar(150) NOT NULL,
	CONSTRAINT [PK_Employee] PRIMARY KEY ([ID])
);


CREATE TABLE [Tag](

	[ID] int NOT NULL IDENTITY(1,1),
	[Hashtag] nvarchar(150) NOT NULL,
	[UseCase] nvarchar(150) NOT NULL,
	CONSTRAINT [PK_Tag] PRIMARY KEY ([ID])
);


CREATE TABLE [Product](

	[ID] int NOT NULL IDENTITY(1,1),
	[Name] nvarchar(150) NOT NULL,
	[Description] nvarchar(150) NOT NULL,
	[Version] nvarchar(150) NOT NULL,
	CONSTRAINT [PK_Product] PRIMARY KEY ([ID])
);



CREATE TABLE [Bug](
	[ID] int IDENTITY(1,1) NOT NULL,
	[ProductID] int NOT NULL,
	[Description] nvarchar(256) NOT NULL,
	[Status] nvarchar(32) NOT NULL,
	[Priority] nvarchar(32) NOT NULL,
	[FoundByID] int NULL,
	[AssignedToID] int NOT NULL,
	CONSTRAINT [PK_Bug] PRIMARY KEY ([ID]),

	CONSTRAINT [FK_Bug_Employee_FoundByID] FOREIGN KEY ([FoundByID])
	REFERENCES dbo.Employee([ID]),

	CONSTRAINT [FK_Bug_Employee_AssignedToID] FOREIGN KEY ([AssignedToID])
	REFERENCES dbo.Employee([ID]),

	CONSTRAINT [FK_Bug_Product] FOREIGN KEY ([ProductID])
	REFERENCES dbo.Product([ID])
 );

 CREATE TABLE [HeatedThread](

	[ID] int NOT NULL IDENTITY(1,1),
	[BugID] int NOT NULL,
	[ThreadPost] nvarchar(150) NOT NULL,
	CONSTRAINT [PK_HeatedThread] PRIMARY KEY ([ID]),

	CONSTRAINT [FK_HeatedThread_Bug] FOREIGN KEY ([BugID])
	REFERENCES dbo.Bug([ID])
);

 CREATE TABLE [HeatedThreadToEmployee](

	[ID] int NOT NULL IDENTITY(1,1),
	[EmployeeID] int NOT NULL,
	[HeatedThreadID] int NOT NULL,
	CONSTRAINT [PK_HeatedThreadToEmployee] PRIMARY KEY ([ID]),

	CONSTRAINT [FK_HeatedThreadToEmployee_Employee] FOREIGN KEY ([EmployeeID])
	REFERENCES dbo.Employee([ID]),

	CONSTRAINT [FK_HeatedThreadToEmployee_HeatedThread] FOREIGN KEY ([HeatedThreadID])
	REFERENCES dbo.HeatedThread([ID]),
);

CREATE TABLE [TagToBug](

	[ID] int NOT NULL IDENTITY(1,1),
	[TagID] int NOT NULL,
	[BugID] int NOT NULL,
	CONSTRAINT [PK_TagToBug] PRIMARY KEY ([ID]),

	CONSTRAINT [FK_TagToBug_Tag] FOREIGN KEY ([TagID])
	REFERENCES dbo.Tag([ID]),

	CONSTRAINT [FK_TagToBug_Bug] FOREIGN KEY ([BugID])
	REFERENCES dbo.Bug([ID])
);

CREATE TABLE [Screenshot](

	[ID] int NOT NULL IDENTITY(1,1),
	[BugID] int NOT NULL,
	[Path] nvarchar(256) NOT NULL,
	[Description] nvarchar(256) NOT NULL,
	CONSTRAINT [PK_Screenshot] PRIMARY KEY ([ID]),

	CONSTRAINT [FK_Screenshot_Bug] FOREIGN KEY ([BugID])
	REFERENCES dbo.Bug([ID])
);