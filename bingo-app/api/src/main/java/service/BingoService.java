package service;

public interface BingoService {
    int [][] generateBingo5x5Card();
    void printBingo5x5Card(int [][] arrayToBePrinted);
    int generateRandomNumberFromSpecificRange(int min, int max);
    StringBuilder getStringBuilderBingo5x5Card(int [][] arrayToBePrinted);
}
