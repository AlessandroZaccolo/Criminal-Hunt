package tech.bts.criminalhunt;

import org.junit.Before;
import org.junit.Test;
import tech.bts.criminalhunt.analyser.SuspectAnalyser;
import tech.bts.criminalhunt.model.Suspect;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SuspectAnalyserTest {

    private Suspect.Builder s1Builder;
    private Suspect.Builder s2Builder;


    @Before
    public void suspects(){

        this.s1Builder = new Suspect.Builder();
        this.s2Builder = new Suspect.Builder();

        s1Builder.name("John").age(18).height(180.5).weight(85.0)
                .hair("brown").eye("green").male(true).build();

        s2Builder.name("John").age(18).height(180.5).weight(85.0).
                hair("brown").eye("green").male(true).build();

    }

    @Test
    public void match_if_same_values() {

        SuspectAnalyser suspectAnalyser = new SuspectAnalyser();

        Suspect s1 = s1Builder.build();
        Suspect s2 = s2Builder.build();

        boolean result = suspectAnalyser.match(s1, s2);

        assertTrue(result);

    }

    @Test
    public void test_very_similar(){

        // 1 - setup the objects you need. The suspect has 5 or more points.
        SuspectAnalyser suspectAnalyser = new SuspectAnalyser();
        Suspect s1 = s1Builder.build();

        Suspect s2 = new Suspect.Builder()
                .name("john").age(19).height(182.5)
                .weight(81.0).hair("brown").eye("black")
                .male(true).build();

        // 2 - call same method.
        boolean result = suspectAnalyser.match(s1, s2);


        // 3 - check that the result is the one expected.
        assertTrue(result);
    }




    @Test
    public void test_completely_different_suspects(){

        // 1 - setup the objects you need. The suspect 4 points but name, age, height, weight are the same
        SuspectAnalyser suspectAnalyser = new SuspectAnalyser();

        Suspect s1 = s1Builder.build();

        Suspect s2 = new Suspect.Builder()
                .name("Anna").age(25).height(170.2)
                .weight(75.0).hair("blonde").eye("grey")
                .male(false).build();

        // 2 - call same method.
        boolean result = suspectAnalyser.match(s1, s2);

        // 3 - check that the result is the one expected.
        assertFalse(result);

    }


    @Test
    public void test_equal_suspects_with_change_hair_and_eye_colors(){

        // 1 - setup the objects you need. The suspect 4 points but name, age, height, weight are the same
        SuspectAnalyser suspectAnalyser = new SuspectAnalyser();

        Suspect s1 = s1Builder.build();

        Suspect s2 = new Suspect.Builder()
                .name("john").age(18).height(180.5)
                .weight(85.0).hair("blonde").eye("grey")
                .male(true).build();

        // 2 - call same method.
        boolean result = suspectAnalyser.match(s1, s2);

        // 3 - check that the result is the one expected.
        assertTrue(result);

    }



    @Test
    public void test_equal_method (){

        // 1 - setup the objects you need. The suspect has 5 or more points.

        SuspectAnalyser suspectAnalyser = new SuspectAnalyser();

        Suspect s1 = s1Builder.build();

        Suspect s2 = new Suspect.Builder()
                .name("john").age(19).height(179.0)
                .weight(82.0).hair("brown").eye("black")
                .male(true).build();

        // 2 - call same method.
        boolean match = s1.equals(s2);

        // 3 - check that the result is the one expected.
        assertTrue(match);

    }



}
