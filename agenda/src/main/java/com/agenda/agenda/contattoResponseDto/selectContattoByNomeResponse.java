package com.agenda.agenda.contattoResponseDto;

import com.agenda.agenda.model.Contatto;

import java.util.List;

public class selectContattoByNomeResponse {
    private List<Contatto> contatto;

    public selectContattoByNomeResponse(List<Contatto> contatto) {
        this.contatto = contatto;
    }

    public List<Contatto> getContatto() {
        return contatto;
    }

    public void setContatto(List<Contatto> contatto) {
        this.contatto = contatto;
    }
}
