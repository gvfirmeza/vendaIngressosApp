package entidades.evento;

import java.time.LocalDate;

public class Show extends Evento {
    private String artista, genero;

    public Show(String nome, LocalDate data, String local, int ingressosMeia, int ingressosInteira, double precoCheio, String artista, String genero) {
        super(nome, data, local, ingressosMeia, ingressosInteira, precoCheio);
        this.artista = artista;
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
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
        return super.toString() + "\n" + this.artista + " - " + this.genero;
    }
}
