package com.learning.functionalProgramming.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {
        //1. To create a stream from collection using .stream()
        Stream<Integer> streamIntegerFromList = List.of(1,2,3,4).stream();
        Stream<Integer> streamIntegerFromArrayList = new ArrayList<>(List.of(1,2,3,4)).stream();
        //Flatmap usage
        Stream<List<Integer>> streamInt = Stream.of(List.of(1,2,3,4));

        //2. To create from array using Arrays.stream()
        int [] a = {1,2,3,4};
        Stream<Integer> streamIntegerFromArray = Arrays.stream(a).boxed();
        int [] arr = IntStream.rangeClosed(1,5).toArray();
        System.out.println(Arrays.toString(arr));

        //3. Stream.of -->
        Stream<String> streamStringOf = Stream.of("fdf","2,676","frf" ,"89.76");

        //Below two helps in creating infinite streams
        //.generate method
        Stream<String> streamFromGenerate = Stream.generate(()->"Generate").limit(76);

        //.iterate method
        Stream<String> stringFromStream = Stream.iterate( "s", x-> "a" +x);

    }
}
