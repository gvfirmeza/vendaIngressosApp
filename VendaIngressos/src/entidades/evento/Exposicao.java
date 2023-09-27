package entidades.evento;

public class Exposicao extends Evento {
    private int faixaEtariaMinima;
    private int duracaoDias;
    private double precoEvento;
    public static boolean descontoSocial = false;

    public Exposicao(String nome, String data, String local, int ingressosInteira, int ingressosMeia, int faixaEtariaMinima, int duracaoDias, double precoEvento) {
        super(nome, data, local, ingressosInteira, ingressosMeia);
        this.faixaEtariaMinima = faixaEtariaMinima;
        this.duracaoDias = duracaoDias;
        this.precoEvento = precoEvento;
    }

    public int getFaixaEtariaMinima() {
        return faixaEtariaMinima;
    }

    public void setFaixaEtariaMinima(int faixaEtariaMinima) {
        this.faixaEtariaMinima = faixaEtariaMinima;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }

    public void setDescontoSocial(boolean descontoSocial) {
        this.descontoSocial = descontoSocial;
    }

    public double getPrecoEvento() {
        return precoEvento;
    }

    public void setPrecoEvento(double precoEvento) {
        this.precoEvento = precoEvento;
    }

    @Override
    public double getPrecoInteira() {
        if (descontoSocial) {
            return 0.0;
        } else {
            return precoEvento;
        }
    }

    @Override
    public double getPrecoMeia() {
        if (descontoSocial) {
            return 0.0;
        } else {
            return precoEvento / 2.0;
        }
    }
}

