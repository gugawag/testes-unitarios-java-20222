package org.example;

public class Conta {
    private String numero;
    private double saldo;

    public Conta() {
        this.saldo = 0;
    }

    public Conta(String numero, double saldo) {
        validarSaldoNegativo(saldo);
        this.numero = numero;
        this.saldo = saldo;
    }

    public void creditar(double valor) {
        validarSaldoNegativo(valor);
        this.saldo += valor;
    }

    public void debitar(double valor) {
        this.saldo -= valor;
    }

    public void transferir(Conta destino, double valor) {
        this.debitar(valor);
        destino.creditar(valor);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validarSaldoNegativo(saldo);
        this.saldo = saldo;
    }

    private static void validarSaldoNegativo(double saldo) {
        if (saldo < 0) {
            throw new RuntimeException("Não pode valor negativo!");
        }
    }

}
