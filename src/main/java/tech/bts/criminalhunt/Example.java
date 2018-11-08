package tech.bts.criminalhunt;

import tech.bts.criminalhunt.model.Suspect;

public class Example {

    public static void main(String[] args) {

        // I don't like the Suspect constructor from the outside class (it's private)
        // Suspect s1 = new Suspect("John", 18, 180.5, 85.0, "brown","green",true);


        Suspect s = new Suspect.Builder()
                .name("John").age(18).height(180.5)
                .weight(85.0).hair("brown").eye("green")
                .male(true)
                .build();

    }
}


