public class Cliente {

    String nome;

    String cpf;

    Contato[] contatos = new Contato[2];

    Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos() {
        for (Contato contato : contatos) {
            contato.imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for (Endereco endereco : enderecos) {
            endereco.imprimirEndereco();
        }
    }

    public void imprimirCliente() {
        System.out.println(nome + " CPF: " + cpf);
    }

}
