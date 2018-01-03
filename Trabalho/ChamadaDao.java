package Trabalho;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ChamadaDao {
    DbHelper sqlite;
    public ChamadaDao(){
        sqlite = new DbHelper();
    }

    public void save(Chamada ch){

        if(ch!=null){
            String sql= "INSERT INTO CHAMADA (ID, PROBLEMA, PRIORIDADE, IDCLIENTE, IDTECNICO, STATUS) VALUES ("+ch.getId()+",'"+ch.getProblema()+"',"+ch.getPrioridade()+","+ch.getIdCliente()+","+ch.getIdTecnico()+","+ch.getStatus()+");";
            sqlite.executarSQL(sql);
        }

    }

    public ArrayList<Chamada> listChamadaDao (int idUsuario, int tipoPessoa){
        ArrayList<Chamada> lista= new ArrayList<>();
        String sql;
        if (tipoPessoa==1){
            sql = "SELECT ID, PROBLEMA, PRIORIDADE, IDTECNICO, STATUS FROM CHAMADA WHERE IDCLIENTE = "+idUsuario+";";
        }
        else if (tipoPessoa==2){
            sql = "SELECT ID, PROBLEMA, PRIORIDADE, IDCLIENTE, STATUS FROM CHAMADA WHERE IDTECNICO = "+idUsuario+";";
        }
        else {
            sql = "SELECT ID, PROBLEMA, PRIORIDADE, IDCLIENTE,STATUS FROM CHAMADA;";
        }
        ResultSet rs = sqlite.querySql(sql);
        try {
            while (rs.next()){
                int id = rs.getInt("ID");
                String  problema = rs.getString("PROBLEMA");
                int prioridade  = rs.getInt("PRIORIDADE");
                int status = rs.getInt("STATUS");

                Chamada ch=new Chamada();
                ch.setId(id);
                ch.setProblema(problema);
                ch.setPrioridade(prioridade);
                ch.setStatus(status);
                lista.add(ch);
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

    public void atualizarCamada(Chamada ch){
        String sql = "UPDATE CHAMADA SET PROBLEMA = '"+ch.getProblema()+"', PRIORIDADE = "+ch.getPrioridade()+" WHERE ID = "+ch.getId()+";";
        sqlite.executarSQL(sql);
    }


    public void finalizarChamada(int id){
        String sql = "UPDATE CHAMADA SET STATUS = 0 WHERE ID =" +id;
        sqlite.executarSQL(sql);
    }

    public void alterarTecnico(int idChamada, int idTecnico){
        String sql = "UPDATE CHAMADA SET IDTECNICO = "+idTecnico+" WHERE ID = "+idChamada+";";
        sqlite.executarSQL(sql);
    }
}