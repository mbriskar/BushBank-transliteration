package org.bushbank.bushbank.core;

import java.util.ArrayList;
import java.util.List;


public class Token extends SentencePart{

    private List<String> tags;
    private List<String> tokenParts;



    public Token() {
        
    }

    public Token(String textForm) {
        super(textForm);
    }

    public void addTokenPart(String part) {
        if(tokenParts == null) {
            tokenParts = new ArrayList<String>();
        }
        tokenParts.add(part);
    }





    @Override
    public String toString() {
        return null;
        
    }
}
