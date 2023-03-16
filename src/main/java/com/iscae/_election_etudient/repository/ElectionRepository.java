package com.iscae._election_etudient.repository;

import com.iscae._election_etudient.data.Election;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election,Integer> {

    Election findElectionById(Integer id);

    Election findElectionBySujet(String sujet);
}
