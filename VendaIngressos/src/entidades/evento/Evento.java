package entidades.evento;

import entidades.ingresso.TipoIngresso;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Evento {
    private String nome;
    private LocalDate data;
    private String local;
    private int ingressosMeia;
    private int ingressosInteira;
    private double precoCheio;

    public Evento(String nome, LocalDate data, String local, int ingressosMeia, int ingressosInteira, double precoCheio) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.ingressosMeia = ingressosMeia;
        this.ingressosInteira = ingressosInteira;
        this.precoCheio = precoCheio;
    }

    public double getPrecoCheio() {
        return this.precoCheio;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIngressos() {
        return this.ingressosInteira + this.ingressosMeia;
    }

    public int getIngressosMeia() {
        return this.ingressosMeia;
    }

    public int getIngressosInteira() {
        return this.ingressosInteira;
    }

    public LocalDate getData() {
        return this.data;
    }

    public String getLocal() {
        return this.local;
    }

    public boolean isIngressoDisponivel(TipoIngresso tipo, int quantidade) {
        if (tipo.equals(TipoIngresso.MEIA)) {
            return quantidade <= this.ingressosMeia;
        }

        return quantidade <= this.ingressosInteira;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setLocal(String local) {
        this.local = local;
    }


    public void venderIngresso(TipoIngresso tipo, int quantidade) {
        if (this.isIngressoDisponivel(tipo, quantidade)) {
            if (tipo.equals(TipoIngresso.MEIA)) {
                this.ingressosMeia -= quantidade;
            } else {
                this.ingressosInteira -= quantidade;
            }
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "\n" + this.nome + " - " + this.data.format(formatter) + " - " + this.local;
    }
}
