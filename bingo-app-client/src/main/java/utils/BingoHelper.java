package utils;

import com.google.gson.internal.LinkedTreeMap;
import java.util.*;

import static utils.UtilsClass.toArray;

public class BingoHelper {

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
