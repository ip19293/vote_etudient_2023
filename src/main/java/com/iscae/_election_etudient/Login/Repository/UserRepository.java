package com.iscae._election_etudient.Login.Repository;



import com.iscae._election_etudient.Login.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
  User findByEmail(String email);


}
