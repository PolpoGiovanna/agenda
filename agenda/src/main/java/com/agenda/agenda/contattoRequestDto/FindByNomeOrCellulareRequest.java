package com.agenda.agenda.contattoRequestDto;

public class FindByNomeOrCellulareRequest {
    private String nome;
    private String cellulare;

    public FindByNomeOrCellulareRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }
}
