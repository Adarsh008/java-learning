package com.learning.Programs.BasicLogics;

import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyCounter {
    public static void main(String[] args) {
        String str = "programming";

        Map<Character, Long> frequency = str.chars()
                .mapToObj(s -> (char) s)
                .collect(Collectors.groupingBy(
                        character -> character, Collectors.counting()
                ));


    }
}
