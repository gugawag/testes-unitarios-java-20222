package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

    @InjectMocks
    private ContaService contaService;

    @Mock
    private ContaDAO contaDAO;

    @Test
    public void naoDeveriaInserirContaJahExistente() {
        Conta conta = new Conta("123", 0);

        Mockito.doReturn(conta).when(contaDAO).pesquisarPorNumero("123");
        Assertions.assertThrows(ContaExistenteException.class, () -> contaService.inserir(conta));
    }

    @Test
    public void deveriaInserirConta() {
        Conta conta = new Conta("123", 0);

        Mockito.doReturn(null).when(contaDAO).pesquisarPorNumero("123");
        contaService.inserir(conta);

        Mockito.verify(contaDAO).inserir(conta);
    }

}
