package com.iscae._election_etudient.Login.services;


import com.iscae._election_etudient.Login.Repository.UserRepository;
import com.iscae._election_etudient.Login.data.Role;
import com.iscae._election_etudient.Login.data.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServicesImpl implements UserServices{
    private  final UserRepository userRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to the database");
        return userRepo.save(user);
    }

    @Override
    public void deleleUser(Integer id) {
        userRepo.deleteById(id);
    }


    @Override
    public void addRoleToUser(String email, Role roleNom) {
        log.info("Add a role {} to the User {}",roleNom,email);
       User user=userRepo.findByEmail(email);
       if(user==null){
           throw new UsernameNotFoundException("user not found");
       }else {
           user.setRole(roleNom);
       }

    }

    @Override
    public User getUser(String email) {
        log.info("Fetching user {} ",email);
        User user=userRepo.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("user not found");
        }else {
            return user;
        }
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
