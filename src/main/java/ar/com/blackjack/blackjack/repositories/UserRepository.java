package ar.com.blackjack.blackjack.repositories;

import ar.com.blackjack.blackjack.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

     public User findByUserName(String userName);
 }
