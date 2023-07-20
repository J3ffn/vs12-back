public class Endereco {

    private int tipo;

    private String logradouro;

    private int numero;

    private String complemento;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;

    public Endereco(String pais, String estado, String cidade, String cep, String logradouro, int numero, String complemento,  int tipo) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.tipo = tipo;
    }

    public void imprimirEndereco() {
        System.out.printf("%s, %s, %s, %s, %s - %d, %s. Tipo: ", pais, estado, cidade, cep, logradouro, numero, complemento);
        switch (tipo) {
            case 1 -> System.out.println("Residência");
            case 2 -> System.out.println("Comercial");
            default -> System.out.println("Não definido");
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
