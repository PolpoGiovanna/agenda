package com.agenda.agenda.contattoResponseDto;

import com.agenda.agenda.model.Contatto;

import java.util.List;

public class listaContattiResponse {
    private List<Contatto> lista;

    public listaContattiResponse(List<Contatto> lista) {
        this.lista = lista;
    }

    public List<Contatto> getLista() {
        return lista;
    }

    public void setLista(List<Contatto> lista) {
        this.lista = lista;
    }
}
