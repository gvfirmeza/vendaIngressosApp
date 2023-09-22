package entidades.evento;

public class Jogo extends Evento {
    private String esporte;
    private String equipesCompetindo;
    private double precoTotal;
    private double descontoTorcedor = 0.15;

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

    public double getPrecoTorcedor() {
        precoTotal = precoTotal - (precoTotal * descontoTorcedor);
        return  precoTotal;
    }

    public double getPrecoTorcedorMeia() {
        precoTotal = precoTotal - (precoTotal * descontoTorcedor);
        return precoTotal / 2.0;
    }

    @Override
    public double getPrecoInteira() {
        return precoTotal;
    }

    @Override
    public double getPrecoMeia() {
        return precoTotal / 2.0;
    }
}
