package br.com.dbccompany;

public class ContaPoupanca extends Conta implements Impresao {

    private static final double JURUS_MENSAIS = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        saldo *= JURUS_MENSAIS;
    }

    @Override
    public void imprimir() {
        System.out.println(getCliente().getNome() + ", tem: " + getSaldo() + " Agência: " + getAgencia() + ", numero: " + getNumeroConta() + ", Jurus mensais: " + JURUS_MENSAIS);
    }
}
