package service;

import model.Saldo;

public class SaldoService {
    public void sacar(Saldo saldo, double valorSaque) {
        if (saldo.getSaldo() < valorSaque) {
            System.out.printf("Saldo insuficiente para saque.\nSaldo atual de %s: %.2f\n", saldo.getTitular(), saldo.getSaldo());
        } else {
            saldo.setSaldo(saldo.getSaldo() - valorSaque);
            System.out.printf("Saque de %.2f foi efetuado.\nSaldo atual de %s: %.2f\n", valorSaque, saldo.getTitular(), saldo.getSaldo());
        }
    }

    public void depositar(Saldo saldo, double valorDeposito) {
        saldo.setSaldo(saldo.getSaldo() + valorDeposito);

        System.out.printf("Depósito de %.2f foi efetuado.\nSaldo atual de %s: %.2f\n", valorDeposito, saldo.getTitular(), saldo.getSaldo());
    }

    public void exibirSaldo(Saldo saldo) {
        System.out.println("Saldo atual: " + saldo.getSaldo());
    }
}
