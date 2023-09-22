package entidades.evento;

public class Jogo extends Evento {
    public class Jogo extends Evento {
        private String esporte;
        private String equipesCompetindo;
        private double percentualDescontoTorcedor;
    
        public Jogo(String nome, String data, String local, int ingressosInteira, int ingressosMeia, String esporte, String equipesCompetindo, double percentualDescontoTorcedor) {
            super(nome, data, local, ingressosInteira, ingressosMeia);
            this.esporte = esporte;
            this.equipesCompetindo = equipesCompetindo;
            this.percentualDescontoTorcedor = percentualDescontoTorcedor;
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
    
        public double getPercentualDescontoTorcedor() {
            return percentualDescontoTorcedor;
        }
    
        public void setPercentualDescontoTorcedor(double percentualDescontoTorcedor) {
            this.percentualDescontoTorcedor = percentualDescontoTorcedor;
        }
    
        @Override
        public double getPrecoInteira() {
            return 100.0; // Valor de exemplo para inteira
        }
    
        @Override
        public double getPrecoMeia() {
            return 50.0; // Valor de exemplo para meia-entrada
        }
    }
    
}
