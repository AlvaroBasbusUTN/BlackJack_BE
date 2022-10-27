package ar.com.blackjack.controllers;

import ar.com.blackjack.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {

    @GetMapping("/crearusuario")
    public User user(@PathVariable String userName, @PathVariable String email, @PathVariable String password){
        User user=new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPoints(0);
        return user;
    }
}
