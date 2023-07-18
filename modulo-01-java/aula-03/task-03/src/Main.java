public class Main {

    public static void main(String[] args) {

        // Criação de contatos:
        Contato mae = new Contato();
        mae.descricao = "Mãe";
        mae.telefone = "83996252569";
        mae.tipo = 1;

        Contato tia = new Contato();
        tia.descricao = "Tia";
        tia.telefone = "83996426382";
        tia.tipo = 1;

        Contato mercadoMartins = new Contato();
        mercadoMartins.descricao = "Mercadinho Martins";
        mercadoMartins.telefone = "83994623753";
        mercadoMartins.tipo = 2;

        // Criação endereços:
        Endereco conceicao = new Endereco();
        conceicao.pais = "Brasil";
        conceicao.estado = "Paraíba";
        conceicao.cidade = "Conceição";
        conceicao.cep = "58970-000";
        conceicao.logradouro = "Rua João Juvenal";
        conceicao.numero = 200;
        conceicao.complemento = "Primeiro andar";
        conceicao.tipo = 1;

        Endereco monteiro = new Endereco();
        monteiro.pais = "Brasil";
        monteiro.estado = "Paraíba";
        monteiro.cidade = "Monteiro";
        monteiro.cep = "58500-000";
        monteiro.logradouro = "Rua Luíz Romão de Melo";
        monteiro.numero = 0;
        monteiro.complemento = "Condomínio de Waguinho";
        monteiro.tipo = 1;

        // Criação Cliente:
        Cliente jeff = new Cliente();
        jeff.nome = "Jeff";
        jeff.contatos = new Contato[]{mae, tia, mercadoMartins};
        jeff.CPF = "123.456.789-01";
        jeff.enderecos = new Endereco[]{conceicao, monteiro};

        Cliente bruna = new Cliente();
        bruna.nome = "Bruna";
        bruna.contatos = new Contato[]{mercadoMartins};
        bruna.CPF = "743.245.539-73";
        bruna.enderecos = new Endereco[]{monteiro};

        // Criação ContaCorrente:
        ContaCorrente contaCorrenteJeff = new ContaCorrente();
        contaCorrenteJeff.cliente = jeff;
        contaCorrenteJeff.agencia = 1;
        contaCorrenteJeff.numeroConta = "45378-3";
        contaCorrenteJeff.saldo = 800;
        contaCorrenteJeff.chequeEspecial = 100;

        ContaCorrente contaCorrenteBruna = new ContaCorrente();
        contaCorrenteBruna.cliente = bruna;
        contaCorrenteBruna.agencia = 1;
        contaCorrenteBruna.numeroConta = "35225-5";
        contaCorrenteBruna.saldo = 900;
        contaCorrenteBruna.chequeEspecial = 100;


        /* Execução de métodos: */

        // ContaCorrente Jeff:
        contaCorrenteJeff.sacar(500);
        contaCorrenteJeff.depositar(200);
        contaCorrenteJeff.retornarSaldoComChequeEspecial();
        contaCorrenteJeff.transferir(contaCorrenteBruna, 200);

        // ContaCorrente Bruna:
        contaCorrenteBruna.sacar(600);
        contaCorrenteBruna.depositar(130);
        contaCorrenteBruna.retornarSaldoComChequeEspecial();
        contaCorrenteBruna.transferir(contaCorrenteJeff, 300);

        // Impressão das duas contas:
        contaCorrenteJeff.imprimirContaCorrente();
        contaCorrenteBruna.imprimirContaCorrente();
    }
}