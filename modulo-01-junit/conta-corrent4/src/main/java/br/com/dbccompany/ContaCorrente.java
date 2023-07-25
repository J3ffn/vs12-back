package br.com.dbccompany;

public class ContaCorrente extends Conta implements Impresao{

    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial() {
        return saldo + chequeEspecial;
    }

    public void setChequeEspecial(double valor) {
        if (valor < 0) return;

        chequeEspecial = valor;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > saldo + chequeEspecial || valor < 1) return false;

        saldo -= valor;

        return true;
    }

    @Override
    public void imprimir() {
        System.out.println(getCliente().getNome() + ", tem: " + getSaldo() + ", Agência: " + getAgencia() + ", numero: " + getNumeroConta() + ", Cheque especial: " + chequeEspecial);
    }
}
