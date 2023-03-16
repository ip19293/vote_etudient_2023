package com.iscae._election_etudient.services;

import com.iscae._election_etudient.data.Election;
import com.iscae._election_etudient.dto.ElectionDto;

import com.iscae._election_etudient.repository.ElectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ElectionServices implements ElectionDto {
    private  final ElectionRepository electionRepository;
    @Override
    public Election saveElection(Election election) {
        return electionRepository.save(election);
    }

    @Override
    public void deleleElection(Integer id) {
        Election e=electionRepository.findElectionById(id);
        if(e==null){
            throw new RuntimeException("Election introvable");
        }else {
            electionRepository.deleteById(id);
        }

    }

    @Override
    public Election updateElection(Election election) {
        return electionRepository.save(election);
    }

    @Override
    public Election getElection(String sujet) {
        Election e=electionRepository.findElectionBySujet(sujet);
        if(e==null){
           throw new RuntimeException("Election n`exist pas") ;
        }else {
            return  e;
        }

    }

    @Override
    public List<Election> getElections() {
        return electionRepository.findAll();
    }
}
