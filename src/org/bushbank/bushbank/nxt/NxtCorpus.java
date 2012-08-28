package org.bushbank.bushbank.nxt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.nite.nom.NOMException;

import org.bushbank.bushbank.core.Sentence;



public class NxtCorpus {

    private NxtCorpusLoader corpusLoader;
    private List<Sentence> sentences = null;


    /**
     * Initialization of corpus, no data are loaded *
     */
    public NxtCorpus(String filepath) {
        corpusLoader = new NxtCorpusLoader(filepath);
       
    }


    /**
     * Load sentences with phrases, tokens and syntax relations *
     */
    public List<Sentence> getSentences() {
        if (sentences == null) {
            sentences = corpusLoader.loadSentences();
        }
        return sentences;
    }

    public NxtCorpusLoader getCorpusLoader() {
        return corpusLoader;
    }


  




}
