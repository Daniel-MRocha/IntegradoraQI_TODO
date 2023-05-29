INSERT INTO PRIORIDADE (TIPO) VALUES ('Alta'), ('Normal'), ('Baixa');
INSERT INTO SITUACAO (STATUS) VALUES ('Aberta'),('Expirada'),('Concluida');
INSERT INTO TAREFA (ID_PRIORIDADE,ID_SITUACAO,CONCLUIDA,DEADLINE,INICIO,TITULO,TAREFA) VALUES (1,1,null,'2021-08-26 13:34:00','2021-08-26 14:00:00','Minha tarefa','definição da primeira tarefa para teste no database');