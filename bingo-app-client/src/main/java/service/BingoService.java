package service;

import java.util.*;

public interface BingoService {
      Integer getWinnerBingoCardIndex(Map<Object, Object> bingodata);
      Set<Integer> getAllGeneratedNumbersInSet(Map<Object, Object> bingodata);
      Map<Integer, Integer [][] > getIndexCardToBingoCardArrayMap(Map<Object, Object> bingodata);
      Integer [][] getWinnerBingoCardArray(Map<Object, Object> bingodata);
}
