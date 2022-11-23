package ar.com.blackjack.blackjack.controllers;


import ar.com.blackjack.blackjack.DTOS.UserDto;
import ar.com.blackjack.blackjack.models.Play;
import ar.com.blackjack.blackjack.models.User;
import ar.com.blackjack.blackjack.services.UserService;
import ar.com.blackjack.blackjack.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/all")
    public List<User> getAllUser(){
        return userService.obtenerUsuarios();
    }

    @PostMapping("/create")
    public User saveUser(@RequestBody User user){
        return userService.guardarUsuario(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> controlLogin(@RequestBody User user){
        if(user.getUserName()==null || user.getPassword()==null){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Debe ingresar el usuario y contraseña");
        }

        User usuario = userService.findByUserName(user.getUserName());

        if(usuario.getPassword().equals(user.getPassword())){

            UserDto userfront= new UserDto(usuario.getIdUser(), user.getUserName());

            return ResponseEntity.ok(userfront);

        }else{
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o Contraseña incorrectos.");
        }


    }
/*
    @GetMapping("/name/{username}")
    public User obtenerpornombre(@PathVariable String username){

        return userService.findByUserName(username);

    }

 */

    @GetMapping("/{id}")
    public Play obtenerUltimaJugada(@PathVariable Long id){
                User user=userService.obtenerUsuario(id);

                if(user.getPlays().isEmpty()){
                    return null;
                }

                if(user.getPlays().get(user.getPlays().size()-1)  !=null){
                    Play play= user.getPlays().get(user.getPlays().size() -1);
                    return play;
                }

            return null;
    }

}
