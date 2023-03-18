package com.iscae._election_etudient.dto;

import com.iscae._election_etudient.data.Candidat;
import com.iscae._election_etudient.data.Etudient;

import java.util.List;

public interface CandidatDto {
    Candidat addCandidat(Candidat candidat);

    void deleteCandidatById(Integer id);

    Candidat updateCandidat(Candidat candidat, Integer id);

    List<Candidat> getCandidats();

    Etudient getCandidatFromEtudient(Integer id);
}
