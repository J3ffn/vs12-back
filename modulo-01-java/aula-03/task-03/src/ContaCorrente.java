public class ContaCorrente {

    Cliente cliente;

    String numeroConta;

    int agencia;

    double saldo;

    double chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println("Agência: " + agencia + ", numero: " + numeroConta);
    }

    public boolean sacar(double valor) {
        if (valor > saldo + chequeEspecial) return false;

        saldo -= valor;

        return true;
    }

    public boolean depositar(double valor) {
        if (valor < 0) return false;

        saldo += valor;

        return true;
    }

    public double retornarSaldoComChequeEspecial() {
        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente contaCorrente, double valor) {
        if (saldo + chequeEspecial < valor) return false;

        saldo -= valor;

        return contaCorrente.depositar(valor);
    }

}
