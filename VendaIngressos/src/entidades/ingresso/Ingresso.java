package entidades.ingresso;

import entidades.evento.Evento;

public abstract class Ingresso {
    
    private Evento evento;
    private TipoIngresso tipo;

     public Ingresso(Evento evento, TipoIngresso tipo) {
        this.evento = evento;
        this.tipo = tipo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }

    public abstract double getPreco();
}
