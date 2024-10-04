package com.example.garagenew.container;

import com.example.garagenew.domein.Gebruiker;
import org.springframework.web.context.annotation.ApplicationScope;

//Application-scoped geeft aan dat er maar 1 instantie is van deze class door de hele applicatie heen
@ApplicationScope
public class UserContainer {

    //in principe kan je dit object aanroepen om gegevens van de gebruiker uit te halen,
    //maar pas op. Dit object staat nu los van de database en de database bevat de gegevens zoals ze laatst zijn opgeslagen.
    private static Gebruiker loggedInGebruiker;

    public static void setGebruiker(Gebruiker gebruiker){
        loggedInGebruiker = gebruiker;
    }

    public static Gebruiker getLoggedInGebruiker(){
        return loggedInGebruiker;
    }

    public static void logout(){
        loggedInGebruiker = null;
    }


}
