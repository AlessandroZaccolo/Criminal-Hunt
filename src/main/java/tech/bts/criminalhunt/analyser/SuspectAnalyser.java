package tech.bts.criminalhunt.analyser;


import tech.bts.criminalhunt.model.Suspect;

public class SuspectAnalyser {

    public boolean match(Suspect s1, Suspect s2) {

        int count = 0;

        if (s1.isMale() == s2.isMale()) {
            if (s1.getName().equalsIgnoreCase(s2.getName())) {
                count++;
            }
            if (Math.abs(s1.getAge() - (s2.getAge())) <= 1) {
                count++;
            }
            if (Math.abs(s1.getHeight() - s2.getHeight()) <= 2.0) {
                count++;
            }
            if (Math.abs(s1.getWeight() - s2.getWeight()) <= 5.0) {
                count++;
            }
            if (s1.getHair().equals(s2.getHair())) {
                count++;
            }
            if (s1.getEye().equals(s2.getEye())) {
                count++;
            }
            if (count >= 5 || (count == 4 && (s1.getName().equalsIgnoreCase(s2.getName())
                    && (s1.getAge() == s2.getAge()) && (s1.getHeight() == s2.getHeight())
                    && (s1.getWeight() == s2.getWeight())))){
                return true;
            }
            return false;
        } else {
            return false;
        }

    }

}
