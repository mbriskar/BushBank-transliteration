package org.bushbank.bushbank.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sentence  {
    private String id;
    private List<SentencePart> parts;

    public List<SentencePart> getParts() {
        return parts;
    }

    public Sentence() {
        this.id=id;
        parts = new ArrayList<SentencePart>();
    }

    public boolean addPart(SentencePart sentencePart) {
        /** do not add duplicate phrases **/
        if (parts.contains(sentencePart) == false) {
            parts.add(sentencePart);
            return true;
        } else {
            return false;
        }
    }
    
}
