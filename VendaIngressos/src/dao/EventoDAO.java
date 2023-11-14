package dao;

import java.util.HashMap;
import java.util.Map;

import entidades.evento.Evento;
import entidades.evento.Exposicao;
import entidades.evento.Jogo;
import entidades.evento.Show;

public class EventoDAO {
    private Map<String, Evento> eventos;

    public Map<String, Evento> getEventos() {
        return eventos;
    }

    public EventoDAO() {
        this.eventos = new HashMap<>();
    }

    public String adicionarEvento(Evento evento) {
        String nome = evento.getNome();
        if (eventos.containsKey(nome)) {
            return "Erro: O evento já está cadastrado. Não foi possível adicionar o evento.";
        } else {
            eventos.put(nome, evento);
            return "Evento adicionado com sucesso!";
        }
    }

    public String removerEvento(String nome) {
        if (eventos.containsKey(nome)) {
            eventos.remove(nome);
            return "Evento removido com sucesso!";
        } else {
            return "Erro: Não foi encontrado nenhum evento com esse nome.";
        }
    }

    public Evento buscarEventoPorNome(String nome) {
        Evento evento = eventos.get(nome);
        if (evento == null) {
            return null;
        }
        return evento;
    }

    public String listarTodosEventos() {
        if (eventos.isEmpty()) {
            return "Erro: Não há eventos cadastrados.";
        } else {
            StringBuilder result = new StringBuilder("\nTodos os eventos:\n");
            for (Evento evento : eventos.values()) {
                result.append(evento).append("\n");
            }
            return result.toString();
        }
    }

    public String qtdIngresso(String nome) {
        Evento evento = eventos.get(nome);

        if (evento == null) {
            return "Erro: Evento não encontrado.";
        } else if (evento instanceof Exposicao) {
            Exposicao exposicao = (Exposicao) evento;
            return "Ingressos Meia Restantes: " + exposicao.getIngressosMeiaRestantes() + "\n"
                    + "Ingressos Inteira Restantes: " + exposicao.getIngressosInteiraRestantes();
        } else if (evento instanceof Jogo) {
            Jogo jogo = (Jogo) evento;
            return "Ingressos Meia Restantes: " + jogo.getIngressosMeiaRestantes() + "\n"
                    + "Ingressos Inteira Restantes: " + jogo.getIngressosInteiraRestantes();
        } else if (evento instanceof Show) {
            Show show = (Show) evento;
            return "Ingressos Meia Restantes: " + show.getIngressosMeiaRestantes() + "\n"
                    + "Ingressos Inteira Restantes: " + show.getIngressosInteiraRestantes();
        }

        return "Erro: Tipo de evento não reconhecido";
    }
}
