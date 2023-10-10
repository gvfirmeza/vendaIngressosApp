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
            precoTotal = precoTotal * 0.85;
            return precoTotal;
        } else {
            return precoTotal;
        }
    }

    @Override
    public double getPrecoMeia() {
        if (torcedor == true){
            precoTotal = precoTotal/2;
            precoTotal = precoTotal * 0.85;
            return precoTotal;
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
