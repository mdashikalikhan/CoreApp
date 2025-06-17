package com.interview.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByStringLength {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape",
                "a", "b", "c");
        Map<Integer, List<String>> groupingByLength
                = stringList.stream().collect(Collectors.groupingBy(String::length));

        groupingByLength.forEach((len, str)-> System.out.println(len + ": " + str));

        List<StreamEmployee> list = List.of(
                new StreamEmployee("ASHIK", 30),
                new StreamEmployee("RAHIM", 30),
                new StreamEmployee("KARIM", 45),
                new StreamEmployee("IFTEKHAR", 45),
                new StreamEmployee("AKRAM", 40)
        );



        Map<Integer, List<StreamEmployee>> map = list.stream().collect(
                Collectors.groupingBy(StreamEmployee::getAge)
        );

        System.out.println(map);

        Map<Integer, String> mapByAge = list.stream().collect(
                Collectors.groupingBy(StreamEmployee::getAge,
                        Collectors.mapping(StreamEmployee::getName, Collectors.joining(", ")))
        );

        System.out.println(mapByAge);

        list.stream().sorted((a,b)-> a.age-b.age).map(a->a.getAge()).distinct().forEach(System.out::println);


        Map<Character, Long> occurences = stringList.stream()
                .flatMap(s -> s.chars().mapToObj(c -> (char) c))
                .collect(Collectors.groupingBy(c -> c,
                        Collectors.counting()));

        System.out.println(occurences);

        List<List<String>> listOfLists = List.of(
                List.of("Apple", "Banana"),
                List.of("Carrot", "Daikon"),
                List.of("Eggplant")
        );

        Map<Integer, List<String>> stringLengthGroup = listOfLists.stream().flatMap(List::stream)
                .collect(Collectors.groupingBy(String::length));

        System.out.println(stringLengthGroup);

        List<Character> listChar =
                listOfLists.stream()
                        .flatMap(List::stream)
                        .flatMap(s->s.chars()
        .mapToObj(c -> (char) c)).distinct()
                .collect(Collectors.toList());

        System.out.println(listChar);

        String str = "ZMBXNCVCQPIOIRUTYTYLAKDJGJHSJBDJHBHJBFJIWEIUIENMBMNDB";

        Map<Character, Long> charFrequency = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c,
                        Collectors.counting()));

        System.out.println(charFrequency);


    }
}

@Data
@AllArgsConstructor
class StreamEmployee{
    String name;
    int age;
}
