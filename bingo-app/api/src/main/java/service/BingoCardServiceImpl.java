package service;

import helpers.RandomHelper;
import java.util.HashSet;
import java.util.Set;

import static helpers.RandomHelper.generateRandomNumberFromRange;

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
                    randomNumberCandidate = generateRandomNumberFromRange(1,75);
                }

                alreadyGeneratedIntegers.add(randomNumberCandidate);

                bingoCard[row][column] = randomNumberCandidate;
            }
        }

        // clear middle element, because of rules of bingo
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
        return RandomHelper.generateRandomNumberFromRange(min,max);
    }

}
