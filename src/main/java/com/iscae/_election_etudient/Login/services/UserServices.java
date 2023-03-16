package com.iscae._election_etudient.Login.services;




import com.iscae._election_etudient.Login.data.Role;
import com.iscae._election_etudient.Login.data.User;

import java.util.List;

public interface UserServices {
    User saveUser(User user);
    void deleleUser(Integer id);
    void addRoleToUser(String email, Role role);
    User getUser(String email);
    List<User> getUsers();
}
