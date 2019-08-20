package service;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BingoService {

    int [][] generateBingo5x5Card();
    void printBingo5x5Card(int [][] arrayToBePrinted);
    int generateRandomNumberFromSpecificRange(int min, int max);
    StringBuilder getStringBuilderBingo5x5Card(int [][] arrayToBePrinted);

    Pair<Integer, int [][]> getWinner(int cardAmountToTest,
                                      Map<Integer, int [][] > mapBasicBingoCardCardIndexAndCardArray,
                                      Set<Integer> allGeneratedNumbersSet,
                                      List<Pair<Integer, Integer>> listOfWinnerIndexes);
}
