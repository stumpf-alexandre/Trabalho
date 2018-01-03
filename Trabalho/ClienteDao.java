package Trabalho;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDao {
    DbHelper sqlite;
    public ClienteDao(){
        sqlite = new DbHelper();
    }

    public void save(Cliente cl){

        if(cl!=null){
            String sql= "INSERT INTO CLIENTE (NOME, TELEFONE, EMAIL, LOGIN, SENHA, TIPOPESSOA) VALUES ('"+cl.getNome()+"', '"+cl.getTelefone()+"', '"+cl.getEmail()+"', '" +cl.getLogin()+"', '"+cl.getSenha()+"', "+cl.getTipoPessoa()+" );";
            sqlite.executarSQL(sql);
        }
    }

    public ArrayList<Cliente> listClienteDao (){
        ArrayList<Cliente> lista= new ArrayList<>();
        String sql= "SELECT ID, NOME, TELEFONE, EMAIL, LOGIN, SENHA, TIPOPESSOA FROM CLIENTE";
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
                Cliente c=new Cliente();
                c.setId(id);
                c.setNome(nome);
                c.setTelefone(telefone);
                c.setEmail(email);
                c.setLogin(login);
                c.setSenha(senha);
                c.setTipoPessoa(tipoPessoa);
                lista.add(c);
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

    public boolean consultarId(int id){
        String sql="SELECT ID FROM CLIENTE WHERE ID="+id+";";
        ResultSet rs = sqlite.querySql(sql);
        int aux=-1;
        try{
            while (rs.next()){
                aux = rs.getInt("ID");
            }
        }catch (Exception e){}
        if (aux==id){
            return true;
        }
        else {
            return false;
        }
    }

    public void atualizarCliente(Cliente c){
        String sql = "UPDATE CLIENTE SET NOME = '"+c.getNome()+"', TELEFONE = '"+c.getTelefone()+"', EMAIL = '"+c.getEmail()+"', LOGIN = '"+c.getLogin()+"', SENHA = '"+c.getSenha()+"', TIPOPESSOA = "+c.getTipoPessoa()+";";
        sqlite.executarSQL(sql);
    }

    public void removerCliente(int id){
        String sql = "DELETE FROM CLIENTE WHERE ID = "+id+";";
        sqlite.executarSQL(sql);
    }
}