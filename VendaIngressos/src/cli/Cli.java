package cli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import dao.EventoDAO;
import entidades.evento.Evento;
import entidades.evento.Exposicao;
import entidades.evento.Jogo;
import entidades.evento.Show;

public class Cli {
    private static EventoDAO eventoDAO = new EventoDAO();
    private static Scanner leitor = new Scanner(System.in);

    public static void executar() {
        
        carregarEventos(eventoDAO, "eventos.txt"); // Carrega os eventos no início
        
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
                case 11:
                    venderIngresso(evento);
                    break;
                default:
                    leitor.close();
                    System.out.println("Volte sempre!");
                    salvarEventos(eventoDAO, "eventos.txt");
                    return;
            }
        }
    }

    public static void menu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Cadastrar Evento");
        System.out.println("2 - Exibir Evento");
        System.out.println("3 - Listar Todos os Eventos");
        System.out.println("11 - Vender Ingresso");
        System.out.println("0 - Sair");
    }

    public static Evento cadastrarEvento() {
        System.out.println("Escolha o tipo de evento:");
        System.out.println("1 - Exposição");
        System.out.println("2 - Jogo");
        System.out.println("3 - Show");
        int tipoEvento = leitor.nextInt();

        System.out.print("Digite o nome do evento: ");
        String nome = leitor.next();
        System.out.print("Digite a data do evento (formato YYYY-MM-DD): ");
        String dataString = leitor.next();
        LocalDate data = LocalDate.parse(dataString);
        System.out.print("Digite o local do evento: ");
        String local = leitor.next();
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
                evento = new Exposicao(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, faixaEtariaMinima, duracaoDias);
                break;
            case 2:
                System.out.print("Digite o esporte do jogo: ");
                String esporte = leitor.next();
                System.out.print("Digite a equipe da casa: ");
                String equipeCasa = leitor.next();
                System.out.print("Digite a equipe adversária: ");
                String equipeAdversaria = leitor.next();
                evento = new Jogo(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, esporte, equipeCasa, equipeAdversaria);
                break;
            case 3:
                System.out.print("Digite o nome do artista do show: ");
                String artista = leitor.next();
                System.out.print("Digite o gênero musical do show: ");
                String genero = leitor.next();
                evento = new Show(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, artista, genero);
                break;
            default:
                System.out.println("Opção inválida.");
        }

        if (evento != null) {
            String mensagem = eventoDAO.adicionarEvento(evento);
            System.out.println(mensagem);
        }

        return evento;
    }

    public static void exibirEvento() {
        System.out.print("Digite o nome do evento: ");
        String nome = leitor.next();

        Evento eventoEncontrado = eventoDAO.buscarEventoPorNome(nome);

        if (eventoEncontrado != null) {
            System.out.println(eventoEncontrado);
        } else {
            System.out.println("Erro: Evento não encontrado.");
        }
    }

    public static void listarTodosEventos() {
        String resultado = eventoDAO.listarTodosEventos();
        System.out.println(resultado);
    }

    public static void venderIngresso(Evento evento) {
        // Implemente a lógica para vender um ingresso
        // ...
    }

    public static void carregarEventos(EventoDAO eventoDAO, String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String tipoEvento = values[0];
                String nome = values[1];
                LocalDate data = LocalDate.parse(values[2]); // Assumindo que a data está no formato padrão ISO
                String local = values[3];
                int ingressosMeia = Integer.parseInt(values[4]);
                int ingressosInteira = Integer.parseInt(values[5]);
                double precoCheio = Double.parseDouble(values[6]);

                switch (tipoEvento) {
                    case "Exposicao":
                        int faixaEtariaMinima = Integer.parseInt(values[7]);
                        int duracaoDias = Integer.parseInt(values[8]);
                        eventoDAO.adicionarEvento(new Exposicao(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, faixaEtariaMinima, duracaoDias));
                        break;
                    case "Jogo":
                        String esporte = values[7];
                        String equipeCasa = values[8];
                        String equipeAdversaria = values[9];
                        eventoDAO.adicionarEvento(new Jogo(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, esporte, equipeCasa, equipeAdversaria));
                        break;
                    case "Show":
                        String artista = values[7];
                        String genero = values[8];
                        eventoDAO.adicionarEvento(new Show(nome, data, local, ingressosMeia, ingressosInteira, precoCheio, artista, genero));
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

