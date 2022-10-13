package org.example;

public class ContaService {

    private ContaDAO contaDAO;

    public void inserir(Conta novaConta) {
        Conta contaPesquisada = contaDAO.pesquisarPorNumero(novaConta.getNumero());
        if (contaPesquisada != null) {
            throw new ContaExistenteException("Essa conta já existe!");
        }
        contaDAO.inserir(novaConta);
    }
}
