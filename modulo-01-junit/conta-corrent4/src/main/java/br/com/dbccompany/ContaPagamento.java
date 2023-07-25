package br.com.dbccompany;

public class ContaPagamento extends Conta implements Impresao{

	private final static double TAXA_SAQUE = 4.25;

	public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
		super(cliente, numeroConta, agencia, saldo);
	}

	@Override
	public boolean sacar(double valor) {
		if (valor > saldo || valor < 1) {
			System.out.println("São iguáis");
			return false;
		}

		saldo -= valor + TAXA_SAQUE;

		return true;
	}

	@Override
	public void imprimir() {
		System.out.println(getCliente().getNome() + ", tem: " + getSaldo() + ", Agência: " + getAgencia() + ", numero: " + getNumeroConta() + ", Taxa de saque: " + TAXA_SAQUE);
	}
}
