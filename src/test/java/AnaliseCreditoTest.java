package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnaliseCreditoTest {

    @Test
    void deveAprovarAnalisePessoaFisica() {
        // Renda R$ 4.000 -> Limite R$ 20.000
        AnaliseCredito analisePF = new AnaliseCreditoPessoaFisica(4000.0);
        String resultado = analisePF.executarAnalise(15000.0);

        assertEquals("Análise Aprovada: R$ 15000.0 liberados com taxa de 2.5% a.m.", resultado);
    }

    @Test
    void deveAprovarParcialmentePessoaFisicaQuandoExcederLimite() {
        // Renda R$ 2.000 -> Limite R$ 10.000
        AnaliseCredito analisePF = new AnaliseCreditoPessoaFisica(2000.0);
        String resultado = analisePF.executarAnalise(15000.0);

        assertEquals("Análise Parcialmente Aprovada: Limite disponível de R$ 10000.0 com taxa de 2.5% a.m.", resultado);
    }

    @Test
    void deveAprovarAnaliseAgroComTaxaEspecial() {
        // Faturamento Safra R$ 100.000 -> Limite R$ 60.000
        AnaliseCredito analiseAgro = new AnaliseCreditoAgro(100000.0);
        String resultado = analiseAgro.executarAnalise(50000.0);

        assertEquals("Análise Aprovada: R$ 50000.0 liberados com taxa de 1.2% a.m.", resultado);
    }
}