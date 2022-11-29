package com.agenda.agenda.controller;

import com.agenda.agenda.model.Contatto;
import com.agenda.agenda.contattoRequestDto.*;
import com.agenda.agenda.contattoResponseDto.*;
import com.agenda.agenda.servicies.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rubrica")
public class ContattoController {

    @Autowired
    ContattoService  services;

    @RequestMapping(method = RequestMethod.GET, value="/contatti")
    public ResponseEntity<listaContattiResponse> listaContatti(){
        List<Contatto> l = services.findAllContatti();
        return ResponseEntity.status(200).body(new listaContattiResponse(l));

    }

    @RequestMapping(method = RequestMethod.GET, value = "/cerca")
    public ResponseEntity<selectContattoByNomeResponse> selectContattoByNome(@RequestBody FindContattoByNameRequest request){
        List<Contatto> contatto = services.FindContattoByName(request.getNome());
        return ResponseEntity.status(200).body(new selectContattoByNomeResponse(contatto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    public ResponseEntity deleteFromId(@RequestBody DeleteContattoFromIdRequest request){
        services.deleteContatto(request.getId());
        return ResponseEntity.status(200).build();
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update-nome")
    public ResponseEntity<UpdateContattoNomeResponse> updateContattoNome(@RequestBody UpdateContattoNomeRequest request){
        Contatto c = services.updateContattoNome(request.get_id(), request.getNome());
        return ResponseEntity.status(200).body(new UpdateContattoNomeResponse(c));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cerca-nome-cellulare")
    public ResponseEntity<FindByNomeNumeroResponse> findByNomeNumero(@RequestBody FindByNomeNumeroRequest request){
        List<Contatto> l = services.findByNomeNumeroOld(request.getNome(), request.getNumero());
        return ResponseEntity.status(200).body(new FindByNomeNumeroResponse(l));

    }

    @RequestMapping(method = RequestMethod.POST, value = "/insert-many")
    public ResponseEntity<InsertManyContattoResponse> insertManyContatto(@RequestBody InsertManyContattoRequest request){
        List<Contatto> l = services.insertManyContatto(request.getLista());
        return ResponseEntity.status(200).body(new InsertManyContattoResponse(l));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cerca-nome-o-numero")
    public ResponseEntity<FindByNomeOrCellulareResponse> findByNomeOrCellulare(@RequestBody FindByNomeOrCellulareRequest request){
        List<Contatto> l = services.findByNomeOrCellulare(request.getNome(), request.getCellulare());
        return ResponseEntity.status(200).body(new FindByNomeOrCellulareResponse(l));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cerca-numero-di-casa-non-vuoto")
    public ResponseEntity<FindByNumeroDiCasaIsNotEmptyResponse> findByNumeroDiCasaIsNotEmpty(){
        List<Contatto> l = services.findByNumeroDiCasaIsNotNull();
        return ResponseEntity.status(200).body(new FindByNumeroDiCasaIsNotEmptyResponse(l));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cerca-cognome-vuoto")
    public ResponseEntity<FindContattoByNomeIsNotNullAndCognomeIsNullResponse> findByCognomeIsNull(){
        List<Contatto> l = services.findByCognomeIsNull();
        return ResponseEntity.status(200).body(new FindContattoByNomeIsNotNullAndCognomeIsNullResponse(l));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update-stato")
    public ResponseEntity<UpdateStatoResponse> updateStato(@RequestBody UpdateStatoRequest request){
        Contatto c = services.updateStato(request.get_id(), request.getStato());
        return ResponseEntity.status(200).body(new UpdateStatoResponse(c));
    }

    /*@RequestMapping(method = RequestMethod.POST, value = "/delete-aut")
    public ResponseEntity<DeleteContattoByStatoResponse> deleteContattoByStato(){
        List<Contatto> l = services.deleteByStatoRIMOSSO();
        return ResponseEntity.status(200).body(new DeleteContattoByStatoResponse(l));
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/delete-aut-bulk")
    public ResponseEntity<DeleteContattoByStatoResponse> deleteByStatoRIMOSSOBulk(){
        List<Contatto> l = services.deleteByStatoRIMOSSOLimit();
        return ResponseEntity.status(200).body(new DeleteContattoByStatoResponse(l));
    }
}
