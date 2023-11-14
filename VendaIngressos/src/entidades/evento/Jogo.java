package entidades.evento;

import java.time.LocalDate;

public class Jogo extends Evento {
    private String esporte, equipeCasa, equipeAdversaria;

    public Jogo(String nome, LocalDate data, String local, int ingressosMeia, int ingressosInteira, double precoCheio, String esporte, String equipeCasa, String equipeAdversaria) {
        super(nome, data, local, ingressosMeia, ingressosInteira, precoCheio);
        this.esporte = esporte;
        this.equipeAdversaria = equipeAdversaria;
        this.equipeCasa = equipeCasa;
    }

    public String getEsporte() {
        return esporte;
    }

    public String getEquipeCasa() {
        return equipeCasa;
    }

    public String getEquipeAdversaria() {
        return equipeAdversaria;
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
        return super.toString() + "\n" + this.esporte + " - " + this.equipeCasa + " x " + this.equipeAdversaria;
    }
}
