
INSERT INTO [dbo].[Product]
           ([Name]
           ,[Description]
           ,[Version])
     VALUES
           ('SmartPhone Pro'
           ,'Copie samsung s10'
           ,'1.0.1')
GO

INSERT INTO [dbo].[Product]
           ([Name]
           ,[Description]
           ,[Version])
     VALUES
           ('Aplicatie web depozit materiale'
           ,'Cumparare materiale constructie online'
           ,'1.2.1')



INSERT INTO [dbo].[Employee]
           ([Name]
           ,[Position])
     VALUES
           ('Ciulei Cezar'
           ,'Developer')
GO

INSERT INTO [dbo].[Employee]
           ([Name]
           ,[Position])
     VALUES
           ('Daniel Popescu'
           ,'Developer')
GO

INSERT INTO [dbo].[Bug]
           ([ProductID]
           ,[Description]
           ,[Status]
           ,[Priority]
           ,[FoundByID]
           ,[AssignedToID])
     VALUES
           (1
           ,'Probleme redare muzica'
           ,'Opened'
		   ,'6/10'
           ,1
           ,2)
GO

INSERT INTO [dbo].[Bug]
           ([ProductID]
           ,[Description]
           ,[Status]
           ,[Priority]
           ,[FoundByID]
           ,[AssignedToID])
     VALUES
           (2
           ,'Nu merge butonul de login'
           ,'Opened'
		   ,'10/10'
           ,2
           ,1)
GO

INSERT INTO [dbo].[HeatedThread]
     VALUES
           (1,
		   'Cred ca as putea rezolva bugul in 2 zile')
GO

INSERT INTO [dbo].[HeatedThread]
     VALUES
           (2,
		   'Cred ca as putea rezolva bugul in 3 zile')
GO

INSERT INTO [dbo].[HeatedThreadToEmployee]
           ([EmployeeID]
           ,[HeatedThreadID])
     VALUES
           (2
           ,1)
GO

INSERT INTO [dbo].[HeatedThreadToEmployee]
           ([EmployeeID]
           ,[HeatedThreadID])
     VALUES
           (1
           ,2)
GO

INSERT INTO [dbo].[Screenshot]
           ([BugID]
           ,[Path]
           ,[Description])
     VALUES
           (1
           ,'C\\Documents...'
           ,'Se apasa play, dar nu se porneste melodia')
GO

INSERT INTO [dbo].[Screenshot]
           ([BugID]
           ,[Path]
           ,[Description])
     VALUES
           (2
           ,'C\\Images'
           ,'Probabil nu e setat listenere pe butonul de login')
GO



