package com.iscae._election_etudient.services;

import com.iscae._election_etudient.data.Etudient;
import com.iscae._election_etudient.dto.EtudientDto;

import com.iscae._election_etudient.repository.EtudientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EtudientServices implements EtudientDto {
    private  final EtudientRepository etudientRepository;
    @Override
    public Etudient saveEtudient(Etudient etudientinscription) {
        return etudientRepository.save(etudientinscription);
    }

    @Override
    public void deleleEtudient(Integer id) {
        Etudient e=etudientRepository.findEtudientById(id);
        if(e==null){
            throw new RuntimeException("Etudient introvable");
        }else {
            etudientRepository.deleteById(id);
        }

    }

    @Override
    public Etudient updateEtudient(Etudient etudientinscription) {
        return etudientRepository.save(etudientinscription);
    }

    @Override
    public Etudient getEtudientByEmail(String email) {
        Etudient e=etudientRepository.findEtudientByEmail(email);
        if(e==null){
            throw new RuntimeException("etudient n`existe pas");
        }
        return e;
    }

    @Override
    public List<Etudient> getEtudients() {
        return etudientRepository.findAll();
    }

    @Override
    public Etudient getEtudientFromEmailAndIne(String email, String INE) {
        Etudient eEmail=etudientRepository.findEtudientByEmail(email);
        Etudient eINE=etudientRepository.findEtudientByIne(INE);
        //|| eEmail.getIne()==INE
        if(eINE==null ||eEmail==null ){
           throw new RuntimeException("no");
        }
        else{
            return eEmail;
        }

    }
}
