package entidades.evento;

public class Exposicao extends Evento {
    private int faixaEtariaMinima;
    private int duracaoDias;
    private double precoTotal;
    public static boolean descontoSocial = false;
    public static boolean tipoIngressoComprado = false;

    public Exposicao(String nome, String data, String local, int ingressosInteira, int ingressosMeia, int faixaEtariaMinima, int duracaoDias, double precoTotal) {
        super(nome, data, local, ingressosInteira, ingressosMeia);
        this.faixaEtariaMinima = faixaEtariaMinima;
        this.duracaoDias = duracaoDias;
        this.precoTotal = precoTotal;
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

    public double getPrecoEvento() {
        return precoTotal;
    }

    public void setPrecoEvento(double precoEvento) {
        this.precoTotal = precoEvento;
    }

    @Override
    public double getPrecoInteira() {
        if (descontoSocial) {
            return 0.0;
        } else {
            return precoTotal;
        }
    }

    @Override
    public double getPrecoMeia() {
        if (descontoSocial) {
            return 0.0;
        } else {
            return precoTotal / 2.0;
        }
    }

    @Override
    public double getPrecoPago() {
        if (tipoIngressoComprado) {
        return getPrecoInteira();
        } else {
            return getPrecoMeia();
        }
    }
}
