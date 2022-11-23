package ar.com.blackjack.blackjack.services;

import ar.com.blackjack.blackjack.models.User;

import java.util.List;

public interface UserService {

    public User obtenerUsuario(Long id);

    public List<User> obtenerUsuarios();

    public User guardarUsuario(User user);

    public User findByUserName(String userName);

}
