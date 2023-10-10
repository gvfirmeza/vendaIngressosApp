package entidades.ingresso;

import entidades.evento.Evento;

public class IngressoMeia extends Ingresso {

    double preco;

    public IngressoMeia(Evento evento, double preco) {
        super(evento, TipoIngresso.MEIA);
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }
}
