package com.agenda.agenda.contattoRequestDto;

public class UpdateContattoNomeRequest {
    private String _id;
    private String nome;

    public UpdateContattoNomeRequest() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
