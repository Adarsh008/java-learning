package com.learning.Programs.BasicLogics;

import java.util.HashMap;

public class Anagrams {

    public static Boolean isAngram(String a , String b){
      if(a.length() != b.length() ){
          return false;
      }

        HashMap<Character,Integer> aCount = new HashMap<>();
        HashMap<Character,Integer> bCount = new HashMap<>();

        for(char c : a.toCharArray()){
            aCount.put(c,aCount.getOrDefault(c,0)+1);
        }
        b.chars().forEach(
                c -> bCount.put((char) c,bCount.getOrDefault((char) c,0)+1)
        );

        for ( char q : aCount.keySet()){
            if( !bCount.containsKey(q)  || ! (bCount.get(q) == aCount.get(q))){
                return  false;
            }
        }
    return  true;
    }

    public static void main(String[] args) {

        System.out.println(isAngram("listen", "silent")); // true
        System.out.println(isAngram("hello", "world"));   // false

    }
}
