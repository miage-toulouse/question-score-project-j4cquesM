package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    QuestionAChoixMultiple questionAChoixMultiple ;
    ScoreCalculateur scoreCalculateur;

    @Before
    public void setUp() throws Exception {
        // given
        this.questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)));
        this.scoreCalculateur = new ScoreCalculateur();


    }

    @Test
    public void testCalculeScoreWhenReponseIsBad() {
        ArrayList<Integer> listIndice = new ArrayList<Integer>(Arrays.asList(1,4));
        float score = scoreCalculateur.calculeScore(listIndice, this.questionAChoixMultiple);

        assertEquals(0f, score ,0.00f);
    }

    @Test
    public void testCalculeScoreWhenReponseIsGood() {
        ArrayList<Integer> listIndice = new ArrayList<Integer>(Arrays.asList(2,3,5));
        float score = scoreCalculateur.calculeScore(listIndice, this.questionAChoixMultiple);

        assertEquals(100f, score ,0.01f);
    }

    @Test
    public void testCalculeScoreWhenReponseIsGoodAndBad() {
        ArrayList<Integer> listIndice = new ArrayList<Integer>(Arrays.asList(2,3));
        float score = scoreCalculateur.calculeScore(listIndice, this.questionAChoixMultiple);
        float scoreAttendu = 200f/3;
        assertEquals(scoreAttendu, score ,0.01f);
    }

    @Test
    public void testCalculeScoreWhenReponseIsBad2() {
        ArrayList<Integer> listIndice = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        float score = scoreCalculateur.calculeScore(listIndice, this.questionAChoixMultiple);

        assertEquals(0f, score ,0.01f);
    }

    @Test
    public void testCalculeScoreWhenReponseIsGoodAndBad2() {
        ArrayList<Integer> listIndice = new ArrayList<Integer>(Arrays.asList(1,2,3));
        float score = scoreCalculateur.calculeScore(listIndice, this.questionAChoixMultiple);
        float scoreAttendu = 50f/3;
        assertEquals(scoreAttendu, score ,0.01f);
    }

}