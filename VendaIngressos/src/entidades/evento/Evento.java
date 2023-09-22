package entidades.evento;

import entidades.TipoIngresso;

public abstract class Evento {
    private String nome;
    private String data;
    private String local;
    private int ingressosInteira;
    private int ingressosMeia;

    public Evento(String nome, String data, String local, int ingressosInteira, int ingressosMeia) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.ingressosInteira = ingressosInteira;
        this.ingressosMeia = ingressosMeia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getIngressosInteira() {
        return ingressosInteira;
    }

    public void setIngressosInteira(int ingressosInteira) {
        this.ingressosInteira = ingressosInteira;
    }

    public int getIngressosMeia() {
        return ingressosMeia;
    }

    public void setIngressosMeia(int ingressosMeia) {
        this.ingressosMeia = ingressosMeia;
    }

    public boolean isIngressoDisponivel(TipoIngresso tipo, int quantidade) {
        if (tipo == TipoIngresso.INTEIRA) {
            return ingressosInteira >= quantidade;
        } else {
            return ingressosMeia >= quantidade;
        }
    }

    public double venderIngresso(TipoIngresso tipo, int quantidade) {
        double valorTotal = 0.0;
        if (isIngressoDisponivel(tipo, quantidade)) {
            if (tipo == TipoIngresso.INTEIRA) {
                ingressosInteira -= quantidade;
                valorTotal = quantidade * getPrecoInteira();
            } else {
                ingressosMeia -= quantidade;
                valorTotal = quantidade * getPrecoMeia();
            }
        }
        return valorTotal;
    }

    // Métodos abstratos para obter os preços de ingressos inteiros e meia-entrada
    public abstract double getPrecoInteira();

    public abstract double getPrecoMeia();
}
