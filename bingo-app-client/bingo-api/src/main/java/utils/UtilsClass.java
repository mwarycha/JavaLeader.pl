package utils;

import com.google.gson.Gson;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilsClass {

    public static URI getBaseURI() {
        return UriBuilder.fromUri("https://bingo.javaleader.pl").build();
    }

    public static Gson getGson() {
        return new Gson();
    }

    public static Map getMapFromJson(String jsonString) {
        return getGson().fromJson(jsonString, Map.class);
    }

    public static Integer[][] ListOfDoubleListTo2DIntegerArray(List<List<Double>> listOfDoubleList) {
        Integer[][] intArray = new Integer[listOfDoubleList.size()][];
        int elem = 0;
        for (List<Double> numbers : listOfDoubleList) {
            List<Integer> intList = numbers.stream().map(number -> number.intValue()).collect(Collectors.toList());
            intArray[elem++] = intList.toArray(new Integer[numbers.size()]);
        }
        return intArray;
    }
}
