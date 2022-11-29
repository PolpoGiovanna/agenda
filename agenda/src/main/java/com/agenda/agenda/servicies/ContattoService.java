package com.agenda.agenda.servicies;

import com.agenda.agenda.model.Contatto;
import com.agenda.agenda.repository.ContattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContattoService {

    @Autowired
    ContattoRepository repo;

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Contatto> findAllContatti(){
        List<Contatto> l = repo.findAll();
        return l;
    }

    public List<Contatto> FindContattoByName(String Nome){
        List<Contatto> c = repo.findByNome(Nome);
        return c ;
    }

    public Contatto insertContattoOld(Contatto contatto) {
            repo.save(contatto);
            return contatto;
    }

    public void deleteContatto(String id){
        repo.deleteById(id);
    }

    public Contatto updateContattoNome(String id, String nome){
        Contatto c = repo.findBy_id(id);
        c.setNome(nome);
        Contatto cc = repo.save(c);
        return cc;
    }

    public List<Contatto> findByNomeNumeroOld(String Nome, String Numero){
        if(Nome == null || Nome.isEmpty()){
            List<Contatto> l = repo.findByCellulare(Numero);
            return l;
        }else if(Numero == null || Numero.isEmpty()){
            List<Contatto> l = repo.findByNome(Nome);
            return l;
        }else{
            List <Contatto> l = repo.findByNomeAndCellulare(Nome, Numero);
            return l;
        }
    }

    public List<Contatto> insertManyContattoOld(List<Contatto> Contatti){

        for(int i=0; i < Contatti.size() ; i++){
            repo.save(Contatti.get(i));
        }
        return Contatti;
    }

    public List<Contatto>insertManyContatto(List<Contatto> Contatti){
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.ORDERED, Contatto.class);

        bulkOperations.insert(Contatti);

        bulkOperations.execute();
        return Contatti;
    }

    public List<Contatto> findByNomeOrCellulare(String Nome, String Cellulare){
        List<Contatto> l = repo.findByNomeOrCellulare(Nome, Cellulare);
        return l;
    }

    public List<Contatto> findByNumeroDiCasaIsNotNull(){
        List<Contatto> l = repo.findContattoByNumeroDiCasaIsEmpty();
        return l;
    }

    public List<Contatto> findByCognomeIsNull(){
        List<Contatto> l = repo.findContattoByNomeIsNotNullAndCognomeIsNull();
        return l;
    }

    public Contatto insertContatto(Contatto contatto) {
        repo.save(contatto);
        return contatto;
    }

    public Contatto updateStato(String Id, String StatoInput ){
        Contatto c = repo.findBy_id(Id);
        Contatto.Stato s = Contatto.Stato.valueOf(StatoInput);

        c.setStato(s);
        if(c.getStato().compareTo(s) == 0){
            repo.save(c);
            return c;
        }else{
            return null;
        }
    }

    /*@Scheduled(fixedDelay = 5000)
    public List<Contatto> deleteByStatoRIMOSSO(){
        Contatto.Stato s = Contatto.Stato.RIMOSSO;
        List<Contatto> l = repo.findContattoByStato(s);

        for (Contatto c : l){
            repo.delete(c);
        }
        return l;
    }*/

    //@Scheduled(fixedDelay = 5000)
    public List<Contatto> deleteByStatoRIMOSSOLimit(){
        Query q = new Query(Criteria.where("stato")
                .is(Contatto.Stato.RIMOSSO)).limit(5).cursorBatchSize(5);
        List<Contatto> c= mongoTemplate.find(q, Contatto.class);

        for (Contatto ce: c){
            System.out.println(ce);
            repo.delete(ce);

        }
        System.out.println();
        return c;
    }
}
