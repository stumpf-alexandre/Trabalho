package Trabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class Tecnico extends Pessoa {
    private int numTarefas;
    Scanner tc=new Scanner(System.in);
    TecnicoDao td=new TecnicoDao();

    public Tecnico() {

    }

    public int getNumTarefas() {
        return numTarefas;
    }

    public void setNumTarefas(int numTarefas) {
        this.numTarefas = numTarefas;
    }

    public boolean lerTecnico(){
        ArrayList<Tecnico> list;
        list=td.listTecnicoDao();

        for(Tecnico t: list) {
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("ID: " + t.getId());
            System.out.println("NOME: " + t.getNome());
            System.out.println("TELEFONE: " + t.getTelefone());
            System.out.println("E-MAIL: " + t.getEmail());
            System.out.println("LOGIN: " + t.getLogin());
            System.out.println("SENHA: " + t.getSenha());
            System.out.println("TIPO DE PERMIÇÃO: " +t.getTipoPessoa());
            System.out.println("NUMERO DE TAREFAS: " + t.getNumTarefas());
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
        }
        return true;
    }

    public Tecnico addTecnico(){
        Pessoa p=new Pessoa();
        p.add();
        Tecnico t=new Tecnico();
        t.setNome(p.getNome());
        t.setTelefone(p.getTelefone());
        t.setEmail(p.getEmail());
        t.setLogin(p.getLogin());
        t.setSenha(p.getSenha());
        t.setTipoPessoa(p.getTipoPessoa());
        t.setNumTarefas(0);
        td.save(t);
        return t;
    }

    public void removerTecnico(){
        int id;
        if (lerTecnico()){
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("DIGITE O CÓDIGO DO TECNICO: ");
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------");
            id=tc.nextInt();
            td.removerTecnico(id);
        }
    }

    public void alterarTecnico(){
        int id;
        if (lerTecnico()){
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("DIGITE O CÓDIGO DO TECNICO: ");
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------");
            id=tc.nextInt();
            Tecnico t=new Tecnico();
            t=t.addTecnico();
            t.setId(id);
            td.atualizarTecnico(t);
        }
    }
}