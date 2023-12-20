package com.example.User;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController implements ErrorController {

    private final UserRepository repository;

    @RequestMapping("/error")
    public String handleError() {
        // Votre logique pour gérer l'erreur ici
        return "error"; // Peut rediriger vers une page d'erreur personnalisée
    }
    @PostMapping(value = "/saveUser")
    public ModelAndView saveUser(@RequestParam("firstname") String firstname,
                                 @RequestParam("lastname") String lastname,
                                 @RequestParam("email") String email,
                                 @RequestParam ("password") String password) {

        if(firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.print("Veuillez renseigner tout les champs !");
            return null ;
        }

            UserDto userDto = repository.save(UserDto.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .email(email)
                    .password(password)
                    .build());
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("userDto", userDto);
            return modelAndView;
    }

    @GetMapping(value ="/showAllUsers")
    public void showAllUsers(){
        List<UserDto> listAllUsers = new ArrayList<>();
        for (var user: listAllUsers) {
            System.out.println(user + "");
        }
    }

    @GetMapping("/authentification")
    public void authentification(
                           @RequestParam("password") String password,
                           @RequestParam("email") String email){

        Optional<UserDto> userOptional = repository.findByEmail(email);

        if(userOptional.isPresent()){
            UserDto userDto = userOptional.get();

            if(userDto.checkPassword(password)){
                System.out.print("OK");
            }else{
                System.out.print("Mot de passe incorrect");
            }
        }else{
            System.out.println("Utilisateur inconnu, accès refusé");
        }
    }

}
