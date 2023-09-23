package entidades.evento;

// Subclasse Shows
public class Show extends Evento {
    private String nomeArtista;
    private String generoMusica;
    private boolean pista;
    private double precoTotal;

    public Show(String nome, String data, String local, int ingressosInteira, int ingressosMeia, String nomeArtista, String generoMusica, boolean pista, double precoTotal) {
        super(nome, data, local, ingressosInteira, ingressosMeia);
        this.nomeArtista = nomeArtista;
        this.generoMusica = generoMusica;
        this.pista = pista;
        this.precoTotal = precoTotal;
    }

    public String getNomeArtista() {
        return this.nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getGeneroMusica() {
        return this.generoMusica;
    }

    public void setGeneroMusica(String generoMusica) {
        this.generoMusica = generoMusica;
    }

    public boolean getPista() {
        return this.pista;
    }

    public void setPista(boolean pista) {
        this.pista = pista;
    }

    public boolean isPista() {
        return this.pista;
    }

    @Override
    public double getPrecoInteira() {
            return precoTotal;
    }

    @Override
    public double getPrecoMeia() {
        return precoTotal/2;
    }
}
