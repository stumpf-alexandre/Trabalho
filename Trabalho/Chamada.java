package Trabalho;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Scanner;

public class Chamada {
    Scanner tc=new Scanner(System.in);
    ChamadaDao chd=new ChamadaDao();
    ClienteDao cd=new ClienteDao();

    private int id;
    private java.lang.String problema;
    private int prioridade;
    private int idCliente;
    private int idTecnico;
    private int status;

    public Chamada() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getProblema() {
        return problema;
    }

    public void setProblema(java.lang.String problema) {
        this.problema = problema;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean lerChamada(int status, int idUsuario, int tipoPessoa){
        ArrayList<Chamada> list;
        list=chd.listChamadaDao(idUsuario, tipoPessoa);
        if (list!=null) {
            System.out.println("Chamada encontrada: ");
            for (Chamada ch : list) {
                if (ch.getStatus() == status) {
                    System.out.println("");
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("ID: " + getId());
                    System.out.println("PROBLEMA: " + getProblema());
                    System.out.println("PRIORIDADE: " + getPrioridade());
                    System.out.println("CÓDIGO DO CLIENTE: " + getIdCliente());
                    System.out.println("CÓDIGO DO TÉCNICO: " + getIdTecnico());
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("");
                }
            }
            return true;
        }
        else {
            System.out.println("Chamada não encontrada");
            return false;
        }
    }

    public void addChamada(int numUsuario){
        TecnicoDao td=new TecnicoDao();
        Tecnico tch=new Tecnico();
        ArrayList<Tecnico>list;
        Chamada ch=new Chamada();
        int flag=0;
        int idCli;
        int esc;
        if (numUsuario==3){
            System.out.println("Digite o código do cliente cadastrado: ");
            do {
                idCli=tc.nextInt();
                if (cd.consultarId(idCli)) {
                    ch.setIdCliente(idCli);
                    flag = 1;
                }
                else {
                    System.out.println("Código inexistente: ");
                    Cliente c=new Cliente();
                    c.lerCliente();
                }
            }while (flag==0);
        }
        else {
            ch.setIdCliente(numUsuario);
        }
        System.out.println("Descreva o problema: ");
        problema=tc.next();
        do {
            System.out.println("Digite uma prioridade:");
            System.out.println("1- Baixa");
            System.out.println("2- Moderada");
            System.out.println("3- Alta");
            System.out.println("4- Urgente");
            esc=tc.nextInt();
            ch.setPrioridade(esc);
        }while (esc<1||esc>4);
        ch.setStatus(1);
        ch.setProblema(problema);
        list=td.listTecnicoDao();
        if (list!=null){
            int qtdMenor=list.get(0).getNumTarefas();
            for (Tecnico t : list){
                if (t.getNumTarefas()<=qtdMenor){
                    qtdMenor=t.getNumTarefas();
                    tch=t;
                }
            }
            ch.setIdTecnico(tch.getId());
            ch.setStatus(1);
            td.acrescimoTarefa(tch.getId());
            chd.save(ch);
        }
        else {
            System.out.println("Técnico indisponivel");
        }
    }

    public void finalizarChamada(){
        TecnicoDao td=new TecnicoDao();
        Tecnico tch=new Tecnico();
        int num;
        System.out.println("Digite o código da chamada para finalizar: ");
        num=tc.nextInt();
        td.decrescimoTarefa(tch.getId());
        chd.finalizarChamada(num);
    }

    public void alterarChamada(){
        int num;
        System.out.println("Digite o código da chamada para alterar: ");
        num=tc.nextInt();
        Chamada ch=new Chamada();
        ch=ch.ler();
        ch.setId(num);
        chd.atualizarCamada(ch);
    }

    public Chamada ler(){
        int esc;
        Chamada ch=new Chamada();
        System.out.println("Descreva o problema: ");
        problema=tc.next();
        do {
            System.out.println("Digite uma prioridade:");
            System.out.println("1- Baixa");
            System.out.println("2- Moderada");
            System.out.println("3- Alta");
            System.out.println("4- Urgente");
            esc=tc.nextInt();
            ch.setPrioridade(esc);
        }while (esc<1||esc>4);
        ch.setStatus(1);
        ch.setProblema(problema);
        return ch;
    }

    public void alterarTecnicoChamada(){
        int numCh;
        int numTec;
        Tecnico t=new Tecnico();
        System.out.println("Digite o codigo da chamada para alterar o tecnico: ");
        numCh=tc.nextInt();
        System.out.println("Técnicos disponíveis: ");
        t.lerTecnico();
        System.out.println("");
        System.out.println("Digite o código do novo Técnico para esta chamada: ");
        numTec=tc.nextInt();
        chd.alterarTecnico(numCh,numTec);
    }
}