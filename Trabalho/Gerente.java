package Trabalho;

import java.util.ArrayList;

public class Gerente extends Pessoa {
    GerenteDao gd=new GerenteDao();

    public Gerente() {

    }

    public boolean lerGerente(){
        ArrayList<Gerente> list;
        list=gd.listGerenteDao();

        for(Gerente g: list) {
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("ID: " + g.getId());
            System.out.println("NOME: " + g.getNome());
            System.out.println("TELEFONE: " + g.getTelefone());
            System.out.println("E-MAIL: " + g.getEmail());
            System.out.println("LOGIN: " + g.getLogin());
            System.out.println("SENHA: " + g.getSenha());
            System.out.println("TIPO DE PERMIÇÃO: " + g.getTipoPessoa());
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
        }
        return true;
    }

    public Gerente addGerente(){
        Pessoa p=new Pessoa();
        p.add();
        Gerente g=new Gerente();
        g.setNome(p.getNome());
        g.setTelefone(p.getTelefone());
        g.setEmail(p.getEmail());
        g.setLogin(p.getLogin());
        g.setSenha(p.getSenha());
        g.setTipoPessoa(p.getTipoPessoa());
        gd.save(g);
        return g;
    }

    public void removerGerente(){
        int id;
        if (lerGerente()){
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("DIGITE O CÓDIGO DO GERENTE: ");
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------");
            id=tc.nextInt();
            gd.removerGerente(id);
        }
    }

    public void alterarGerente(){
        int id;
        if (lerGerente()){
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("DIGITE O CÓDIGO DO GERENTE: ");
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------");
            id=tc.nextInt();
            Gerente g=new Gerente();
            g=g.addGerente();
            g.setId(id);
            gd.atualizarGerente(g);
        }
    }
}