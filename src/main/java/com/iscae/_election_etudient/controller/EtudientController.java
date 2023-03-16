package com.iscae._election_etudient.controller;


import com.iscae._election_etudient.controller.request_response.verificationRequest;
import com.iscae._election_etudient.data.Etudient;
import com.iscae._election_etudient.services.EtudientServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/election/")
public class EtudientController {

    final EtudientServices etudientServices;

    public EtudientController(EtudientServices etudientServices) {
        this.etudientServices = etudientServices;
    }

    @GetMapping("public/vote/get/{email}")
    public Etudient getUserFromEmail(@PathVariable("email") String email){
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
