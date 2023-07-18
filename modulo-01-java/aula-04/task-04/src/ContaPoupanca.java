public class ContaPoupanca extends Conta implements Impresao {

    private static final double JURUS_MENSAIS = 1.01;

    public ContaPoupanca() {}

    public void creditarTaxa() {
        saldo *= JURUS_MENSAIS;
    }

    @Override
    public void imprimir() {
        System.out.println(getCliente().getNome() + ", tem: " + getSaldo() + " Agência: " + getAgencia() + ", numero: " + getNumeroConta() + ", Jurus mensais: " + JURUS_MENSAIS);
    }
}
