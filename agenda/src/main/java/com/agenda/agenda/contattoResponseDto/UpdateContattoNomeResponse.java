package com.agenda.agenda.contattoResponseDto;

import com.agenda.agenda.model.Contatto;

public class UpdateContattoNomeResponse {
    private Contatto contatto;

    public UpdateContattoNomeResponse(Contatto contatto) {
        this.contatto = contatto;
    }

    public Contatto getContatto() {
        return contatto;
    }

    public void setContatto(Contatto contatto) {
        this.contatto = contatto;
    }
}
