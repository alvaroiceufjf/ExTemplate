package org.example;

public class AnaliseCreditoAgro extends AnaliseCredito {

    private double faturamentoAnualSafra;

    public AnaliseCreditoAgro(double faturamentoAnualSafra) {
        this.faturamentoAnualSafra = faturamentoAnualSafra;
    }

    @Override
    protected double calcularCapacidadePagamento() {
        // Regra Agro: Crédito de até 60% da estimativa da safra anual
        return this.faturamentoAnualSafra * 0.6;
    }

    @Override
    protected double determinarTaxaJuros() {
        return 1.2; // Taxa subsidiada de 1.2% a.m. para o Agronegócio
    }
}