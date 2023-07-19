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
        jeff.addContatos(new Contato[]{mae, tia, mercadoMartins});
        jeff.addEnderecos(new Endereco[]{conceicao, monteiro});

        Cliente bruna = new Cliente("Bruna", "743.245.539-73");
        bruna.addContatos(new Contato[]{mercadoMartins});
        bruna.addEnderecos(new Endereco[]{monteiro});

        // Criação ContaCorrente:
        ContaCorrente contaCorrenteJeff = new ContaCorrente();
        contaCorrenteJeff.setCliente(jeff);
        contaCorrenteJeff.setAgencia("123");
        contaCorrenteJeff.setNumeroConta("45378");
        contaCorrenteJeff.setSaldo(800);
        contaCorrenteJeff.setChequeEspecial(100);

        ContaPagamento contaPagamentoBruna = new ContaPagamento();
        contaPagamentoBruna.setCliente(bruna);
        contaPagamentoBruna.setAgencia("123");
        contaPagamentoBruna.setNumeroConta("35225");
        contaPagamentoBruna.setSaldo(900);

        ContaCorrente contaCorrenteBruna = new ContaCorrente();
        contaCorrenteBruna.setCliente(bruna);
        contaCorrenteBruna.setAgencia("123");
        contaCorrenteBruna.setNumeroConta("35125");
        contaCorrenteBruna.setSaldo(900);
        contaCorrenteBruna.setChequeEspecial(200);

        /** @Movimentações: */

        // Conta Corrente Jeff:
        contaCorrenteJeff.sacar(500);
        contaCorrenteJeff.sacar(90000);
        contaCorrenteJeff.depositar(200);
        System.out.println("Saldo + cheque especial: " + contaCorrenteJeff.retornarSaldoComChequeEspecial());
        contaCorrenteJeff.transferir(contaPagamentoBruna, 200);

        // conta Pagamento Bruna:
        contaPagamentoBruna.sacar(600);
        contaPagamentoBruna.sacar(2000000);
        contaPagamentoBruna.depositar(130);
        contaPagamentoBruna.transferir(contaCorrenteJeff, 300);
        contaPagamentoBruna.transferir(contaCorrenteBruna, 500);
        contaPagamentoBruna.transferir(contaPagamentoBruna, 200);

        // conta Corrente Bruna:
        contaCorrenteBruna.sacar(600);
        contaCorrenteBruna.depositar(130);
        contaCorrenteBruna.depositar(612);
        System.out.println("Saldo + cheque especial: " + contaCorrenteBruna.retornarSaldoComChequeEspecial());
        contaCorrenteBruna.transferir(contaCorrenteJeff, 300);
        contaCorrenteBruna.transferir(contaPagamentoBruna, 200);

        // Impressão das duas contas:
        contaCorrenteJeff.imprimir();
        contaPagamentoBruna.imprimir();
        contaCorrenteBruna.imprimir();

    }
}
