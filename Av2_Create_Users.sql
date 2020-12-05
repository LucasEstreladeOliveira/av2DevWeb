use av1_db;

-- Criando usuário DEV
create user if not exists 'dev'@'localhost' identified by 'senha';

grant update,
	delete,
    insert,
    select,
    execute,
    show view
 on av1_db.* to 'dev'@'localhost';

flush privileges;

-- Criando usuário DBA
create user if not exists 'dba'@'localhost' identified by 'senha';

grant create, 
	alter, 
    references, 
    create view, 
    create routine,
    alter routine,
    event,
    drop,
    index,
    trigger
on av1_db.* to 'dba'@'localhost';

flush privileges;