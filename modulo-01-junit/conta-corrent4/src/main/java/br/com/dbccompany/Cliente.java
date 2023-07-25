package br.com.dbccompany;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;

    private String cpf;

    private ArrayList<Contato> contatos;

    private ArrayList<Endereco> enderecos;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        enderecos = new ArrayList<>();
        contatos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void addContatos(Contato contato) {
        contatos.add(contato);
    }

    public void addContatos(Contato[] contatos) {
        this.contatos.addAll(List.of(contatos));
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void addEnderecos(Endereco endereco) {
        enderecos.add(endereco);
    }

    public void addEnderecos(Endereco[] enderecos) {
        this.enderecos.addAll(List.of(enderecos));
    }

}
