package Trabalho;


import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        DbUtils db = new DbUtils();
        db.dropTable();
        db.criarDB();
        GerenteDao gerenteDao = new GerenteDao();
        Gerente gerente = new Gerente();
        gerente.setNome("Alexandre");
        gerente.setTelefone("(51)998432400");
        gerente.setEmail("als.stumpf@gmail.com");
        gerente.setLogin("als");
        gerente.setSenha("als");
        gerente.setTipoPessoa(3);
        gerenteDao.save(gerente);
        Pessoa usuario = new Pessoa();
        Login log = new Login();
        Scanner tc = new Scanner(System.in);
        int op = 0;
        do {
            log.menuLogin();
            op=tc.nextInt();
            switch (op){
                case 1:{
                    String login;
                    String senha;
                    Pessoa p=new Pessoa();
                    System.out.println("DIGITE O SEU LOGIN: ");
                    login=tc.next();
                    System.out.println("DIGITE A SUA SENHA: ");
                    senha=tc.next();
                    usuario=p.validaLogin(login, senha);
                    if (usuario!=null){
                        op=0;
                        do {
                            log.menuUsuario();
                            op=tc.nextInt();
                            usuario.setTipoPessoa(op);
                            switch (op){
                                case 1:{
                                    op=0;
                                    if (usuario.getTipoPessoa()>=1 && usuario.getTipoPessoa()!=2){
                                        do {
                                            Chamada ch=new Chamada();
                                            ClienteDao cld=new ClienteDao();
                                            log.menuCliente();
                                            op=tc.nextInt();
                                            switch (op){
                                                case 1:{
                                                    if (cld.listClienteDao()!=null){
                                                        ch.addChamada(usuario.getTipoPessoa());
                                                    }
                                                    else {
                                                        System.out.println("Não existe cliente para cadastrar esta chamada");
                                                    }
                                                    break;
                                                }
                                                case 2:{
                                                    if (ch.lerChamada(1, usuario.getId(), usuario.getTipoPessoa())){
                                                        ch.alterarChamada();
                                                    }
                                                    break;
                                                }
                                                case 3:{
                                                    if (usuario.getTipoPessoa()!=3){
                                                        ch.lerChamada(1, usuario.getId(), usuario.getTipoPessoa());
                                                    }
                                                    else {
                                                        System.out.println("Voce não logou como cliente");
                                                    }
                                                    break;
                                                }
                                                case 4:{
                                                    ch.lerChamada(1, usuario.getId(), usuario.getTipoPessoa());
                                                    System.out.println("");
                                                    ch.finalizarChamada();
                                                    break;
                                                }
                                                case 5:{
                                                    System.out.println("PAGINA DE CLIENTE ENCERRADA");
                                                    break;
                                                }
                                                default:{
                                                    System.out.println("OPÇÃO INVALIDA, DIGITE OUTRA OPÇÃO:");
                                                    break;
                                                }
                                            }
                                        }while (op!=5);
                                    }
                                    else {
                                        System.out.println("Nivel de permição negado");
                                    }
                                    op=0;
                                    break;
                                }
                                case 2:{
                                    op=0;
                                    Chamada ch=new Chamada();
                                    if (usuario.getTipoPessoa()>=2){
                                        do {
                                            log.menuTecnico();
                                            op=tc.nextInt();
                                            switch (op){
                                                case 1:{
                                                    ch.lerChamada(0, usuario.getId(), usuario.getTipoPessoa());
                                                    break;
                                                }
                                                case 2:{
                                                    ch.lerChamada(1, usuario.getId(), usuario.getTipoPessoa());
                                                    break;
                                                }
                                                case 3:{
                                                    ch.finalizarChamada();
                                                    break;
                                                }
                                                case 4:{
                                                    System.out.println("PAGINA DE TÉCNICO ENCERRADA");
                                                    break;
                                                }
                                                default:{
                                                    System.out.println("OPÇÃO INVALIDA, DIGITE OUTRA OPÇÃO:");
                                                    break;
                                                }
                                            }
                                        }while (op!=4);
                                    }
                                    else {
                                        System.out.println("Nivel de permição negado");
                                    }
                                    op=0;
                                    break;
                                }
                                case 3:{
                                    op=0;
                                    Gerente g=new Gerente();
                                    Cliente c=new Cliente();
                                    Tecnico t=new Tecnico();
                                    Chamada ch=new Chamada();
                                    if (usuario.getTipoPessoa()>=3){
                                        do {
                                            log.menuGerente();
                                            op=tc.nextInt();
                                            switch (op){
                                                case 1:{
                                                    c.addCliente();
                                                    break;
                                                }
                                                case 2:{
                                                    c.alterarCliente();
                                                    break;
                                                }
                                                case 3:{
                                                    c.lerCliente();
                                                    break;
                                                }
                                                case 4:{
                                                    c.removerCliente();
                                                    break;
                                                }
                                                case 5:{
                                                    t.addTecnico();
                                                    break;
                                                }
                                                case 6:{
                                                    t.alterarTecnico();
                                                    break;
                                                }
                                                case 7:{
                                                    t.lerTecnico();
                                                    break;
                                                }
                                                case 8:{
                                                    t.removerTecnico();
                                                    break;
                                                }
                                                case 9:{
                                                    g.addGerente();
                                                    break;
                                                }
                                                case 10:{
                                                    g.alterarGerente();
                                                    break;
                                                }
                                                case 11:{
                                                    g.lerGerente();
                                                    break;
                                                }
                                                case 12:{
                                                    g.removerGerente();
                                                    break;
                                                }
                                                case 13:{
                                                    if (ch.lerChamada(1, usuario.getId(), usuario.getTipoPessoa())){
                                                        ch.alterarTecnicoChamada();
                                                    }
                                                    break;
                                                }
                                                case 14:{
                                                    System.out.println("PAGINA DE GERENTE ENCERRADA");
                                                    break;
                                                }
                                                default:{
                                                    System.out.println("OPÇÃO INVALIDA, DIGITE OUTRA OPÇÃO:");
                                                    break;
                                                }
                                            }
                                        }while (op!=13);
                                    }
                                    else {
                                        System.out.println("Nivel de permição negado");
                                    }
                                    op=0;
                                    break;
                                }case 4:{
                                    System.out.println("PAGINA DE LOGIN ENCERRADO");
                                    break;
                                }
                                default:{
                                    System.out.println("OPÇÃO INVALIDA, DIGITE OUTRA OPÇÃO:");
                                    break;
                                }
                            }
                        }while (op!=4);
                        op=0;
                    }
                    break;
                }
                case 2:{
                    System.out.println("PROGRAMA ENCERRADO");
                    break;
                }
                default:{
                    System.out.println("OPÇÃO INVALIDA, DIGITE OUTRA OPÇÃO:");
                    break;
                }
            }
        }while (op!=2);
    }
}