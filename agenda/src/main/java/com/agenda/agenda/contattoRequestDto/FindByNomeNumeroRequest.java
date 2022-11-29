package com.agenda.agenda.contattoRequestDto;

public class FindByNomeNumeroRequest {
    private String nome;
    private String numero;

    public FindByNomeNumeroRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
