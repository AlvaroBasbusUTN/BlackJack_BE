package ar.com.blackjack.blackjack.services;

import ar.com.blackjack.blackjack.models.User;
import ar.com.blackjack.blackjack.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public List<User> obtenerUsuarios(){
        return  userRepository.findAll();
    }

    @Override
    public User guardarUsuario(User user){
        return userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User obtenerUsuario(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
