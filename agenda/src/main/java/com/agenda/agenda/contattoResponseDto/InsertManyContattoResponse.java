package com.agenda.agenda.contattoResponseDto;

import com.agenda.agenda.model.Contatto;

import java.util.List;

public class InsertManyContattoResponse {
    private List<Contatto> lista;

    public InsertManyContattoResponse(List<Contatto> lista) {
        this.lista = lista;
    }

    public List<Contatto> getLista() {
        return lista;
    }

    public void setLista(List<Contatto> lista) {
        this.lista = lista;
    }
}
