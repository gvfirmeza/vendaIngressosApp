package entidades.evento;

import java.time.LocalDate;

public class Exposicao extends Evento {
    private int faixaEtariaMinima;
    private int duracaoDias;

    public Exposicao(String nome, LocalDate data, String local, int ingressosMeia, int ingressosInteira, double precoCheio, int faixaEtariaMinima, int duracaoDias) {
        super(nome, data, local, ingressosMeia, ingressosInteira, precoCheio);
        this.faixaEtariaMinima = faixaEtariaMinima;
        this.duracaoDias = duracaoDias;
    }

    @Override
    public String toString() {
        return super.toString() + "\nIdade mínima: " + this.faixaEtariaMinima + "\nDuração: " + this.duracaoDias + " dias";
    }
}
