package com.learning.Programs.BasicLogics;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstNonRepetatingCharacter {

    public static Character firstNonRepetationLetter(String testable){

        HashMap<Character,Integer> count = new  LinkedHashMap<>();

        for (char x : testable.toCharArray()){
            count.put(x,count.getOrDefault(x,0)+1);
        }

        for ( char x : count.keySet()){
            if(count.get(x) == 1){
                System.out.println("First NON REPETATING CHARACTER "+  x);
                return x;
            }
        }
        return 'j';
    }

    public static void main(String[] args) {
        firstNonRepetationLetter("dgdgdgdgdefg");
    }
}
