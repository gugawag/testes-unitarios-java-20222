package org.example;

public class Conta {
    private String numero;
    private double saldo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debitar(double valor) throws Exception {
        validarValoresPositivos(valor);
        if (valor > this.saldo) {
            throw new Exception("Saldo da conta não pode ficar negativa");
        }
        this.saldo -= valor;
    }

    public void creditar(double valor) throws Exception {
        validarValoresPositivos(valor);
        this.saldo += valor;
    }

    protected static void validarValoresPositivos(double valor) throws Exception {
        if (valor <= 0) {
            throw new Exception("Valor inválido!");
        }
    }

    protected static boolean validarValoresPositivosB(double valor) {
        if (valor <= 0) {
            return false;
        }
        return true;
    }

    public void transferir(Conta destino, double valorATransferir) throws Exception {
        this.debitar(valorATransferir);
        destino.creditar(valorATransferir);
    }
}
