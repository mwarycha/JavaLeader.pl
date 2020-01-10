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

    public static Integer[][] toArray(List<List<Double>> list) {
        Integer[][] r = new Integer[list.size()][];
        int i = 0;
        for (List<Double> next : list) {
            List<Integer> intList =  next.stream().map(number -> number.intValue()).collect(Collectors.toList());
            r[i++] = intList.toArray(new Integer[next.size()]);
        }
        return r;
    }
}
