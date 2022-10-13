package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

    @InjectMocks
    private ContaService contaService;

    @Mock
    private ContaDAO contaDAO;

    @Test
    public void naoDeveCadastrarContaExistente() {
        Conta conta123 = new Conta();
        conta123.setNumero("123");

        Mockito.doReturn(conta123).when(contaDAO).pesquisarPorNumero("123");

        Assertions.assertThrows(ContaExistenteException.class, () -> contaService.inserir(conta123));
    }

    @Test
    public void deveCadastrarNovaConta() {
        Conta novaConta = new Conta();
        novaConta.setNumero("123");

        Mockito.doReturn(null).when(contaDAO).pesquisarPorNumero("123");
        Mockito.doNothing().when(contaDAO).inserir(novaConta);

        contaService.inserir(novaConta);
        Mockito.verify(contaDAO, times(1)).inserir(novaConta);
    }
}
