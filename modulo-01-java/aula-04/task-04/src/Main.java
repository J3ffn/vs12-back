public class Main {
    public static void main(String[] args) {

        // Criação de contatos:
        Contato mae = new Contato("Mãe", "83996252569", 1);

        Contato tia = new Contato("Tia", "83996426382", 1);

        Contato mercadoMartins = new Contato("Mercadinho Martins", "83994623753", 2);

        // Criação endereços:
        Endereco conceicao = new Endereco("Brasil", "Paraíba", "Conceição", "58970-000", "Rua João Juvenal", 200, "Primeiro andar", 1);

        Endereco monteiro = new Endereco("Brasil", "Paraíba", "Monteiro", "58500-000", "Rua Luíz Romão de Melo", 0, "Condomínio de Waguinho", 1);

        // Criação Cliente:
        Cliente jeff = new Cliente("Jeff", "123.456.789-01");
        jeff.setContatos(new Contato[]{mae, tia, mercadoMartins});
        jeff.setEnderecos(new Endereco[]{conceicao, monteiro});

        Cliente bruna = new Cliente("Bruna", "743.245.539-73");
        bruna.setContatos(new Contato[]{mercadoMartins});
        bruna.setEnderecos(new Endereco[]{monteiro});

        // Criação ContaCorrente:
        ContaCorrente contaCorrenteJeff = new ContaCorrente();
        contaCorrenteJeff.setCliente(jeff);
        contaCorrenteJeff.setAgencia("123");
        contaCorrenteJeff.setNumeroConta("45378");
        contaCorrenteJeff.setSaldo(800);
        contaCorrenteJeff.setChequeEspecial(100);

        ContaPoupanca contaPoupancaBruna = new ContaPoupanca();
        contaPoupancaBruna.setCliente(bruna);
        contaPoupancaBruna.setAgencia("123");
        contaPoupancaBruna.setNumeroConta("35225");
        contaPoupancaBruna.setSaldo(900);

        /* Execução de métodos: */

        // ContaCorrente Jeff:
        contaCorrenteJeff.sacar(500);
        contaCorrenteJeff.depositar(200);
        System.out.println("Saldo + cheque especial: " + contaCorrenteJeff.retornarSaldoComChequeEspecial());
        contaCorrenteJeff.transferir(contaPoupancaBruna, 200);
        contaCorrenteJeff.imprimir();

        // ContaCorrente Bruna:
        contaPoupancaBruna.sacar(600);
        contaPoupancaBruna.depositar(130);
        contaPoupancaBruna.transferir(contaCorrenteJeff, 300);
        System.out.println("Saldo ANTES de creditar: " + contaPoupancaBruna.getSaldo());
        contaPoupancaBruna.creditarTaxa();
        System.out.println("Saldo DEPOIS de creditar: " + contaPoupancaBruna.getSaldo());
        contaPoupancaBruna.imprimir();

        // Impressão das duas contas:
        contaCorrenteJeff.imprimir();
        contaPoupancaBruna.imprimir();

    }
}
