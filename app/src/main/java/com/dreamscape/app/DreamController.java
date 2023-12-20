package com.dreamscape.app;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RequestMapping("/api/v1/dreamscape")
@RequiredArgsConstructor
@RestController
public class DreamController implements ErrorController {


    private final DreamServiceImpl service;
    @RequestMapping("/error")
    public String handleError() {
        // Votre logique pour gérer l'erreur ici
        return "error"; // Peut rediriger vers une page d'erreur personnalisée
    }
    @PostMapping(value = "/saveDream")
    public ResponseEntity<DreamDTO> save(@RequestBody DreamDTO dreamDTO) {
        Optional<DreamDTO> savedDreamOptional = Optional.ofNullable(service.save(dreamDTO));
        return savedDreamOptional.
                map(savedDream -> ResponseEntity.ok().body(savedDream))
                .orElse(ResponseEntity.badRequest().build());
    }

//    @PostMapping("/saveUser")
//    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
//        User user = new User();
//        user.setFirstname(userDto.getFirstname());
//        user.setLastname(userDto.getLastname());
//        user.setEmail(userDto.getEmail());
//
////        User savedUser = service.saveUser(userDto);
//
//
//        UserDto savedUserDto = new UserDto();
//        savedUserDto.setFirstname(savedUser.getFirstname());
//        savedUserDto.setLastname(savedUser.getLastname());
//        savedUserDto.setEmail(savedUser.getEmail());
//
//        // Retourner la réponse avec les données de l'utilisateur enregistré
//        return ResponseEntity.ok(savedUserDto);
//    }
    @GetMapping(value = "/findAll")
    public List<DreamDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity <List<DreamDTO>> findDreamByUser(
            @PathVariable ("userId") Integer userId
    )
    {
        return service.findAllDreamByUser(userId);
    }
//    @PostMapping("/saveUser")
//    public ResponseEntity<String> saveUser(@RequestBody UserDto userDTO) {
//        // Appel du microservice "User" via Feign pour sauvegarder l'utilisateur
//        UserDto savedUser = client.saveUser(userDTO);
//
//        // Gérer la réponse en fonction du résultat de la sauvegarde
//        if (savedUser != null) {
//            return ResponseEntity.ok("Utilisateur sauvegardé avec succès !");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la sauvegarde de l'utilisateur");
//        }
//    }


//    public ResponseEntity <UserDto> saveUser(@RequestBody UserDto userDto) {
//        Optional<UserDto> userSavedOptional = Optional.ofNullable(service.save(userDto));
//        return userSavedOptional.
//                map(savedUser -> ResponseEntity.ok().body(savedUser))
//                .orElse(ResponseEntity.badRequest().build());

//        // Récupération des données du formulaire
//        String firstname = request.getParameter("firstname");
//        String lastname = request.getParameter("lastname");
//        String email = request.getParameter("email");
//        // ... autres champs du formulaire
//
//        // Validation des données (à faire)
//
//        // Création d'un objet représentant les données à sauvegarder
//        userDto.setFirstname(firstname);
//        userDto.setLastname(lastname);
//        userDto.setEmail(email);
//        // ... setter pour d'autres champs
//
//        // Utilisation d'un service ou gestionnaire pour sauvegarder les données dans la base de données
//        service.saveU(userDto);
//
//        // Réponse au client
//        response.setContentType("text/html");
//    }
}



