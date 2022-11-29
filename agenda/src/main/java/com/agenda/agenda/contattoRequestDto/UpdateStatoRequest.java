package com.agenda.agenda.contattoRequestDto;

public class UpdateStatoRequest {
    private String _id;
    private String stato;

    public UpdateStatoRequest() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
}
