package Trabalho;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TecnicoDao {
    DbHelper sqlite;
    public TecnicoDao(){
        sqlite = new DbHelper();
    }

    public void save(Tecnico t){

        if(t!=null){
            String sql= "INSERT INTO TECNICO (NOME, TELEFONE, EMAIL, LOGIN, SENHA, TIPOPESSOA, NUMTAREFAS) VALUES ('"+t.getNome()+"', '"+t.getTelefone()+"', '"+t.getEmail()+"', '" +t.getLogin()+"', '"+t.getSenha()+"', "+t.getTipoPessoa()+", " +t.getNumTarefas()+" );";
            sqlite.executarSQL(sql);
        }
    }

    public ArrayList<Tecnico> listTecnicoDao (){
        ArrayList<Tecnico> lista= new ArrayList<>();
        String sql= "SELECT ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA, TIPOPESSOA, NUMTAREFAS FROM TECNICO";
        ResultSet rs= sqlite.querySql(sql);
        try {
            while (rs.next()){
                int id = rs.getInt("ID");
                String  nome = rs.getString("NOME");
                String telefone  = rs.getString("TELEFONE");
                String  email = rs.getString("EMAIL");
                String login = rs.getString("LOGIN");
                String senha = rs.getString("SENHA");
                int tipoPessoa = rs.getInt("TIPOPESSOA");
                int numTarefas = rs.getInt("NUMTAREFAS");
                Tecnico t=new Tecnico();
                t.setId(id);
                t.setNome(nome);
                t.setTelefone(telefone);
                t.setEmail(email);
                t.setLogin(login);
                t.setSenha(senha);
                t.setTipoPessoa(tipoPessoa);
                t.setNumTarefas(numTarefas);
                lista.add(t);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if(lista.isEmpty()) {
            return null;
        }else {
            return lista;
        }
    }

    public void atualizarTecnico(Tecnico t){
        String sql = "UPDATE TECNICO SET NOME = '"+t.getNome()+"', TELEFONE = '"+t.getTelefone()+"', EMAIL = '"+t.getEmail()+"', LOGIN = '"+t.getLogin()+"', SENHA = '"+t.getSenha()+"', TIPOPESSOA = "+t.getTipoPessoa()+";";
        sqlite.executarSQL(sql);
    }

    public void removerTecnico(int id){
        String sql = "DELETE FROM TECNICO WHERE ID = "+id+";";
        sqlite.executarSQL(sql);
    }

    public void acrescimoTarefa(int id){
        String sql = "UPDATE TECNICO SET NUMTAREFAS = NUMTAREFAS+1 WHERE ID = "+id+";";
    }

    public void decrescimoTarefa(int id){
        String sql = "UPDATE TECNICO SET NUMTAREFAS = NUMTAREFAS-1 WHERE ID = "+id+";";
        sqlite.executarSQL(sql);
    }
}
