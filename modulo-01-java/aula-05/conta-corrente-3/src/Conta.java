public class Conta implements Movimentacao, Comparable<Conta> {

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
        if (valor > saldo || valor < 1) return false;

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
        if (conta.compareTo(this) != 0) return false;
        if (!sacar(valor)) return false;

        return conta.depositar(valor);
    }

    @Override
    public int compareTo(Conta o) {
        return o.getAgencia().compareTo(this.getAgencia()) + o.getNumeroConta().compareTo(this.getNumeroConta());
    }
}
