package service;

import javafx.util.Pair;

import java.util.List;

public interface BingoService {
    int [][] generateBingo5x5Card();
    void printBingo5x5Card(int [][] arrayToBePrinted);
    int generateRandomNumberFromSpecificRange(int min, int max);
    List<Pair<Integer,Integer>> getVerticalIndexesPattern();
    List<Pair<Integer,Integer>> getHorizontalIndexesPattern();
    StringBuilder getStringBuilderBingo5x5Card(int [][] arrayToBePrinted);
}
