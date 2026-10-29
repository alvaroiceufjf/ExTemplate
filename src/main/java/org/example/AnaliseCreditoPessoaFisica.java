package org.example;

public class AnaliseCreditoPessoaFisica extends AnaliseCredito {

    private double rendaMensal;

    public AnaliseCreditoPessoaFisica(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    @Override
    protected double calcularCapacidadePagamento() {
        // Regra PF: Limite de crédito de até 5x a renda mensal
        return this.rendaMensal * 5;
    }

    @Override
    protected double determinarTaxaJuros() {
        return 2.5; // Taxa de 2.5% a.m. para PF
    }
}