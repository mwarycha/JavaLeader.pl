package pl.javaleader.map;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DemoMap {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        List<Boolean> integerListAfterMap = integerList.stream().map(
                x -> x % 2 == 0
        ).collect(Collectors.toList());

        System.out.println(integerListAfterMap);

        Function<Integer, Boolean> evenNumber = x -> x % 2 == 0;
        List<Boolean> integerListAfterMapUsingPredicate = integerList.stream().map(
                evenNumber
        ).collect(Collectors.toList());

        System.out.println(integerListAfterMapUsingPredicate);

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        System.out.println(listOfLists);

        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());

        System.out.println(listOfAllIntegers);

    }

}
