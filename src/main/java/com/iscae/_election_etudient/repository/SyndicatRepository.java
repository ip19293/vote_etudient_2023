package com.iscae._election_etudient.repository;


import com.iscae._election_etudient.data.Syndicat;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SyndicatRepository extends JpaRepository<Syndicat,Integer> {
    Syndicat findSyndicatBySyndicatNom(String nom);
    List<Syndicat> findAll(Sort sort);

    Syndicat findSyndicatById(Integer id);
}
