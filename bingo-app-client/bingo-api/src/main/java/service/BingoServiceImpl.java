package service;

import utils.BingoHelper;
import java.util.*;

public class BingoServiceImpl implements BingoService {

    public Integer getWinnerBingoCardIndex() {
        return BingoHelper.getWinnerBingoCardIndex();
    }

    public Set<Integer> getAllGeneratedNumbersInSet() {
        return BingoHelper.getAllGeneratedNumbersInSet();
    }

    public Map<Integer, Integer [][] > getIndexCardToBingoCardArrayMap() {
        return BingoHelper.getIndexCardToBingoCardArrayMap();
    }

    public Integer [][] getWinnerBingoCardArray() {
        return BingoHelper.getWinnerBingoCardArray();
    }
}
