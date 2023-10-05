package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContaTest {

    private Conta c1;

    @BeforeEach
    public void config() {
        c1 = new Conta("1", 0);
    }

    @Test
    public void deveriaCriarContaComSaldoZero() {
        //config
        //execucao
        //testar
        Assertions.assertEquals(0, c1.getSaldo());
    }

    @Test
    public void deveriaLancarExcecaoQuandoCreditarValorNegativo(){
        // executar

        //teste
        Assertions.assertThrows(RuntimeException.class, () -> {c1.creditar(-1);});
    }

    @Test
    public void naoDeveriaCreditarValorNegativo(){
        // executar
        try {
            c1.creditar(-1);
            Assertions.fail();
        } catch (RuntimeException e) {
        }
        //teste
        Assertions.assertEquals(0, c1.getSaldo());
    }

    @Test
    public void naoDeveriaPermitirSaldoNegativoAoConstruirConta() {
        Assertions.assertThrows(RuntimeException.class, () -> {new Conta("1", -1);});
    }

    @Test
    public void naoDeveriaPermitirSaldoNegativo() {
        Assertions.assertThrows(RuntimeException.class, () -> {c1.setSaldo(-1);});
    }

    @Test
    public void naoDeveriaTransferirValorNegativo() {
        //configurar
        Conta contaOrigem = c1;
        Conta contaDestino = new Conta();

        Assertions.assertThrows(RuntimeException.class, () -> contaOrigem.transferir(contaDestino, -1));
    }

    @Test
    public void deveAparecerEmDestinoValorTransferidoDeOrigem() {
        var saldoInicialOrigem = 300;
        var saldoInicialDestino = 100;
        var valorASerTransferido = 50;

        Conta contaOrigem = new Conta("1", saldoInicialOrigem);
        Conta contaDestino = new Conta("2", saldoInicialDestino);

        //executar
        contaOrigem.transferir(contaDestino, valorASerTransferido);

        // Test
        Assertions.assertEquals(saldoInicialDestino + valorASerTransferido, contaDestino.getSaldo());
        Assertions.assertEquals(saldoInicialOrigem - valorASerTransferido, contaOrigem.getSaldo());
    }

}
