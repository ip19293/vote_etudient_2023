package com.iscae._election_etudient.repository;

import com.iscae._election_etudient.data.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatRepository  extends JpaRepository<Candidat,Integer> {
    Optional<Candidat> findCandidatById(Integer id);

    void deleteCandidatById(Integer id);
}
