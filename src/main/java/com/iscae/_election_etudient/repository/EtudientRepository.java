package com.iscae._election_etudient.repository;


import com.iscae._election_etudient.data.Etudient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface EtudientRepository extends JpaRepository<Etudient,Integer> {
    Etudient findEtudientById(Integer id);

    Etudient findEtudientByEmail(String email);

    Etudient findEtudientByIne(BigInteger ine);

    Etudient findByEmail(String email);
}
