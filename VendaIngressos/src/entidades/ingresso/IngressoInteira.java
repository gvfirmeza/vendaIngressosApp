package entidades.ingresso;

import entidades.evento.Evento;

public class IngressoInteira extends Ingresso {

    double preco;

    public IngressoInteira(Evento evento, double preco) {
        super(evento, TipoIngresso.INTEIRA);
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
