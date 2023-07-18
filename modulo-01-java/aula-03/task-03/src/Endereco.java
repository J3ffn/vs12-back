public class Endereco {

    int tipo;

    String logradouro;

    int numero;

    String complemento;

    String cep;

    String cidade;

    String estado;

    String pais;

    public void imprimirEndereco() {
        System.out.printf("%s, %s, %s, %s, %s - %d, %s. Tipo %d %n", pais, estado, cidade, cep, logradouro, numero, complemento, tipo);
    }
}
