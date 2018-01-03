package Trabalho;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    ClienteDao cd=new ClienteDao();

    public Cliente() {

    }

    public boolean lerCliente(){
        ArrayList<Cliente> list;
        list=cd.listClienteDao();

        for(Cliente c: list) {
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("ID: " + c.getId());
            System.out.println("NOME: " + c.getNome());
            System.out.println("TELEFONE: " + c.getTelefone());
            System.out.println("E-MAIL: " + c.getEmail());
            System.out.println("LOGIN: " + c.getLogin());
            System.out.println("SENHA: " + c.getSenha());
            System.out.println("TIPO DE PERMIÇÃO: "+c.getTipoPessoa());
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
        }
        return true;
    }

    public Cliente addCliente(){
        Pessoa p=new Pessoa();
        p.add();
        Cliente c=new Cliente();
        c.setNome(p.getNome());
        c.setTelefone(p.getTelefone());
        c.setEmail(p.getEmail());
        c.setLogin(p.getLogin());
        c.setSenha(p.getSenha());
        c.setTipoPessoa(p.getTipoPessoa());
        cd.save(c);
        return c;
    }

    public void removerCliente(){
        int id;
        if (lerCliente()){
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("DIGITE O CÓDIGO DO CLIENTE: ");
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------");
            id=tc.nextInt();
            cd.removerCliente(id);
        }
    }

    public void alterarCliente(){
        int id;
        if (lerCliente()){
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("DIGITE O CÓDIGO DO CLIENTE: ");
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------");
            id=tc.nextInt();
            Cliente c=new Cliente();
            c=c.addCliente();
            c.setId(id);
            cd.atualizarCliente(c);
        }
    }
}