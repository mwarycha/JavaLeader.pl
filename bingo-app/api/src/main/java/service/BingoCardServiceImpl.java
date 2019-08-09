package service;

import helpers.RandomHelper;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static helpers.RandomHelper.generateRandoNumberFromRange;

public class BingoCardServiceImpl implements BingoService {

    final int ROW     = 5;
    final int COLUMNN = 5;

    public int [][] generateBingo5x5Card() {

        Set<Integer> alreadyGeneratedIntegers = new HashSet();

        int [][] bingoCard = new int [ROW][COLUMNN];

        for (int row = 0; row < ROW; row++) {
            for (int column = 0; column < COLUMNN; column++) {

                int randomNumberCandidate = generateRandomNumberFromSpecificRange(1,75);

                // bingo has only unique numbers from range(1,75)
                while(alreadyGeneratedIntegers.contains(randomNumberCandidate)) {
                    randomNumberCandidate = generateRandoNumberFromRange(1,75);
                }

                alreadyGeneratedIntegers.add(randomNumberCandidate);

                bingoCard[row][column] = randomNumberCandidate;
            }
        }

        // clear middle element
        bingoCard[2][2] = 0;

        return bingoCard;

    }

    public void printBingo5x5Card(int [][] arrayToBePrinted) {
        for (int row = 0; row < ROW; row++) {
            for (int column = 0; column < COLUMNN; column++) {
                System.out.print(arrayToBePrinted[row][column] + "\t");
            }
            System.out.print(System.lineSeparator());
        }
    }

    public StringBuilder getStringBuilderBingo5x5Card(int [][] arrayToBePrinted) {
        StringBuilder stringBuilderBingiCard = new StringBuilder();
        stringBuilderBingiCard.append("\n**********************************\n");
        for (int row = 0; row < ROW; row++) {
            for (int column = 0; column < COLUMNN; column++) {
                stringBuilderBingiCard.append(arrayToBePrinted[row][column] + "\t");
            }
            stringBuilderBingiCard.append(System.lineSeparator());
        }
        stringBuilderBingiCard.append("**********************************");

        return stringBuilderBingiCard;
    }

    public int generateRandomNumberFromSpecificRange(int min, int max) {
        return RandomHelper.generateRandoNumberFromRange(min,max);
    }

    @Override
    public List<Pair<Integer, Integer>> getVerticalIndexesPattern() {

        List<Pair<Integer, Integer>> pairs = new ArrayList();

        pairs.add(new Pair(0,2));
        pairs.add(new Pair(1,2));
        pairs.add(new Pair(2,2));
        pairs.add(new Pair(3,2));
        pairs.add(new Pair(4,2));

        return pairs;
    }

    @Override
    public List<Pair<Integer, Integer>> getHorizontalIndexesPattern() {
        List<Pair<Integer, Integer>> pairs = new ArrayList();

        pairs.add(new Pair(2,0));
        pairs.add(new Pair(2,1));
        pairs.add(new Pair(2,2));
        pairs.add(new Pair(2,3));
        pairs.add(new Pair(2,4));

        return pairs;
    }

}
