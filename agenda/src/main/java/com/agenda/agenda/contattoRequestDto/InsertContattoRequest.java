package com.agenda.agenda.contattoRequestDto;

public class InsertContattoRequest {
    private String nome;

    private String cognome;

    private String numeroDiCasa;

    private String cellulare;

    private String email;

    public InsertContattoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumeroDiCasa() {
        return numeroDiCasa;
    }

    public String getCellulare() {
        return cellulare;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumeroDiCasa(String numeroDiCasa) {
        this.numeroDiCasa = numeroDiCasa;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
