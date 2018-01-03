package Trabalho;

import java.sql.ResultSet;
import java.util.ArrayList;

public class PessoaDao {
    DbHelper sqlite;
    public PessoaDao(){
        sqlite=new DbHelper();
    }
    public ArrayList<Pessoa>listPessoa(){
        ArrayList<Pessoa>lista=new ArrayList<>();
        String sql="SELECT ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA, TIPOPESSOA FROM GERENTE;";
        executaSql(sql, lista);
        sql="SELECT ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA, TIPOPESSOA FROM TECNICO;";
        executaSql(sql, lista);
        sql="SELECT ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA, TIPOPESSOA FORM CLIENTE;";
        executaSql(sql, lista);
        if (lista.isEmpty()){
            return null;
        }
        else {
            return lista;
        }
    }

    public void executaSql(String sql, ArrayList lista){
        ResultSet rs = sqlite.querySql(sql);
        try{
            while (rs.next()){
                int id = rs.getInt("ID");
                String nome = rs.getString("NOME");
                String telefone = rs.getString("TELEFONE");
                String email = rs.getString("EMAIL");
                String login = rs.getString("LOGIN");
                String senha = rs.getString("SENHA");
                int tipoPessoa = rs.getInt("TIPOPESSOA");
                Pessoa p=new Pessoa();
                p.setId(id);
                p.setNome(nome);
                p.setTelefone(telefone);
                p.setEmail(email);
                p.setLogin(login);
                p.setSenha(senha);
                p.setTipoPessoa(tipoPessoa);
                lista.add(p);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
