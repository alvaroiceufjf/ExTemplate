package org.example;

public abstract class AnaliseCredito {


    public final String executarAnalise(double valorSolicitado) {
        if (!validarDocumentacao()) {
            return "Análise Reprovada: Documentação Pendente";
        }

        if (!consultarBacen()) {
            return "Análise Reprovada: Restrição Cadastral/Bacen";
        }

        double limiteDisponivel = calcularCapacidadePagamento();
        double taxaJuros = determinarTaxaJuros();

        if (limiteDisponivel < valorSolicitado) {
            return "Análise Parcialmente Aprovada: Limite disponível de R$ " + limiteDisponivel +
                    " com taxa de " + taxaJuros + "% a.m.";
        }

        return "Análise Aprovada: R$ " + valorSolicitado + " liberados com taxa de " + taxaJuros + "% a.m.";
    }


    protected boolean validarDocumentacao() {
        return true;
    }

    protected boolean consultarBacen() {
        return true;
    }


    protected abstract double calcularCapacidadePagamento();
    protected abstract double determinarTaxaJuros();
}