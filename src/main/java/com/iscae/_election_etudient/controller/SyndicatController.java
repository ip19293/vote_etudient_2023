package com.iscae._election_etudient.controller;

import com.iscae._election_etudient.controller.request_response.SyndicatResponse;
import com.iscae._election_etudient.data.Syndicat;
import com.iscae._election_etudient.services.SyndicatServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/election/")
public class SyndicatController {
 final SyndicatServices syndicatServices;
    public SyndicatController(SyndicatServices syndicatServices) {
        this.syndicatServices = syndicatServices;
    }


    @GetMapping("public/syndicat")
    public ResponseEntity<List<SyndicatResponse>> getAllSyndicats (){
       List<SyndicatResponse> list=new ArrayList<SyndicatResponse>();

        List<Syndicat> syndicats = syndicatServices.getSyndicats();
        for(int x=0;x<syndicats.size();x++){
            SyndicatResponse syndicat=new SyndicatResponse(syndicats.get(x).getSyndicatNom() ,syndicats.get(x).getNombreVote(),x+1,syndicats.get(x).getLogo());
            list.add(syndicat);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("public/syndicat/nom")
    public ResponseEntity<List<String>> getAllSyndicatsNom (){
        List<String> list=new ArrayList<String>();
        List<Syndicat> syndicats = syndicatServices.getSyndicats();
        for(int x=0;x<syndicats.size();x++){
            list.add(syndicats.get(x).getSyndicatNom());

        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("public/syndicat/add")
    public ResponseEntity<Syndicat> addSyndicat(@RequestBody Syndicat syndicat){
        Syndicat newSyndicat= syndicatServices.saveSyndicat(syndicat);
        return new ResponseEntity<>(newSyndicat, HttpStatus.CREATED);
    }


    @PutMapping("public/syndicat/update/")
    public ResponseEntity<Syndicat> updateSyndicat(@RequestBody Syndicat syndicat){
        Syndicat upSyndicat= syndicatServices.updateSyndicat(syndicat);
        return new ResponseEntity<>(upSyndicat, HttpStatus.OK);
    }

    @DeleteMapping("admin/syndicat/delete/{id}")
    public ResponseEntity<?> deleteSyndicat(@PathVariable("id") int id){
        syndicatServices.deleleSyndicat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
