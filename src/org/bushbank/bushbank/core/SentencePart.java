/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bushbank.bushbank.core;

/**
 *
 * @author Mato
 */
public  class SentencePart {
    private String textForm;

    
    public SentencePart() {
    }
    
    public SentencePart(String textForm) {
        this.textForm=textForm;
    }
    
    
    public String getTextForm() {
        return textForm;
    }

    public void setTextForm(String textForm) {
        this.textForm = textForm;
    }

}
