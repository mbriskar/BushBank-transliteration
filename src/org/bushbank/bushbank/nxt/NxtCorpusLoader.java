/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bushbank.bushbank.nxt;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.nite.meta.impl.NiteMetaData;
import net.sourceforge.nite.meta.impl.NiteMetaException;
import net.sourceforge.nite.nom.NOMException;
import net.sourceforge.nite.nom.nomwrite.NOMElement;
import net.sourceforge.nite.nom.nomwrite.impl.NOMWriteAnnotation;
import net.sourceforge.nite.nom.nomwrite.impl.NOMWriteAttribute;
import net.sourceforge.nite.nom.nomwrite.impl.NOMWriteCorpus;
import net.sourceforge.nite.nom.nomwrite.impl.NOMWriteElement;
import net.sourceforge.nite.nom.nomwrite.impl.NOMWritePointer;
import org.bushbank.bushbank.core.Mark;
import org.bushbank.bushbank.core.Sentence;
import org.bushbank.bushbank.core.SentencePart;
import org.bushbank.bushbank.core.Token;

/**
 *
 * @author Mato
 */
public class NxtCorpusLoader {

    private File file;

    Set<String> others = new HashSet<String>() { // parts that are not tokens nor marks
        {
            add("|");
            add(",");
            add("!");
        }
    };

    public NxtCorpusLoader(String filePath) {
        file = new File(filePath);

    }

    public List<Sentence> getSentences() {
        List<String> parts = getAllParts();
        List<Sentence> sentences = new ArrayList<Sentence>();
        Sentence sentence = new Sentence();
        for (int i = 0; i < parts.size(); i++) {
            String part = parts.get(i);
            if (part.startsWith("<")) {
                Mark mark = new Mark(part);
                sentence.addPart(mark);
                continue;
            } else if (others.contains(part)) {
                SentencePart sp = new SentencePart(part);
                sentence.addPart(sp);
            } else if (part.equals(".")) {
                sentences.add(sentence);
                sentence = new Sentence();
            } else {
                //token
                if (i+3< parts.size() && parts.get(i+3).equals("<2děle2")) {
                    Token token = new Token(part + parts.get(i + 1) + parts.get(i + 2));
                    token.addTokenPart(part);
                    token.addTokenPart(parts.get(i + 2));
                    sentence.addPart(token);
                    i=i+5;
                    
                } else {
                    Token token = new Token(part);
                    sentence.addPart(token);
                }
            }

        }
        return sentences;
    }

    private List<String> getAllParts() {
        Scanner sc2 = null;
        try {
            sc2 = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> words = new ArrayList<String>();
        while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
            while (s2.hasNext()) {
                String s = s2.next();
                words.add(s);
            }
        }

        return words;
    }

    public List<Sentence> loadSentences() {

        List<Sentence> sentences = getSentences();

        return sentences;
    }
}
