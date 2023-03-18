package com.iscae._election_etudient.dto;



import com.iscae._election_etudient.data.Etudient;

import java.math.BigInteger;
import java.util.List;

public interface EtudientDto {
    Etudient saveEtudient(Etudient etudientinscription);
    void deleleEtudient(Integer id);
    Etudient updateEtudient(Etudient etudientinscription);
    Etudient getEtudientByEmail(String email);
    List<Etudient> getEtudients();

    Etudient getEtudientFromEmailAndIne(String email, BigInteger INE);
}
