package com.agenda.agenda.repository;

import com.agenda.agenda.model.Contatto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContattoRepository extends MongoRepository<Contatto, String> {
    public List<Contatto> findByNome(String Nome);
    public Contatto findBy_id(String Nome);

    public  List<Contatto> findByCellulare(String Numero);

    public List<Contatto> findByNomeAndCellulare(String Nome, String Numero);

    public List<Contatto> findByNomeOrCellulare(String Nome, String Cellulare);

    public List<Contatto> findContattoByNumeroDiCasaIsEmpty();

    public List<Contatto> findContattoByNomeIsNotNullAndCognomeIsNull();

    public List<Contatto> findContattoByStato(Contatto.Stato Stato);
}
