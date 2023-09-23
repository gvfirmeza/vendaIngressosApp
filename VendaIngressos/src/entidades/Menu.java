package entidades;

import java.util.Scanner;

import entidades.evento.Evento;
import entidades.evento.Exposicao;
import entidades.evento.Jogo;
import entidades.evento.Show;
import entidades.ingresso.Ingresso;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Evento evento = null;
        Ingresso ultimoIngressoVendido = null;

        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Cadastrar um novo evento");
            System.out.println("2. Realizar a venda de um ingresso");
            System.out.println("3. Exibir informações do evento");
            System.out.println("4. Exibir o número de ingressos restantes");
            System.out.println("5. Exibir informações do último ingresso vendido");
            System.out.println("6. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    // Cadastrar um novo evento
                    evento = cadastrarNovoEvento();
                    break;
                case 2:
                    // Vender um ingresso
                    if (evento != null) {
                        ultimoIngressoVendido = realizarVendaIngresso(evento);
                    } else {
                        System.out.println("Por favor, cadastre um evento primeiro.");
                    }
                    break;
                case 3:
                    // Exibir informações do evento
                    if (evento != null) {
                        exibirInformacoesEvento(evento);
                    } else {
                        System.out.println("Nenhum evento cadastrado.");
                    }
                    break;
                case 4:
                    // Exibir o número de ingressos restantes
                    if (evento != null) {
                        exibirNumeroIngressosRestantes(evento);
                    } else {
                        System.out.println("Nenhum evento cadastrado.");
                    }
                    break;
                case 5:
                    // Exibir informações do último ingresso vendido
                    if (ultimoIngressoVendido != null) {
                        exibirInformacoesIngresso(ultimoIngressoVendido);
                    } else {
                        System.out.println("Nenhum ingresso vendido ainda.");
                    }
                    break;
                case 6:
                    // Sair do programa
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static Evento cadastrarNovoEvento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Cadastrar Exposição");
        System.out.println("2. Cadastrar Jogo");
        System.out.println("3. Cadastrar Show");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        Evento evento = null; 
        switch (escolha) {
            case 1:
                //Cadastrar exposição
                System.out.println("Informe o nome da exposição:");
                String nomeExpo = scanner.nextLine(); 
                nomeExpo = scanner.nextLine(); 

                System.out.println("Informe a data da exposição:");
                String dataExpo = scanner.nextLine();

                System.out.println("Informe o local da exposição:");
                String localExpo = scanner.nextLine();

                System.out.println("Informe o número de ingressos inteiros disponíveis:");
                int ingressosInteiraExpo = scanner.nextInt();

                System.out.println("Informe o número de ingressos meia entrada disponíveis:");
                int ingressosMeiaExpo = scanner.nextInt();

                System.out.println("Informe a faixa etária mínima:");
                int faixaEtariaMinimaExpo = scanner.nextInt();

                System.out.println("Informe a duração em dias da exposição:");
                int duracaoDiasExpo = scanner.nextInt();

                System.out.println("Informe o preço da exposição:");
                double precoEventoExpo = scanner.nextDouble();

                Exposicao exposicao = new Exposicao(nomeExpo, dataExpo, localExpo, ingressosInteiraExpo,
                        ingressosMeiaExpo, faixaEtariaMinimaExpo, duracaoDiasExpo, precoEventoExpo);
                evento = exposicao;
                break;
            case 2:
                //Cadastrar jogo
                System.out.println("Informe o nome do jogo:");
                String nomeJogo = scanner.nextLine();
                nomeJogo = scanner.nextLine();

                System.out.println("Informe a data do jogo:");
                String dataJogo = scanner.nextLine();

                System.out.println("Informe o local do jogo:");
                String localJogo = scanner.nextLine();

                System.out.println("Informe o esporte do jogo:");
                String esporteJogo = scanner.nextLine();

                System.out.println("Informe as equipes que participarão do jogo:");
                String equipesCompetindoJogo = scanner.nextLine();

                System.out.println("Informe o número de ingressos inteiros disponíveis:");
                int ingressosInteiraJogo = scanner.nextInt();

                System.out.println("Informe o número de ingressos meia entrada disponíveis:");
                int ingressosMeiaJogo = scanner.nextInt();

                System.out.println("Informe o preço do jogo:");
                double precoEventoJogo = scanner.nextDouble();

                Jogo jogo = new Jogo(nomeJogo, dataJogo, localJogo, ingressosInteiraJogo, ingressosMeiaJogo,
                        esporteJogo, equipesCompetindoJogo, precoEventoJogo);
                evento = jogo;
                break;
            case 3:
                //Cadastrar show
                System.out.println("Informe o nome do show:");
                String nomeShow = scanner.nextLine(); 
                nomeShow = scanner.nextLine(); 

                System.out.println("Informe a data do show:");
                String dataShow = scanner.nextLine();

                System.out.println("Informe o local do show:");
                String localShow = scanner.nextLine();

                System.out.println("Informe o número de ingressos inteiros disponíveis:");
                int ingressosInteiraShow = scanner.nextInt();

                System.out.println("Informe o número de ingressos meia entrada disponíveis:");
                int ingressosMeiaShow = scanner.nextInt();

                System.out.println("Informe o nome do artista:");
                String nomeArtistaShow = scanner.nextLine();

                System.out.println("Informe o genero de musica:");
                String generoMusicaShow = scanner.nextLine();

                System.out.println("Informe o preço do evento:");
                double precoEventoShow = scanner.nextDouble();              

                Show show = new Show(nomeShow, dataShow, localShow, ingressosInteiraShow, ingressosMeiaShow, nomeArtistaShow, generoMusicaShow, precoEventoShow);
                evento = show; 
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
        return evento;
    }

    private static Ingresso realizarVendaIngresso(Evento evento) {
        return null; 
    }

    private static void exibirInformacoesEvento(Evento evento) {
        if (evento != null) {
            System.out.println("\nInformações do Evento:");
                
            if (evento instanceof Exposicao) {
                Exposicao exposicao = (Exposicao) evento;
                System.out.println("\nTipo de evento: Exposição");
                System.out.println("Nome do evento: " + evento.getNome());
                System.out.println("Data do evento: " + evento.getData());
                System.out.println("Local do evento: " + evento.getLocal());
                System.out.println("Faixa Etária Mínima: " + exposicao.getFaixaEtariaMinima());
                System.out.println("Duração em dias: " + exposicao.getDuracaoDias());
                System.out.println("Preço da exposição: " + exposicao.getPrecoEvento());
            } else if (evento instanceof Jogo) {
                Jogo jogo = (Jogo) evento;
                System.out.println("\nTipo de evento: Jogo");
                System.out.println("Nome do evento: " + evento.getNome());
                System.out.println("Data do evento: " + evento.getData());
                System.out.println("Local do evento: " + evento.getLocal());
                System.out.println("Esporte: " + jogo.getEsporte());
                System.out.println("Equipes Competindo: " + jogo.getEquipesCompetindo());
                System.out.println("Preço do jogo: " + jogo.getPrecoInteira());
            } else if (evento instanceof Show) {
                Show show = (Show) evento;
                System.out.println("\nTipo de evento: Show");
                System.out.println("Nome do evento: " + evento.getNome());
                System.out.println("Data do evento: " + evento.getData());
                System.out.println("Local do evento: " + evento.getLocal());
                System.out.println("Nome do Artista: " + show.getNomeArtista());
                System.out.println("Gênero de Música: " + show.getGeneroMusica());
                System.out.println("Preço do show: " + show.getPrecoInteira());
            } else {
                System.out.println("\nNenhum evento foi registrado.");
            }
        } else {
            System.out.println("Este evento não existe.");
        }
        }        
    

    private static void exibirNumeroIngressosRestantes(Evento evento) {

    }

    private static void exibirInformacoesIngresso(Ingresso ingresso) {
    }
}
