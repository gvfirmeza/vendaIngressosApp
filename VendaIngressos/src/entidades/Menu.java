package entidades;

import java.util.Scanner;

import entidades.evento.Evento;
import entidades.evento.Exposicao;
import entidades.evento.Jogo;
import entidades.evento.Show;
import entidades.ingresso.Ingresso;
import entidades.ingresso.IngressoInteira;
import entidades.ingresso.IngressoMeia;
import entidades.ingresso.TipoIngresso;

public class Menu {
    private static Ingresso ultimoIngressoVendido = null;

    public static void metodoInterface() {
        Scanner scanner = new Scanner(System.in);
        Evento evento = null;

        while (true) {
            System.out.println("\nMenu de Opções:");
            System.out.println("1. Cadastrar um novo evento");
            System.out.println("2. Realizar a compra de um ingresso");
            System.out.println("3. Exibir informações do evento");
            System.out.println("4. Exibir o número de ingressos restantes");
            System.out.println("5. Exibir informações do último ingresso vendido");
            System.out.println("6. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    evento = cadastrarNovoEvento();
                    break;
                case 2:
                    if (evento != null) {
                        ultimoIngressoVendido = realizarVendaIngresso(evento);
                    } else {
                        System.out.println("Por favor, cadastre um evento primeiro.");
                    }
                    break;
                case 3:
                    if (evento != null) {
                        exibirInformacoesEvento(evento);
                    } else {
                        System.out.println("Nenhum evento cadastrado.");
                    }
                    break;
                case 4:
                    if (evento != null) {
                        exibirNumeroIngressosRestantes(evento);
                    } else {
                        System.out.println("Nenhum evento cadastrado.");
                    }
                    break;
                case 5:
                    if (ultimoIngressoVendido != null) {
                        exibirInformacoesIngresso(ultimoIngressoVendido);
                    } else {
                        System.out.println("Nenhum ingresso foi vendido ainda.");
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
                // Cadastrar exposição
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
                // Cadastrar jogo
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
                // Cadastrar show
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
                scanner.nextLine();
                String nomeArtistaShow = scanner.nextLine();

                System.out.println("Informe o genero de musica:");
                String generoMusicaShow = scanner.nextLine();

                System.out.println("Informe o preço do evento:");
                double precoEventoShow = scanner.nextDouble();

                Show show = new Show(nomeShow, dataShow, localShow, ingressosInteiraShow, ingressosMeiaShow,
                        nomeArtistaShow, generoMusicaShow, precoEventoShow);
                evento = show;
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
        return evento;
    }

    private static Ingresso realizarVendaIngresso(Evento evento) {
        boolean sair = false;
        TipoIngresso tipoIngresso = null;
        int totalMeias = 0;
        int totalInteiras = 0;
        double totalPreco = 0;

        while (sair == false) {
            System.out.println("\nQual Ingresso Deseja Comprar?:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Ingresso Inteira");
            System.out.println("2. Ingresso Meia");
            System.out.println("3. Sair");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:                   
                    if (evento.getIngressosInteira() > 0) {
                        Exposicao.tipoIngressoComprado = true;
                        tipoIngresso = TipoIngresso.INTEIRA;
                        totalInteiras = totalInteiras + 1;                       
                        evento.venderIngressoInteira();
                        if (evento instanceof Exposicao) {
                            System.out.println("\nPossui Desconto Social?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");
                            int desconto = scanner.nextInt();
                            if (desconto == 1) {
                                Exposicao.descontoSocial = true;
                            } else {
                                Exposicao.descontoSocial = false;
                            }
                        }
                        if (evento instanceof Jogo) {
                            Jogo.tipoIngressoComprado = true;
                            System.out.println("\nPossui Desconto Torcedor?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");
                            int desconto = scanner.nextInt();
                            if (desconto == 1) {
                                Jogo.torcedor = true;
                            } else {
                                Jogo.torcedor = false;
                            }
                        }
                        if (evento instanceof Show) {
                            Show.tipoIngressoComprado = true;
                            System.out.println("\nO Ingresso é Pista?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");
                            int desconto = scanner.nextInt();
                            if (desconto == 1) {
                                Show.pista = true;
                            } else {
                                Show.pista = false;
                            }
                        }

                        IngressoInteira ingresso = new IngressoInteira(evento, evento.getPrecoInteira());

                        System.out.println("O preço final foi de: R$ " + evento.getPrecoInteira());
                        totalPreco = totalPreco + evento.getPrecoInteira();

                        ultimoIngressoVendido = ingresso;
                        return ultimoIngressoVendido;
                    }
                    break;

                case 2:                   
                    if (evento.getIngressosMeia() > 0) {
                        Exposicao.tipoIngressoComprado = false;
                        tipoIngresso = TipoIngresso.MEIA;
                        totalMeias = totalMeias + 1;                    
                        evento.venderIngressoMeia();
                        if (evento instanceof Exposicao) {
                            System.out.println("\nPossui Desconto Social?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");
                            int desconto = scanner.nextInt();
                            if (desconto == 1) {
                                Exposicao.descontoSocial = true;
                            } else {
                                Exposicao.descontoSocial = false;
                            }
                        }
                        if (evento instanceof Jogo) {
                            Jogo.tipoIngressoComprado = false;
                            System.out.println("\nPossui Desconto Torcedor?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");
                            int desconto = scanner.nextInt();
                            if (desconto == 1) {
                                Jogo.torcedor = true;
                            } else {
                                Jogo.torcedor = false;
                            }
                        }
                        if (evento instanceof Show) {
                            Show.tipoIngressoComprado = false;
                            System.out.println("\nO Ingresso é Pista?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");
                            int desconto = scanner.nextInt();
                            if (desconto == 1) {
                                Show.pista = true;
                            } else {
                                Show.pista = false;
                            }
                        }
                        IngressoMeia ingresso = new IngressoMeia(evento, evento.getPrecoInteira());

                        System.out.println("O preço final foi de: R$ " + evento.getPrecoMeia());
                        totalPreco = totalPreco + evento.getPrecoMeia();

                        ultimoIngressoVendido = ingresso;
                        return ultimoIngressoVendido;
                    } else {
                        System.out.println("Esse ingresso foi esgotado.");
                    }
                    break;
                case 3:
                    System.out.println("\nO total de ingresso comprados foram: ");
                    System.out.println(totalMeias + " meias e " + totalInteiras + " inteiras. Totalizando " + totalPreco
                            + " reais.");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
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
        if (evento != null) {
            System.out.println("\nNúmero de Ingressos Restantes:");

            if (evento instanceof Exposicao) {
                Exposicao exposicao = (Exposicao) evento;
                int ingressosInteiraRestantes = exposicao.getIngressosInteira();
                ;
                int ingressosMeiaRestantes = exposicao.getIngressosMeia();
                ;

                System.out.println("Ingressos Inteiros Restantes: " + ingressosInteiraRestantes);
                System.out.println("Ingressos Meia Restantes: " + ingressosMeiaRestantes);
            } else if (evento instanceof Jogo) {
                Jogo jogo = (Jogo) evento;
                int ingressosInteiraRestantes = jogo.getIngressosInteira();
                int ingressosMeiaRestantes = jogo.getIngressosMeia();

                System.out.println("Ingressos Inteiros Restantes: " + ingressosInteiraRestantes);
                System.out.println("Ingressos Meia Restantes: " + ingressosMeiaRestantes);
            } else if (evento instanceof Show) {
                Show show = (Show) evento;
                int ingressosInteiraRestantes = show.getIngressosInteira();
                int ingressosMeiaRestantes = show.getIngressosMeia();

                System.out.println("Ingressos Inteiros Restantes: " + ingressosInteiraRestantes);
                System.out.println("Ingressos Meia Restantes: " + ingressosMeiaRestantes);
            } else {
                System.out.println("Nenhum evento deste tipo foi registrado.");
            }
        } else {
            System.out.println("Este evento não existe.");
        }
    }

    private static void exibirInformacoesIngresso(Ingresso ingresso) {
        Evento evento = ingresso.getEvento();
        if (evento != null) {
            System.out.println("Informações do Ingresso:");
            System.out.println("Tipo de Ingresso: " + ingresso.getTipo());
            System.out.println("Preço do Ingresso: R$ " + evento.getPrecoPago());
            System.out.println("Evento associado ao Ingresso:");
            System.out.println("Nome do evento: " + evento.getNome());
            System.out.println("Data do evento: " + evento.getData());
            System.out.println("Local do evento: " + evento.getLocal());
        } else {
            System.out.println("O ingresso não está associado a nenhum evento.");
        }
    }

}
