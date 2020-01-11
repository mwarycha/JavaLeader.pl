package service;

import java.util.*;

public interface BingoService {
      Integer                     getWinnerBingoCardIndex();
      Set<Integer>                getAllGeneratedNumbersInSet();
      Map<Integer, Integer [][]>  getIndexCardToBingoCardArrayMap();
      Integer [][]                getWinnerBingoCardArray();
}
