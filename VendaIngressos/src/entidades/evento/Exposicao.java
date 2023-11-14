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

    public int getFaixaEtariaMinima() {
        return faixaEtariaMinima;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public int getIngressosVendidosMeia() {
        return 0;
    }
    
    public int getIngressosVendidosInteira() {
        return 0;
    }

    public int getIngressosMeiaRestantes() {
        return getIngressosMeia() - getIngressosVendidosMeia();
    }

    public int getIngressosInteiraRestantes() {
        return getIngressosInteira() - getIngressosVendidosInteira();
    }

    @Override
    public String toString() {
        return super.toString() + "\nIdade mínima: " + this.faixaEtariaMinima + "\nDuração: " + this.duracaoDias + " dias";
    }
}
