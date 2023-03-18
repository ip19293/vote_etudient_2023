package com.iscae._election_etudient.services;

import com.iscae._election_etudient.data.Syndicat;
import com.iscae._election_etudient.dto.SyndicatDto;
import com.iscae._election_etudient.repository.SyndicatRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
@Service
public class SyndicatServices implements SyndicatDto {
  private  final   SyndicatRepository repository;

    public SyndicatServices(SyndicatRepository repository) {
        this.repository = repository;
    }

    @Override
    public Syndicat saveSyndicat(Syndicat syndicat) {
        return repository.save(syndicat);
    }

    @Override
    public void deleleSyndicat(Integer id) {
              Syndicat syndicat=repository.findSyndicatById(id);
              if(syndicat!=null){
                  repository.deleteById(id);
              }
    }

    @Override
    public Syndicat updateSyndicat(Syndicat syndicat) {
        return repository.save(syndicat);
    }

    @Override
    public Syndicat updateSyndicatById(Syndicat syndicat, Integer id) {
        Syndicat syndicat1=repository.findSyndicatById(id);
        if(syndicat1==null){
            throw  new RuntimeException("Syndicat not found");
        }else {
            syndicat.setSyndicatNom(syndicat1.getSyndicatNom());
            syndicat.setLogo(syndicat1.getLogo());
        return    repository.save(syndicat);
        }
    }

    @Override
    public Syndicat getSyndicat(String nom) {
        Syndicat syndicat=repository.findSyndicatBySyndicatNom(nom);
        if(syndicat==null){
            throw  new RuntimeException("syndicat nom introvable");
        }else {
            return  syndicat;
        }
    }

    @Override
    public List<Syndicat> getSyndicats() {
        Sort sort = Sort.by("nombreVote").descending();
        return repository.findAll(sort);
    }
}
