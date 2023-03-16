package com.iscae._election_etudient.dto;



import com.iscae._election_etudient.data.Election;

import java.util.List;

public interface ElectionDto {

    Election saveElection(Election election);
    void deleleElection(Integer id);
    Election updateElection(Election election);
    Election getElection(String sujet);
    List< Election> getElections();

}
