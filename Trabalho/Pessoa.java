package Trabalho;

import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String login;
    private String senha;
    private int tipoPessoa;
    Scanner tc=new Scanner(System.in);

    public Pessoa(String nome, String telefone, String email, String login, String senha, int tipoPessoa){
        this.nome=nome;
        this.telefone=telefone;
        this.email=email;
        this.login=login;
        this.senha=senha;
        this.tipoPessoa=tipoPessoa;
    }

    public Pessoa(int id, String nome, String telefone, String email, String login, String senha, int tipoPessoa){
        this.id=id;
        this.nome=nome;
        this.telefone=telefone;
        this.email=email;
        this.login=login;
        this.senha=senha;
        this.tipoPessoa=tipoPessoa;
    }

    public Pessoa(String nome){
        this.nome=nome;
    }

    public Pessoa() {

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(int tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public void ler(){
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("ID: "+getId());
        System.out.println("NOME: "+getNome());
        System.out.println("TELEFONE: "+getTelefone());
        System.out.println("E-MAIL: "+getEmail());
        System.out.println("LOGIN: "+getLogin());
        System.out.println("SENHA: "+getSenha());
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("");
    }

    public void add(){
        System.out.println("");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Digite o nome: ");
        this.nome=tc.next();
        System.out.println("Digite o telefone: ");
        this.telefone=tc.next();
        System.out.println("Digite o e-mail: ");
        this.email=tc.next();
        System.out.println("Digite o login: ");
        this.login=tc.next();
        System.out.println("Digite a senha: ");
        this.senha=tc.next();
        System.out.println("Digite o tipo de usuario: ");
        this.tipoPessoa=tc.nextInt();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("");
    }

    public boolean comparaNome(String nome){
        if (nome==getNome()){
            System.out.println("Nome encontrado");
            return true;
        }
        else {
            System.out.println("Nome não encontrado");
            return false;
        }
    }

    public Pessoa validaLogin(String login, String senha){
        PessoaDao pd=new PessoaDao();
        ArrayList<Pessoa> p=pd.listPessoa();
        if (p!=null){
            for (Pessoa pp:p){
                if (pp.getLogin().equalsIgnoreCase(login)){
                    if (pp.getSenha().equals(senha)){
                        System.out.println("ACESSO PERMITIDO");
                        return pp;
                    }else {
                        System.out.println("SENHA INCORRETA");
                        return null;
                    }
                }
                else {
                    System.out.println("LOGIN INCORRETO");
                    return null;
                }
            }
        }
        else {
            System.out.println("USUARIO NÃO ENCONTRADO");
        }
        return null;
    }
}
