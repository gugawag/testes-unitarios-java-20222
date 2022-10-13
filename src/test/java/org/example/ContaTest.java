package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaTest {

    Conta c1;

    @BeforeEach
    private void configuraConta() {
        c1 = new Conta();
        c1.setNumero("1");
    }

    @Test
    public void deveriaTerSaldoZeroAoCriarNovaConta() {
        // configurar

        // executar

        // testar
        Assertions.assertEquals(0, c1.getSaldo());
    }

    @Test
    public void contaNaoDeveFicarNegativa() {
        // configurar
        double valor = 100;
        try {
            c1.creditar(valor);
        } catch (Exception e) {
            Assertions.fail();
        }

        // executar
        Assertions.assertThrows(Exception.class,
                () -> c1.debitar(valor + 1)
        );
    }

    @Test
    public void naoDevePermitirCreditarValoresNegativosOuNulo() {
        //executar/testar
        Assertions.assertThrows(Exception.class, ()->c1.creditar(-1));
        Assertions.assertEquals(0, c1.getSaldo());
    }

    @Test
    public void naoDeveDebitarValoresNegativos() {
        Assertions.assertThrows(Exception.class, ()->c1.debitar(-100));
        Assertions.assertEquals(0, c1.getSaldo());
    }

    @Test
    public void validarValoresPositivosPassandoNegativo() {
        boolean retorno = c1.validarValoresPositivosB(-1);
        Assertions.assertFalse(retorno);
    }

    @Test
    public void validarValoresPositivosPassandoNulo() {
        boolean retorno = c1.validarValoresPositivosB(0);
        Assertions.assertFalse(retorno);
    }

    @Test
    public void validarValoresPositivosPassandoPositivo() {
        boolean retorno = c1.validarValoresPositivosB(1);
        Assertions.assertTrue(retorno);
    }

    @Test
    public void deveCreditarNoDestinoValorTransferidoDaOrigem() throws Exception {
        // config
        Conta origem = new Conta();
        Conta destino = new Conta();

        double valorInicial = 100;
        origem.creditar(valorInicial);

        double valorATransferir = 60;
        // executar
        origem.transferir(destino, valorATransferir);

        // teste
        Assertions.assertEquals(valorInicial - valorATransferir, origem.getSaldo());
        Assertions.assertEquals(valorATransferir, destino.getSaldo());
    }

}
