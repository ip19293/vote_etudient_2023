package com.iscae._election_etudient.controller;


import com.iscae._election_etudient.controller.request_response.VoteRequest;
import com.iscae._election_etudient.controller.request_response.VoteResponse;
import com.iscae._election_etudient.controller.request_response.verificationRequest;
import com.iscae._election_etudient.data.Etudient;
import com.iscae._election_etudient.data.Syndicat;
import com.iscae._election_etudient.services.EmailSenderServices;
import com.iscae._election_etudient.services.EtudientServices;
import com.iscae._election_etudient.services.SyndicatServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/election/")
public class EtudientController {
    final EmailSenderServices senderServices;
    final EtudientServices etudientServices;
final SyndicatServices syndicatServices;
    public EtudientController(EmailSenderServices senderServices, EtudientServices etudientServices, SyndicatServices syndicatServices) {
        this.senderServices = senderServices;
        this.etudientServices = etudientServices;
        this.syndicatServices = syndicatServices;
    }
    @PostMapping("public/vote/validation")
    public VoteResponse voter(@RequestBody VoteRequest voteRequest){
        Etudient etudient=etudientServices.getEtudientByEmail(voteRequest.getEmail());
        Syndicat syndicat=syndicatServices.getSyndicat(voteRequest.getSyndicatNom());
        VoteResponse recu = new VoteResponse();
        recu.setNom(etudient.getNom());
        recu.setPrenom(etudient.getPrenom());
        recu.setEmail(etudient.getEmail());
        recu.setLogo(syndicat.getLogo());
        recu.setSyndicatNom(syndicat.getSyndicatNom());
        recu.setNBRV(syndicat.getNombreVote());
        String code=etudient.getIne().toString()+ (etudient.getDateNaissance().toString().replace('-','0'));
        if(syndicat!=null && etudient!=null && code.equals(voteRequest.getCode().toString()) && etudient.getEstVote()==0){
             int voteurs=syndicat.getNombreVote()+1;
            syndicat.setNombreVote(voteurs);
           etudient.setEstVote(1);
           syndicatServices.saveSyndicat(syndicat);
           etudientServices.saveEtudient(etudient);
           return recu;
        } else if (syndicat!=null && etudient!=null && code.equals(voteRequest.getCode()) && etudient.getEstVote()==1) {
         return  recu;
        } else {
            throw new RuntimeException("vote non success ");
        }

    }
    @GetMapping("public/vote/get/{email}")
    public Etudient getUserFromEmail(@PathVariable("email") String email){
        Etudient etudient=etudientServices.getEtudientByEmail(email);
        if(etudient!=null){
        String code=etudient.getIne()+ etudient.getDateNaissance().toString().replace('-','0');
            senderServices.sendEmail(email,"Code de vote ",code);
        }
        //senderServices.sendEmail(email,"Code de vote "," this is a code");
        return etudientServices.getEtudientByEmail(email);
    }
    @GetMapping("public/etudient/all")
    public ResponseEntity<List<Etudient>> getAllEtudients (){
        List<Etudient> etudients = etudientServices.getEtudients();
        return new ResponseEntity<>(etudients, HttpStatus.OK);
    }

    @PostMapping("public/etudient/add")
    public ResponseEntity<Etudient> addEtudient(@RequestBody Etudient etudient){
        Etudient newEtudient = etudientServices.saveEtudient(etudient);
        return new ResponseEntity<>(newEtudient, HttpStatus.CREATED);
    }

    @GetMapping("public/vote/verification")
    public ResponseEntity<Etudient> verificationVote(@RequestBody verificationRequest et){
        Etudient newEtudient = etudientServices.getEtudientFromEmailAndIne(et.getEmail(), et.getINE());
        return new ResponseEntity<>(newEtudient, HttpStatus.CREATED);
    }



    @PutMapping("public/etudient/update/")
    public ResponseEntity<Etudient> updateEtudient(@RequestBody Etudient etudient){
        Etudient upEtudient = etudientServices.updateEtudient(etudient);
        return new ResponseEntity<>(upEtudient, HttpStatus.OK);
    }

    @DeleteMapping("admin/etudient/delete/{id}")
    public ResponseEntity<?> deleteEtudient(@PathVariable("id") int id){
        etudientServices.deleleEtudient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
