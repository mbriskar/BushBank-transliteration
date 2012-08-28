package org.bushbank.bushbank.nxt;



import java.util.List;
import org.bushbank.bushbank.core.Sentence;
import org.bushbank.bushbank.core.SentencePart;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author xbriskar
 */
public class NxtCorpusTest {

    private NxtCorpus corpus;
    private List<Sentence> sentences;

    private void loadSimpleFull() {
        corpus = new NxtCorpus("test/files/simplefull/simplefull.txt");
        sentences = corpus.getSentences();
    }

   

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testGetSentence() {
        loadSimpleFull();
        for(Sentence sentence : sentences) {
            for(SentencePart sp : sentence.getParts()) {
                System.out.println(sp.getClass() + " : " + sp.getTextForm());
            }
        }
      
        // corpus.getSentences();
    }
 







}