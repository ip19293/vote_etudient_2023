package com.iscae._election_etudient.repository;


import com.iscae._election_etudient.data.Etudient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudientRepository extends JpaRepository<Etudient,Integer> {
    Etudient findEtudientById(Integer id);

    Etudient findEtudientByEmail(String email);

    Etudient findEtudientByIne(String ine);
}
