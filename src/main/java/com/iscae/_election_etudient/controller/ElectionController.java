package com.iscae._election_etudient.controller;

import com.iscae._election_etudient.data.Election;

import com.iscae._election_etudient.services.ElectionServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/election/")
public class ElectionController {
    final ElectionServices electionServices;

    public ElectionController(ElectionServices electionServices) {
        this.electionServices = electionServices;
    }
    @GetMapping("public/election/all")
    public ResponseEntity<List<Election>> getAllElections (){
        List<Election> elections = electionServices.getElections();
        return new ResponseEntity<>(elections, HttpStatus.OK);
    }

    @PostMapping("public/election/add")
    public ResponseEntity<Election> addElection(@RequestBody Election election){
        Election newElection= electionServices.saveElection(election);
        return new ResponseEntity<>(newElection, HttpStatus.CREATED);
    }


    @PutMapping("public/election/update/")
    public ResponseEntity<Election> updateElection(@RequestBody Election election){
        Election upElection= electionServices.updateElection(election);
        return new ResponseEntity<>(upElection, HttpStatus.OK);
    }

    @DeleteMapping("admin/election/delete/{id}")
    public ResponseEntity<?> deleteElection(@PathVariable("id") int id){
        electionServices.deleleElection(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
