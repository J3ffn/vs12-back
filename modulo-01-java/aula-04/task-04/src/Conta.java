public class Conta implements Movimentacao {

    private Cliente cliente;

    private String numeroConta;

    private String agencia;

    protected double saldo;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double valor) {
        if (saldo > saldo) return false;

        saldo -= valor;

        return true;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor < 0) return false;

        saldo += valor;

        return true;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (!sacar(valor)) return false;

        return conta.depositar(valor);
    }
}
