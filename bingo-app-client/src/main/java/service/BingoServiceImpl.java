package service;

import utils.BingoHelper;
import java.util.*;

public class BingoServiceImpl implements BingoService {

    public Integer getWinnerBingoCardIndex(Map<Object, Object> bingodata) {
        return BingoHelper.getWinnerBingoCardIndex(bingodata);
    }

    public Set<Integer> getAllGeneratedNumbersInSet(Map<Object, Object> bingodata) {
        return BingoHelper.getAllGeneratedNumbersInSet(bingodata);
    }

    public Map<Integer, Integer [][] > getIndexCardToBingoCardArrayMap(Map<Object, Object> bingodata) {
        return BingoHelper.getIndexCardToBingoCardArrayMap(bingodata);
    }

    public Integer [][] getWinnerBingoCardArray(Map<Object, Object> bingodata) {
        return BingoHelper.getWinnerBingoCardArray(bingodata);
    }
}
