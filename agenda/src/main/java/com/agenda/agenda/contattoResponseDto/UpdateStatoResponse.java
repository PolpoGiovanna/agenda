package com.agenda.agenda.contattoResponseDto;

import com.agenda.agenda.model.Contatto;

public class UpdateStatoResponse {
    private Contatto contatto;

    public UpdateStatoResponse(Contatto contatto) {
        this.contatto = contatto;
    }

    public Contatto getContatto() {
        return contatto;
    }

    public void setContatto(Contatto contatto) {
        this.contatto = contatto;
    }
}
