package br.com.dbccompany;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    private Cliente jeff = new Cliente("Jeff", "1234567890");

    private Cliente bruna = new Cliente("Bruna", "0987654321");

    private ContaPoupanca cpJeff = new ContaPoupanca(jeff, "923817", "1", 800);

    private ContaCorrente ccJeff = new ContaCorrente(jeff, "923817", "1", 800, 200);

    private ContaCorrente ccBruna = new ContaCorrente(bruna, "412353", "2", 420, 100);

    private ContaPagamento cpgBruna = new ContaPagamento(bruna, "412353", "2", 420);


    @Test
    void saqueContaCorrenteEVerificarSaldoComSucesso() {
        ccJeff.sacar(100);
        Assertions.assertEquals(ccJeff.getSaldo(), 700);
    }

    @Test
    void saqueContaCorrenteSemSaldo() {
        ccJeff.setSaldo(0);
        Assertions.assertFalse(ccJeff.sacar(500));
    }

    @Test
    void saqueContaPoupancaEVerificarSaldoComSucesso() {
        cpJeff.setSaldo(800);
        cpJeff.creditarTaxa();
        cpJeff.sacar(500);
        Assertions.assertEquals(cpJeff.getSaldo(), 308.0);
    }

    @Test
    void saqueContaPoupancaSemSaldo() {
        cpJeff.setSaldo(0);
        Assertions.assertFalse(cpJeff.sacar(500));
    }

    @Test
    void saqueContaPagamentoEVerificarSaldoComSucesso() {
        cpgBruna.sacar(300);
        Assertions.assertEquals(cpgBruna.getSaldo(), 115.75);
    }

    @Test
    void saqueContaPagamentoSemSaldo() {
        cpgBruna.setSaldo(0);
        Assertions.assertFalse(cpgBruna.sacar(500));
    }

    @Test
    void transferenciaEVerificarSaldoComSucesso() {
        ccJeff.transferir(cpgBruna, 100);
        Assertions.assertEquals(ccJeff.getSaldo(), 800);
    }

    @Test
    void transferenciaSemSaldo() {
        ccBruna.setSaldo(0);
        Assertions.assertFalse(ccBruna.transferir(cpJeff, 300));

    }

    @Test
    void depositoEVerificarSaldoComSucesso() {
        ccBruna.depositar(500);
        Assertions.assertEquals(ccBruna.getSaldo(), 920.0);
    }

    @Test
    void depositoNegativo() {
        Assertions.assertFalse(ccJeff.depositar(-500));
    }

}