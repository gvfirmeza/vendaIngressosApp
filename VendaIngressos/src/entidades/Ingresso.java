package entidades;

import entidades.evento.Evento;

public abstract class Ingresso {
    
    private Evento evento;
    private double precoCheio;
    private TipoIngresso tipo;

     public Ingresso(Evento evento, double precoCheio, TipoIngresso tipo) {
        this.evento = evento;
        this.precoCheio = precoCheio;
        this.tipo = tipo;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public double getPrecoCheio() {
        return precoCheio;
    }

    public void setPrecoCheio(double precoCheio) {
        this.precoCheio = precoCheio;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        if (tipo == TipoIngresso.INTEIRA) {
            return precoCheio;
        } else {
            return precoCheio / 2.0;
        }
    }
}
