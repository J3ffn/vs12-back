public class ContaCorrente extends Conta implements Impresao{

    private double chequeEspecial;

    public double retornarSaldoComChequeEspecial() {
        return saldo * chequeEspecial;
    }

    public void setChequeEspecial(double valor) {
        chequeEspecial = valor;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > saldo + chequeEspecial) return false;

        saldo -= valor;

        return true;
    }

    @Override
    public void imprimir() {
        System.out.println(getCliente().getNome() + ", tem: " + getSaldo() + ", Agência: " + getAgencia() + ", numero: " + getNumeroConta() + ", Cheque especial: " + chequeEspecial);
    }
}
