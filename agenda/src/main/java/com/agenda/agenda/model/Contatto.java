package com.agenda.agenda.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Contatto {
    public enum Stato{
        RIMOSSO,
        ATTIVO,
        INATTIVO,
        DELETE
    }

    private String _id;
    private String nome;
    private String cognome;
    private String numeroDiCasa;
    private String cellulare;
    private String email;
    private Stato stato;


    public Contatto() {
    }

    public Contatto(String nome, String cognome, String numeroDiCasa, String cellulare, String email, Stato stato) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroDiCasa = numeroDiCasa;
        this.cellulare = cellulare;
        this.email = email;
        this.stato = stato;
    }

    public Contatto(String _id) {
        this._id = _id;
    }

    public String get_id() {return _id; }

    public String getNome() {return nome; }

    public String getCognome() {return cognome; }

    public String getNumeroDiCasa() {return numeroDiCasa; }

    public String getCellulare() {return cellulare; }

    public String getEmail() {return email; }

    public Stato getStato() {return stato; }

    public void setNome(String nome) {this.nome = nome; }

    public void setCognome(String cognome) {this.cognome = cognome; }

    public void setNumeroDiCasa(String numeroDiCasa) {this.numeroDiCasa = numeroDiCasa; }

    public void setCellulare(String cellulare) {this.cellulare = cellulare; }

    public void setEmail(String email) {this.email = email; }
    public void setStato(Stato stato) {this.stato = stato; }
}
