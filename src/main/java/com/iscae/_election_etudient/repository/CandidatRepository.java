package com.iscae._election_etudient.repository;

import com.iscae._election_etudient.data.Candidat;
import com.iscae._election_etudient.data.Candidat;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidatRepository  extends JpaRepository<Candidat,Integer> {

    void deleteCandidatById(Integer id);

   Candidat findCandidatById(Integer id);
}
