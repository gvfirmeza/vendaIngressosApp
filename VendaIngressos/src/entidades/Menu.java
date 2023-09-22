package entidades;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String cadastro;
        String ingresso = "";
        String nomeEvent = "";
        String dataEvent = "";
        String localEvent = "";
        String maxEvent = "";

        while (true) {
            System.out.println("Bem vindo!");
            System.out.println("O que deseja fazer?");
            System.out.println("Cadastrar novo evento(ce), Comprar Ingressos(ci)");
            System.out.println("Ver as Informações do Evento(ie), Número restantes de Ingressos(ni), Ver o último ingresso comprado(ic)");
            System.out.println("Sair(s)");
            cadastro = leitor.next();

            switch (cadastro) {
                case "ce":
                    System.out.println("Informe o nome do evento:");
                    nomeEvent = leitor.next();
                    System.out.println("Informe a data do evento:");
                    dataEvent = leitor.next();
                    System.out.println("Qual o local desejado:");
                    localEvent = leitor.next();
                    System.out.println("Qual o número máximo de participantes:");
                    maxEvent = leitor.next();
                    break;

                case "ci":
                    System.out.println("Qual ingresso necessário? Inteiro(int)/Meia");
                    ingresso = leitor.next();

                    switch (ingresso) {
                        case "int":
                            System.out.println("Você comprou um ingresso tipo Inteira");
                            break;

                        case "meia":
                            System.out.println("Você comprou um ingresso tipo Meia");
                            break;

                        default:
                            System.out.println("Ingresso inválido");
                            break;
                    }
                    break;

                case "ie":
                    System.out.println("Nome do evento:" + nomeEvent);
                    System.out.println("Data do evento:" + dataEvent);
                    System.out.println("Local do evento:" + localEvent);
                    System.out.println("Número máximo de participantes:" + maxEvent);
                    break;

                case "ni":
                    System.out.println("Restam 10 ingressos");
                    break;

                case "ic":
                    System.out.println("Seu último ingresso comprado");
                    break;

                case "s":
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
