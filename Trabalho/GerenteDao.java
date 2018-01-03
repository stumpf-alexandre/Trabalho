package Trabalho;

import java.sql.ResultSet;
import java.util.ArrayList;

public class GerenteDao {
    DbHelper sqlite;
    public GerenteDao(){
        sqlite = new DbHelper();
    }

    public void save(Gerente g){

        if(g!=null){
            String sql= "INSERT INTO GERENTE (NOME,TELEFONE,EMAIL,LOGIN,SENHA,TIPOPESSOA) VALUES ('"+g.getNome()+"', '"+g.getTelefone()+"', '"+g.getEmail()+"', '" +g.getLogin()+"', '"+g.getSenha()+"', "+g.getTipoPessoa()+" );";
            sqlite.executarSQL(sql);
        }
    }

    public ArrayList<Gerente> listGerenteDao (){
        ArrayList<Gerente> lista= new ArrayList<>();
        String sql= "SELECT ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA, TIPOPESSOA FROM GERENTE";
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
                Gerente g=new Gerente();
                g.setId(id);
                g.setNome(nome);
                g.setTelefone(telefone);
                g.setEmail(email);
                g.setLogin(login);
                g.setSenha(senha);
                g.setTipoPessoa(tipoPessoa);
                lista.add(g);
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

    public void atualizarGerente(Gerente g){
        String sql = "UPDATE GERENTE SET NOME = '"+g.getNome()+"', TELEFONE = '"+g.getTelefone()+"', EMAIL = '"+g.getEmail()+"', LOGIN = '"+g.getLogin()+"', SENHA = '"+g.getSenha()+"', TIPOPESSOA = "+g.getTipoPessoa()+";";
        sqlite.executarSQL(sql);
    }

    public void removerGerente(int id){
        String sql = "DELETE FROM GERENTE WHERE ID = "+id+";";
        sqlite.executarSQL(sql);
    }
}