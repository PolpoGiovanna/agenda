package com.agenda.agenda.contattoRequestDto;

import com.agenda.agenda.model.Contatto;

import java.util.List;

public class InsertManyContattoRequest {
    List<Contatto> lista;

    public InsertManyContattoRequest() {
    }

    public List<Contatto> getLista() {
        return lista;
    }

    public void setLista(List<Contatto> lista) {
        this.lista = lista;
    }
}
