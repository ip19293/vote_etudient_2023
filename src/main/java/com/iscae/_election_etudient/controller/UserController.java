package com.iscae._election_etudient.controller;


import com.iscae._election_etudient.Login.data.User;
import com.iscae._election_etudient.Login.services.UserServicesImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/election/admin/users")
public class UserController {
    final UserServicesImpl userServices;

    public UserController(UserServicesImpl userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/get/{email}")
    public User getUserFromEmail(@PathVariable("email") String email){
        return userServices.getUser(email);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") Integer id){
        userServices.deleleUser(id);
    }
}
