package Trabalho;

public class Login {
    public void menuLogin(){
        System.out.println("\nDigite uma opção para se: \n");
        System.out.println("\n1-LOGAR\n");
        System.out.println("\n2-SAIR\n");
    }

    public void menuUsuario(){
        System.out.println("\nDigite uma opção para se logar em uma pagina: \n");
        System.out.println("\n1-CLIENTE\n");
        System.out.println("\n2-TÉCNICO\n");
        System.out.println("\n3-GERENTE\n");
        System.out.println("\n4-SAIR\n");
    }

    public void menuGerente(){
        System.out.println("\nDigite uma opção para\n");
        System.out.println("\nCLIENTES\n");
        System.out.println("\n1-Cadastrar\n");
        System.out.println("\n2-Alterar\n");
        System.out.println("\n3-Visualizar\n");
        System.out.println("\n4-Excluir\n");
        System.out.println("\n\n");
        System.out.println("\nTECNICOS");
        System.out.println("\n5-Cadastrar\n");
        System.out.println("\n6-Alterar\n");
        System.out.println("\n7-Visualizar\n");
        System.out.println("\n8-Excluir\n");
        System.out.println("\n\n");
        System.out.println("\nGERENTE\n");
        System.out.println("\n9-Cadastrar\n");
        System.out.println("\n10-Alterar\n");
        System.out.println("\n11-Visualizar\n");
        System.out.println("\n12-Excluir\n");
        System.out.println("\n13-Alterar Técnico da Chamada\n");
        System.out.println("\n14-SAIR\n");
    }

    public void menuTecnico(){
        System.out.println("\nDigite uma opção para\n");
        System.out.println("\n1-Consultar chamadas realizadas\n");
        System.out.println("\n2-Consultar chamadas pendentes\n");
        System.out.println("\n3-Finalizar chamada\n");
        System.out.println("\n4-SAIR\n");
    }

    public void menuCliente(){
        System.out.println("\nDigite uma opção para\n");
        System.out.println("\n1-Cadastrar chamada\n");
        System.out.println("\n2-Alterar chamada\n");
        System.out.println("\n3-Visualizar chamadas\n");
        System.out.println("\n4-Cancelar Chamada\n");
        System.out.println("\n5-SAIR\n");
    }
}