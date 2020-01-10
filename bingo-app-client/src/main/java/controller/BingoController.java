package controller;

import java.util.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import com.google.gson.internal.LinkedTreeMap;
import org.glassfish.jersey.client.ClientConfig;
import static utils.UtilsClass.*;

public class BingoController {

    public static void main(String[] args) {

        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());

        String response = target.path("/api").
                            path("/bingo/get/3").
                            request().
                            accept(MediaType.APPLICATION_JSON).
                            get(String.class);

       Map<Object, Object> data = getMapFromJson(response);
    }

    public static Integer getWinnerBingoCardIndex(Map<Object, Object> bingodata) {
        return ((Double)bingodata.get("winnerBingoIndex")).intValue();
    }

    public static Set<Integer> getAllGeneratedNumbersInSet(Map<Object, Object> bingodata) {
        final Set<Integer> allGeneratedNumbers = new HashSet();
        List generatedNumbers = (ArrayList) bingodata.get("allGeneratedNumbers");
        generatedNumbers.forEach(number -> allGeneratedNumbers.add(((Double)number).intValue()));
        return allGeneratedNumbers;
    }

    public static Map<Integer, Integer [][] > getIndexCardToBingoCardArrayMap(Map<Object, Object> bingodata) {
        LinkedTreeMap<Object, Object> arrays = (LinkedTreeMap) bingodata.get("indexCardToBingoCardMap");
        Map<Integer, Integer [][]> indexCardToBingoCardMap = new HashMap();
        for (Map.Entry<Object, Object> entry : arrays.entrySet()) {
            indexCardToBingoCardMap.put(Integer.parseInt((String)entry.getKey()),toArray((List<List<Double>>)entry.getValue()));
        }
        return indexCardToBingoCardMap;
    }

    public static Integer [][] getWinnerBingoCardArray(Map<Object, Object> bingodata) {
        List<List<Double>> winnerBingoCard = (List<List<Double>>) bingodata.get("winnerBingoCard");
        return toArray(winnerBingoCard);
    }
}