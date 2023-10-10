package entidades.evento;

// Subclasse Shows
public class Show extends Evento {
    private String nomeArtista;
    private String generoMusica;
    private double precoTotal;
    public static boolean pista;
    public static boolean tipoIngressoComprado = false;

    public Show(String nome, String data, String local, int ingressosInteira, int ingressosMeia, String nomeArtista, String generoMusica, double precoTotal) {
        super(nome, data, local, ingressosInteira, ingressosMeia);
        this.nomeArtista = nomeArtista;
        this.generoMusica = generoMusica;
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

    @Override
    public double getPrecoInteira() {
        return precoTotal;
    }

    @Override
    public double getPrecoMeia() {
        return precoTotal/2;
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
