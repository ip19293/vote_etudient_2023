package com.iscae._election_etudient.services;

import com.iscae._election_etudient.data.Candidat;
import com.iscae._election_etudient.data.Etudient;
import com.iscae._election_etudient.dto.CandidatDto;
import com.iscae._election_etudient.repository.CandidatRepository;
import com.iscae._election_etudient.repository.EtudientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CandidatServices implements CandidatDto {
private  final CandidatRepository repository;
private  final EtudientRepository etudientRepository;
@Override
public Candidat addCandidat(Candidat candidat){
    return repository.save(candidat);
}
    @Override
    public void deleteCandidatById(Integer id) {
        Candidat e=repository.findCandidatById(id);
        if(e==null){
            throw new RuntimeException("Candidat introvable");
        }else {
            repository.deleteById(id);
        }

    }

    @Override
    public Candidat updateCandidat(Candidat candidat, Integer id) {
        Candidat e=repository.findCandidatById(id);
        if(e==null){
            throw new RuntimeException("Candidat introvable");
        }else {
          e.setFkEtudient(candidat.getFkEtudient());
          e.setFkSyndicat(candidat.getFkEtudient());
          return repository.save(e);

        }
    }


    @Override
    public List<Candidat> getCandidats() {
        return repository.findAll();
    }

    @Override
    public Etudient getCandidatFromEtudient(Integer id) {
          Etudient etudient=etudientRepository.findEtudientById(id);
        //|| eEmail.getIne()==INE
        if(etudient==null){
            throw new RuntimeException("no");
        }
        else{
            return etudient;
        }

    }


}
