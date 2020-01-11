package utils;

import com.google.gson.internal.LinkedTreeMap;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.*;

import static utils.UtilsClass.getBaseURI;
import static utils.UtilsClass.getMapFromJson;
import static utils.UtilsClass.ListOfDoubleListTo2DIntegerArray;

public class BingoHelper {

    static Map<Object, Object> bingodata = getMapFromJson(getBingoData());

    public static Integer getWinnerBingoCardIndex() {
        return ((Double)bingodata.get("winnerBingoIndex")).intValue();
    }

    public static Set<Integer> getAllGeneratedNumbersInSet() {
        Set<Integer> allGeneratedNumbers = new HashSet();
        List<Double> generatedNumbers    = (ArrayList) bingodata.get("allGeneratedNumbers");
        fillSetOfIntegerFromDoubleList(generatedNumbers, allGeneratedNumbers);
        return allGeneratedNumbers;
    }

    public static Map<Integer, Integer [][]> getIndexCardToBingoCardArrayMap() {
        LinkedTreeMap<Object, Object> arrays = (LinkedTreeMap) bingodata.get("indexCardToBingoCardMap");
        Map<Integer, Integer [][]> indexCardToBingoCardMap = new HashMap();
        for (Map.Entry<Object, Object> entry : arrays.entrySet()) {
            indexCardToBingoCardMap.put(Integer.parseInt((String)entry.getKey()),ListOfDoubleListTo2DIntegerArray((List<List<Double>>)entry.getValue()));
        }
        return indexCardToBingoCardMap;
    }

    public static Integer [][] getWinnerBingoCardArray() {
        List<List<Double>> winnerBingoCard = (List<List<Double>>) bingodata.get("winnerBingoCard");
        return ListOfDoubleListTo2DIntegerArray(winnerBingoCard);
    }

    private static String getBingoData() {

         ClientConfig clientConfig = new ClientConfig();
         Client client             = ClientBuilder.newClient(clientConfig);
         WebTarget webTarget       = client.target(getBaseURI());

         String response = webTarget.path("/api").
                path("/bingo/get/3").
                request().
                accept(MediaType.APPLICATION_JSON).
                get(String.class);

         return response;
    }

    private static void fillSetOfIntegerFromDoubleList(List<Double> generatedNumbers, Set<Integer> allGeneratedNumbers) {
        generatedNumbers.forEach(number -> allGeneratedNumbers.add((number).intValue()));
    }
}
