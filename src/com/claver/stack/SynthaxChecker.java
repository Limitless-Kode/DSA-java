package com.claver.stack;

import java.util.Arrays;
import java.util.Stack;

public class SynthaxChecker {
    private final String[] tags = {"()","{}","<>","[]"};
    public boolean isValid(String synthax){
        Stack<Character> syntaxCharacters = new Stack<>();

        for(Character character: synthax.toCharArray()){
            if(isOpener(character))
                syntaxCharacters.push(character);

            if(isCloser(character)){
                if(syntaxCharacters.empty()) return false;
                syntaxCharacters.pop();
            }
        }

        return syntaxCharacters.empty();
    }

   private boolean isSynthax(Character character){
        boolean isSynthax = false;
        for (String tag: tags){
            if(character == tag.charAt(0) || character == tag.charAt(1)){
                isSynthax = true;
                break;
            }
        }
        return isSynthax;

   }

    public boolean isOpener(Character character){
        boolean isOpener = false;
        for (String tag: tags){
            if(character == tag.charAt(0)){
                isOpener = true;
                break;
            }
        }
        return isOpener;
    }



    public boolean isCloser(Character character){
        boolean isCloser = false;
        for (String tag: tags){
            if(character == tag.charAt(1)){
                isCloser = true;
                break;
            }
        }
        return isCloser;
    }
}
