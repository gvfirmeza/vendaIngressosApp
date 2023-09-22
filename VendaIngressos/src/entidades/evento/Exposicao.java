package entidades.evento;

public class Exposicao extends Evento {
    private int faixaEtariaMinima;
    private int duracaoDias;
    private boolean descontoSocial;

    public Exposicao(String nome, String data, String local, int ingressosInteira, int ingressosMeia, int faixaEtariaMinima, int duracaoDias, boolean descontoSocial) {
        super(nome, data, local, ingressosInteira, ingressosMeia);
        this.faixaEtariaMinima = faixaEtariaMinima;
        this.duracaoDias = duracaoDias;
        this.descontoSocial = descontoSocial;
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

    public boolean isDescontoSocial() {
        return descontoSocial;
    }

    public void setDescontoSocial(boolean descontoSocial) {
        this.descontoSocial = descontoSocial;
    }

    @Override
    public double getPrecoInteira() {
        if (descontoSocial) {
            return 0.0; // Ingresso com desconto social é gratuito
        } else {
            return 20.0; // Valor de exemplo para inteira
        }
    }

    @Override
    public double getPrecoMeia() {
        if (descontoSocial) {
            return 0.0; // Ingresso com desconto social é gratuito
        } else {
            return 10.0; // Valor de exemplo para meia-entrada
        }
    }
}
