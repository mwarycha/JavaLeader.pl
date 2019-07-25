package pl.javaleader.findAnyFindFirstLimitMaxMin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class FindAnyFindFirstLimitMaxMinDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("1000","1001","1002");

        list.stream().findAny().ifPresent(arg->System.out.println(arg));
        list.stream().findFirst().ifPresent(arg->System.out.println(arg));
        list.stream().limit(2).forEach(arg->System.out.println(arg));

        String max = list.stream().max(Comparator.comparing(arg -> arg.valueOf(arg))).get();
        String min = list.stream().min(Comparator.comparing(String::valueOf)).get();

        System.out.println(max);
        System.out.println(min);

        // find last element

        /*
            1000, 1001 => 1001
            1001, 1002 => 1002
         */

        // option 1
        String lastValue = list.stream().reduce((first, second) -> second).orElse(null);
        System.out.println(lastValue);

        // option 2
        long count            = list.stream().count();
        Stream<String> stream = list.stream();
        System.out.println(stream.skip(count - 1).findFirst().get());

        // option 3
        Stream<Integer> integerStream = Stream.iterate(0, i -> i + 1).limit(list.size());
        Integer lastValueIndex = integerStream.reduce((first, second) -> second).orElse(null);
        System.out.println(list.get(lastValueIndex));
    }

}
