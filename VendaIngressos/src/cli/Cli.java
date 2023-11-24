package cli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import dao.EventoDAO;
import entidades.evento.Evento;
import entidades.evento.Exposicao;
import entidades.evento.Jogo;
import entidades.evento.Show;
import entidades.ingresso.IngExposicao;
import entidades.ingresso.IngJogo;
import entidades.ingresso.IngShow;
import entidades.ingresso.Ingresso;
import entidades.ingresso.TipoIngresso;

public class Cli {
    private static EventoDAO eventoDAO = new EventoDAO();
    private static Scanner leitor = new Scanner(System.in);

    public static void executar() {

        carregarEventos(eventoDAO, "eventos.txt");

        Evento evento = null;
        int opcao;

        System.out.println("Seja bem-vindo ao programa de venda de ingressos de eventos!");

        while (true) {
            menu();
            opcao = leitor.nextInt();
            switch (opcao) {
                case 1:
                    evento = cadastrarEvento();
                    break;
                case 2:
                    exibirEvento();
                    break;
                case 3:
                    listarTodosEventos();
                    break;
                case 4:
                    removerEvento();
                    break;
                case 5:
                    venderIngresso();
                    break;
                case 6:
                    qtdIngresso();
                    break;
                case 7:
                    atualizarEvento();
                    break;
                case 0:
                    leitor.close();
                    System.out.println("Volte sempre!");
                    salvarEventos(eventoDAO, "eventos.txt");
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    public static void menu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Cadastrar Evento");
        System.out.println("2 - Exibir Evento");
        System.out.println("3 - Listar Todos os Eventos");
        System.out.println("4 - Remover Evento");
        System.out.println("5 - Vender Ingresso");
        System.out.println("6 - Ingressos Restantes");
        System.out.println("7 - Atualizar evento");
        System.out.println("0 - Sair");
    }

    public static Evento cadastrarEvento() {
        System.out.println("Escolha o tipo de evento:");
        System.out.println("1 - Exposição");
        System.out.println("2 - Jogo");
        System.out.println("3 - Show");
        int tipoEvento = leitor.nextInt();
        
        if (tipoEvento == 1 || tipoEvento == 2 || tipoEvento == 3) {
            System.out.print("Digite o nome do evento: ");
            leitor.nextLine();
            String nome = leitor.nextLine();
            System.out.print("Digite a data do evento (formato DD/MM/YYYY): ");
            String dataString = leitor.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataString, formatter);
            System.out.print("Digite o local do evento: ");
            leitor.nextLine();
            String local = leitor.nextLine();
            System.out.print("Digite a quantidade de ingressos meia: ");
            int ingressosMeia = leitor.nextInt();
            System.out.print("Digite a quantidade de ingressos inteira: ");
            int ingressosInteira = leitor.nextInt();
            System.out.print("Digite o preço cheio do ingresso: ");
            double precoCheio = leitor.nextDouble();

            Evento evento = null;

            switch (tipoEvento) {
                case 1:
                    System.out.print("Digite a faixa etária mínima da exposição: ");
                    int faixaEtariaMinima = leitor.nextInt();
                    System.out.print("Digite a duração em dias da exposição: ");
                    int duracaoDias = leitor.nextInt();
                    evento = new Exposicao(nome, data, local, ingressosMeia, ingressosInteira, precoCheio,
                            faixaEtariaMinima, duracaoDias);
                    break;
                case 2:
                    System.out.print("Digite o esporte do jogo: ");
                    String esporte = leitor.next();
                    System.out.print("Digite a equipe da casa: ");
                    leitor.nextLine();
                    String equipeCasa = leitor.nextLine();
                    System.out.print("Digite a equipe adversária: ");
                    String equipeAdversaria = leitor.nextLine();
                    evento = new Jogo(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, esporte, equipeCasa,
                            equipeAdversaria);
                    break;
                case 3:
                    System.out.print("Digite o nome do artista do show: ");
                    leitor.nextLine();
                    String artista = leitor.nextLine();
                    System.out.print("Digite o gênero musical do show: ");
                    String genero = leitor.nextLine();
                    evento = new Show(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, artista, genero);
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            if (evento != null) {
                String mensagem = eventoDAO.adicionarEvento(evento);
                System.out.println(mensagem);
            }
        } else {System.out.println("Opção inválida");}

        
        Evento evento = null;
        return evento;
    }

    public static void exibirEvento() {
        System.out.print("Digite o nome do evento: ");
        leitor.nextLine();
        String nome = leitor.nextLine();

        Evento eventoEncontrado = eventoDAO.buscarEventoPorNome(nome);

        if (eventoEncontrado != null) {
            System.out.println(eventoEncontrado);
        } else {
            System.out.println("Erro: Evento não encontrado.");
        }
    }

    public static void qtdIngresso() {
        System.out.print("Digite o nome do evento: ");
        leitor.nextLine();
        String nome = leitor.nextLine();
        String eventoEncontrado = eventoDAO.qtdIngresso(nome);
        System.out.println(eventoEncontrado);
    }

    public static void listarTodosEventos() {
        String resultado = eventoDAO.listarTodosEventos();
        System.out.println(resultado);
    }

    public static void removerEvento() {
        System.out.print("Digite o nome do evento: ");
        leitor.nextLine();
        String nome = leitor.nextLine();
        String resultado = eventoDAO.removerEvento(nome);
        System.out.println(resultado);
    }

    public static Ingresso venderIngresso() {
        System.out.print("Digite o nome do evento para o qual deseja vender ingressos: ");
        leitor.nextLine();
        String nomeEvento = leitor.nextLine();

        Evento evento = eventoDAO.buscarEventoPorNome(nomeEvento);

        if (evento == null) {
            System.out.println("Evento não encontrado!");
            return null;
        }

        TipoIngresso tipoIngresso = obterTipoIngresso();

        System.out.print("Informe quantos ingressos você deseja: ");
        int quantidade = leitor.nextInt();

        if (!evento.isIngressoDisponivel(tipoIngresso, quantidade)) {
            System.out.println("Não há ingressos disponíveis desse tipo!");
            return null;
        }

        Ingresso ingresso;

        if (evento instanceof Jogo) {
            int percentual;

            System.out.print("Informe o percentual do desconto de sócio torcedor: ");
            percentual = leitor.nextInt();
            ingresso = new IngJogo(evento, tipoIngresso, percentual);
        } else if (evento instanceof Show) {
            String localizacao;

            System.out.print("Informe a localização do ingresso (pista ou camarote): ");
            localizacao = leitor.next();

            if (!(localizacao.equals("pista") || localizacao.equals("camarote"))) {
                System.out.println("Localização inválida!");
                return null;
            }
            ingresso = new IngShow(evento, tipoIngresso, localizacao);
        } else {
            String desconto;

            System.out.print("Informe se possui desconto social (s/n): ");
            desconto = leitor.next();

            ingresso = new IngExposicao(evento, tipoIngresso, desconto.equals("s"));
        }

        evento.venderIngresso(tipoIngresso, quantidade);
        System.out.println("Ingresso vendido com sucesso!");
        return ingresso;
    }

    private static TipoIngresso obterTipoIngresso() {
        while (true) {
        System.out.print("Informe o tipo do ingresso (meia ou inteira): ");
        String tipo = leitor.next().toLowerCase();
        if (tipo.equals("meia")) {
            return TipoIngresso.MEIA;
        } else if (tipo.equals("inteira")) {
            return TipoIngresso.INTEIRA;
        } else { System.out.println("Tipo de ingresso inválido"); }
    }
    }

    public static void atualizarEvento() {
        System.out.println("Digite o nome do evento que deseja atualizar: ");
        leitor.nextLine();
        String nome = leitor.nextLine();

        Evento evento = eventoDAO.buscarEventoPorNome(nome);

        if (evento != null) {
            System.out.println("Digite a nova data do evento (formato DD/MM/YYYY)");
            String novaDataString = leitor.next();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate novaData = LocalDate.parse(novaDataString, formatter);

            System.out.println("Digite o novo local do evento: ");
            leitor.nextLine();
            String novoLocal = leitor.nextLine();

            evento.setData(novaData);
            evento.setLocal(novoLocal);

            System.out.println("Evento atualizado com sucesso!");
        } else {
            System.out.println("Erro: Evento não encontrado.");
        }
    }

    public static void carregarEventos(EventoDAO eventoDAO, String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String tipoEvento = values[0];
                String nome = values[1];
                LocalDate data = LocalDate.parse(values[2]);
                String local = values[3];
                int ingressosMeia = Integer.parseInt(values[4]);
                int ingressosInteira = Integer.parseInt(values[5]);
                double precoCheio = Double.parseDouble(values[6]);

                switch (tipoEvento) {
                    case "Exposicao":
                        int faixaEtariaMinima = Integer.parseInt(values[7]);
                        int duracaoDias = Integer.parseInt(values[8]);
                        eventoDAO.adicionarEvento(new Exposicao(nome, data, local, ingressosMeia, ingressosInteira,
                                precoCheio, faixaEtariaMinima, duracaoDias));
                        break;
                    case "Jogo":
                        String esporte = values[7];
                        String equipeCasa = values[8];
                        String equipeAdversaria = values[9];
                        eventoDAO.adicionarEvento(new Jogo(nome, data, local, ingressosMeia, ingressosInteira,
                                precoCheio, esporte, equipeCasa, equipeAdversaria));
                        break;
                    case "Show":
                        String artista = values[7];
                        String genero = values[8];
                        eventoDAO.adicionarEvento(new Show(nome, data, local, ingressosMeia, ingressosInteira,
                                precoCheio, artista, genero));
                        break;
                    default:
                        System.out.println("Tipo de evento desconhecido: " + tipoEvento);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void salvarEventos(EventoDAO eventoDAO, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Evento evento : eventoDAO.getEventos().values()) {
                bw.write(evento.getClass().getSimpleName() + ",");
                bw.write(evento.getNome() + ",");
                bw.write(evento.getData().toString() + ",");
                bw.write(evento.getLocal() + ",");
                bw.write(evento.getIngressosMeia() + ",");
                bw.write(evento.getIngressosInteira() + ",");
                bw.write(evento.getPrecoCheio() + ",");

                if (evento instanceof Exposicao) {
                    Exposicao exposicao = (Exposicao) evento;
                    bw.write(exposicao.getFaixaEtariaMinima() + ",");
                    bw.write(exposicao.getDuracaoDias() + ",");
                } else if (evento instanceof Jogo) {
                    Jogo jogo = (Jogo) evento;
                    bw.write(jogo.getEsporte() + ",");
                    bw.write(jogo.getEquipeCasa() + ",");
                    bw.write(jogo.getEquipeAdversaria() + ",");
                } else if (evento instanceof Show) {
                    Show show = (Show) evento;
                    bw.write(show.getArtista() + ",");
                    bw.write(show.getGenero() + ",");
                }

                bw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}