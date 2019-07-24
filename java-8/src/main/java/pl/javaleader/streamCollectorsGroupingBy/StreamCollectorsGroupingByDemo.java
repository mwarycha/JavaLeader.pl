package pl.javaleader.streamCollectorsGroupingBy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

class AsciiLetter {

    int item;

    public AsciiLetter(int item) {
        this.item = item;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

}

public class StreamCollectorsGroupingByDemo {

    public static void main(String[] args) {

        List<AsciiLetter> items = Arrays.asList(
                new AsciiLetter('b'),
                new AsciiLetter('d'),
                new AsciiLetter('c'),
                new AsciiLetter('a'),
                new AsciiLetter('d'));

        Map<Integer, List<AsciiLetter>> result = items.stream().collect(groupingBy(letter -> letter.getItem()));
        System.out.println(result);

        Map<Integer, List<AsciiLetter>> finalMap = new LinkedHashMap<>();
        result.entrySet().stream()
                .sorted(Map.Entry.<Integer, List<AsciiLetter>>comparingByKey()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
        System.out.println(finalMap);
    }

}
