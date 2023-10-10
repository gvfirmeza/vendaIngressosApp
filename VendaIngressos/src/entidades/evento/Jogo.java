package entidades.evento;

public class Jogo extends Evento {
    private String esporte;
    private String equipesCompetindo;
    private double precoTotal;
    public static boolean torcedor;
    public static boolean tipoIngressoComprado = false;

    public Jogo(String nome, String data, String local, int ingressosInteira, int ingressosMeia, String esporte, String equipesCompetindo, double precoTotal) {
        super(nome, data, local, ingressosInteira, ingressosMeia);
        this.esporte = esporte;
        this.equipesCompetindo = equipesCompetindo;
        this.precoTotal = precoTotal;
    }

    public String getEsporte() {
        return esporte;
    }

    public void setEsporte(String esporte) {
        this.esporte = esporte;
    }

    public String getEquipesCompetindo() {
        return equipesCompetindo;
    }

    public void setEquipesCompetindo(String equipesCompetindo) {
        this.equipesCompetindo = equipesCompetindo;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    @Override
    public double getPrecoInteira() {
        if (torcedor == true){
            double precoInt = precoTotal * 0.85;
            return precoInt;
        } else {
            return precoTotal;
        }
    }

    @Override
    public double getPrecoMeia() {
        if (torcedor == true){
            double precoMeia = precoTotal/2;
            precoMeia = precoMeia * 0.85;
            return precoMeia;
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
