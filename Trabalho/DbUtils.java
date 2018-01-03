package Trabalho;

public class DbUtils {
    DbHelper sqlite;

    public DbUtils(){
        sqlite = new DbHelper();
    }
    public  void criarDB()
    {

        String sqlCliente =
                    "CREATE TABLE CLIENTE                                "+
                        "(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
                        "NOME               VARCHAR(100)    NOT NULL,    "+
                        "TELEFONE           VARCHAR(11)     NOT NULL,    "+
                        "EMAIL              VARCHAR(70)     NOT NULL,    "+
                        "LOGIN              VARCHAR(70)     NOT NULL,    "+
                        "SENHA              VARCHAR(70)     NOT NULL,    "+
                        "TIPOPESSOA         INT             NOT NULL);   ";
        sqlite.executarSQL(sqlCliente);

        String sqlTecnico =
                    "CREATE TABLE TECNICO                                "+
                        "(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
                        "NOME               VARCHAR(100)    NOT NULL,    "+
                        "TELEFONE           VARCHAR(11)     NOT NULL,    "+
                        "EMAIL              VARCHAR(70)     NOT NULL,    "+
                        "LOGIN              VARCHAR(70)     NOT NULL,    "+
                        "SENHA              VARCHAR(70)     NOT NULL,    "+
                        "TIPOPESSOA         INT             NOT NULL,    "+
                        "NUMTAREFAS         INT             NOT NULL);   ";

        sqlite.executarSQL(sqlTecnico);

        String sqlGerente =
                    "CREATE TABLE GERENTE                                "+
                        "(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
                        "NOME               VARCHAR(100)    NOT NULL,    "+
                        "TELEFONE           VARCHAR(11)     NOT NULL,    "+
                        "EMAIL              VARCHAR(70)     NOT NULL,    "+
                        "LOGIN              VARCHAR(70)     NOT NULL,    "+
                        "SENHA              VARCHAR(70)     NOT NULL,    "+
                        "TIPOPESSOA         INT             NOT NULL);   ";
        sqlite.executarSQL(sqlGerente);

        String sqlChamada =
                    "CREATE TABLE CHAMADA                                "+
                        "(ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+
                        "PROBLEMA           VARCHAR(200)   NOT NULL,     "+
                        "PRIORIDADE         INT            NOT NULL,     "+
                        "IDCLIENTE          INT            NOT NULL,     "+
                        "FOREIGN KEY (IDCLIENTE) REFERENCES CLIENTE(ID), "+
                        "IDTECNICO          INT            NOT NULL,     "+
                        "FOREIGN KEY (IDTECNICO) REFERENCES TECNICO(ID), "+
                        "STATUS             INT            NOT NULL);    ";
        sqlite.executarSQL(sqlChamada);

    }

    public  void dropTable() {
        String sql = "DROP TABLE IF EXISTS PESSOA; DROP TABLE IF EXISTS CHAMADA; DROP TABLE IF EXISTS CLIENTE; DROP TABLE IF EXISTS TECNICO; DROP TABLE IF EXISTS GERENTE;";
        sqlite.executarSQL(sql);
    }
}