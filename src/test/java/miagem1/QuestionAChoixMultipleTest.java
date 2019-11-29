package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {
    private QuestionAChoixMultiple qcm;
    private List<Integer> answers;
    private Integer rep1;
    private Integer rep2;

    @Before
    public void setUp() throws Exception {
        // given : une question à choix multiple
        answers = new LinkedList<Integer>();
        rep1 = new Integer(1);
        rep2 = new Integer(4);
        answers.add(0, rep1);
        answers.add(1, rep2);
        qcm = new QuestionAChoixMultiple("Cochez deux couleurs",answers);
    }

    @Test
    public void testGetEnonce() {
        // when : l'énnoncé est demande
        String ennonce = qcm.getEnonce();
        // then : l'énnonéc est non nul
        assertNotNull(ennonce);
        // and : l'énnoncé est égal à la question du constructeur
        assertEquals(ennonce,"Cochez deux couleurs");
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        // when : on demande le score pour un indice
        float resScore = qcm.getScoreForIndice(1);
        // then : Le score retourné est 100 donc l'indice de la bonne réponse est bien celui fourni à la construction
        assertEquals("L'indice ne correspond pas !", 100/2.0, resScore, 0.0);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        // When : on demande le score pour un indice
        float resScore = qcm.getScoreForIndice(2);
        // then : Le socre retourné est 0 donc l'indice de la réponse n'est pas l'un de ceux fournis à la construction
        assertEquals("L'indice ne correspond pas !", 0, (resScore < 0) ? 0 : resScore, 0.0);
    }
}