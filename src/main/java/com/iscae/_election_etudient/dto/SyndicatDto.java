package com.iscae._election_etudient.dto;



import com.iscae._election_etudient.data.Syndicat;

import java.util.List;

public interface SyndicatDto {
    Syndicat saveSyndicat(Syndicat syndicat);
    void deleleSyndicat(Integer id);
    Syndicat updateSyndicat(Syndicat syndicat);
    Syndicat updateSyndicatById(Syndicat syndicat,Integer id);
    Syndicat getSyndicat(String nom);
    List< Syndicat> getSyndicats();
}
