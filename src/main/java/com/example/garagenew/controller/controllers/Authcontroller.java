package com.example.garagenew.controller.controllers;
import com.example.garagenew.Payloads.LoginRequest;
import com.example.garagenew.Payloads.SignupRequest;
import com.example.garagenew.container.UserContainer;
import com.example.garagenew.domein.Gebruiker;
import com.example.garagenew.domein.Role;
import com.example.garagenew.domein.enumerations.RolEnum;
import com.example.garagenew.repository.RoleRepository;
import com.example.garagenew.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("api/auth")
@RestController
public class Authcontroller {
    UserRepository userRepository;

    RoleRepository roleRepository;

    Authcontroller(UserRepository userRes,RoleRepository roleRes){
        userRepository = userRes;
        roleRepository = roleRes;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignupRequest request){
        System.out.println(request.toString());
        //Check of de usernaam al bestaat in de database je kan een zelfde soort check doen met de email als dat nodig is.
        if(!userRepository.existsByUsername(request.getUsername())){

            //Check nog even voor de zekerheid dat het wachtwoord niet leeg is. Niet nodig, maar users zonder wachtwoord kunnen moeilijk inloggen
            if(!request.getWachtwoord().isEmpty()){
                //Door de builder annotatie kunnen we simpel een gebruiker object aanmaken via deze manier
                //De builder annotatie heeft de noargs en allargs annotaties nodig. Check gebruiker class
                Gebruiker newUser = Gebruiker.builder()
                        .username(request.getUsername())
                        .wachtwoord(request.getWachtwoord())
                        .emailadres(request.getEmail())
                        .build();

                //Voeg de rollen toe na het bepalen van de rollen

                Set<Role> bevoegdeRollen = bepaalRollen(request.getRollen());
                newUser.setRoles(bevoegdeRollen);

                //Probeer de nieuwe gebruiker op te slaan in database
                try{
                    userRepository.save(newUser);
                    //Account is aangemaakt en geeft de naam van het account mee terug in het response
                    return ResponseEntity.ok().body(String.format("Account met de naam %s is aangemaakt",request.getUsername()));
                }catch (Exception e){
                    //Als er wat fout gaat logt hij de error en geeft hij een error terug aan de indiener
                    System.out.println("Error: " + e.getMessage());
                    return ResponseEntity.internalServerError().body("er ging iets fout. Account kan niet aangemaakt worden.");
                }

            }
            else{
                return ResponseEntity.badRequest().body("Wachtwoord is niet valide.");
            }
        }
            return ResponseEntity.badRequest().body("Gebruikersnaam is niet valide of bestaat al.");
    }



    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest request){

        //Check of user bestaat bij username of email
        if(userRepository.existsByUsername(request.getUsername())){
            //Haal gegevens van de gebruiker op
            Gebruiker foundUser = userRepository.findByUsername(request.getUsername());

            //Vergelijk de wachtwoorden
            if(foundUser.getWachtwoord().equals(request.getWachtwoord())){
                //De reden dat we hier nu geen specifiek UserContainer object nodig hebben is omdat we een static method aan willen roepen
                //Deze kun je direct op de class aanroepen en hebben geen instantie nodig.
                UserContainer.setGebruiker(foundUser);

                return ResponseEntity.ok().body(String.format("Account %s is ingelogd",UserContainer.getLoggedInGebruiker().getUsername()));
            }

        }
        return ResponseEntity.badRequest().body("Inloggegevens zijn incorrect");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        UserContainer.logout();
        return ResponseEntity.ok().body("Gebruiker is uitgelogd");
    }

    @GetMapping("/active")
    public ResponseEntity<?> getloggedin(){
        return ResponseEntity.ok().body(UserContainer.getLoggedInGebruiker().getUsername());
    }


    private Set<Role> bepaalRollen(Set<RolEnum> rollen) {
        Set<Role> lijst = new HashSet<>();
        //Als er geen rollen zijn in het request geef dan allen user rechten terug
        if(rollen == null){

            lijst.add(roleRepository.findByName(RolEnum.USER));
            return lijst;
        }else{
            for (RolEnum r: rollen) {
                lijst.add(roleRepository.findByName(r));
            }
        }
        //Als er rollen meegeven zijn geef deze dan aan het account.
        return lijst;
    }




}
