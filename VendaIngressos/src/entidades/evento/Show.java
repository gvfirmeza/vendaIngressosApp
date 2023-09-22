package entidades.evento;

import entidades.TipoIngresso;

// Subclasse Shows
class Shows extends Evento {
    private int faixaEtariaMinima;
    private int duracaoEmDias;

    // Construtor
    public Shows(String nome, String data, String local, int ingressosInteira, int ingressosMeia, int faixaEtariaMinima, int duracaoEmDias) {
        super(nome, data, local, ingressosInteira, ingressosMeia);
        this.faixaEtariaMinima = faixaEtariaMinima;
        this.duracaoEmDias = duracaoEmDias;
    }

    // Getters e Setters
    public int getFaixaEtariaMinima() {
        return faixaEtariaMinima;
    }

    public void setFaixaEtariaMinima(int faixaEtariaMinima) {
        this.faixaEtariaMinima = faixaEtariaMinima;
    }

    public int getDuracaoEmDias() {
        return duracaoEmDias;
    }

    public void setDuracaoEmDias(int duracaoEmDias) {
        this.duracaoEmDias = duracaoEmDias;
    }

    // Implementação dos métodos abstratos de Evento
    @Override
    public double getPrecoInteira() {
        // Defina o preço da inteira conforme necessário
        return 50.0;
    }

    @Override
    public double getPrecoMeia() {
        // Defina o preço da meia conforme necessário
        return 25.0;
    }
}
