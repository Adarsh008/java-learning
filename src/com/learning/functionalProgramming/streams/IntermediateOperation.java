package com.learning.functionalProgramming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperation {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Rick" ,"Rondy","RAdarsh","Bakhshish","himesh");

        //1)Filter -> accepts predicate
        List<String> namesStartWithR =  names.stream().filter( name -> name.startsWith("R")).collect(Collectors.toList());
        System.out.println(namesStartWithR);

        //2)Map -> accepts function
        List<String> nameUpperCase =  names.stream().map(x-> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(nameUpperCase);

        //3)Sorted -> sorts
        List<String> sortedList = names.stream().sorted().toList();
        System.out.println(sortedList);

        //4) Distinct --> removes duplicates
        Stream<String> distinctNames = names.stream().distinct();
        System.out.println(distinctNames.toList());

        //5)limit --> limit the output of the stream
        Stream<String> limit = Stream.generate(() -> "rfnrfnir").limit(78);
        System.out.println(limit.toList());

        //6) Skip -> skip the given n no of starting outputs
        System.out.println(Stream.iterate(1,x->x+2).skip(10).limit(10).toList());
    }
}
