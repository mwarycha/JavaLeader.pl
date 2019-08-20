package service;

import helpers.RandomHelper;
import javafx.util.Pair;
import java.util.*;
import java.util.logging.Logger;

import static helpers.RandomHelper.generateRandomNumberFromRange;
import static helpers.UtilsHelper.copyOf;
import static helpers.WinnerPatternHelper.checkWinner;

class IterateThrowBingoCardWrapper {

    static int winnerBingoCardIndex  = 0;
    static int [][] winnerBingoCard  = null;

    private IterateThrowBingoCardWrapper() {
    }

    private static boolean processRandomNumberInBingoCardAndCheckIfNumberIsShooted(
                                                          Map.Entry<Integer, int[][]> keyValueIndexCardAndCardArray,
                                                          int randomNumberCandidate,
                                                          int row,
                                                          int column,
                                                          List<Pair<Integer, Integer>> listOfWinnerIndexes) {

        if (keyValueIndexCardAndCardArray.getValue()[row][column] == randomNumberCandidate) {
            keyValueIndexCardAndCardArray.getValue()[row][column] = 0;
            if(checkWinner(keyValueIndexCardAndCardArray.getValue(),listOfWinnerIndexes)) {
                // index of winner card
                winnerBingoCardIndex = keyValueIndexCardAndCardArray.getKey();
                // array of winner card
                winnerBingoCard      = keyValueIndexCardAndCardArray.getValue();
                return true;
            }
        }
        return false;
    }

    public static boolean processIterateThrowBingoCard(Map.Entry<Integer, int[][]> keyValueIndexCardAndCardArray,
                                    int randomNumberCandidate,
                                    List<Pair<Integer, Integer>> listOfWinnerIndexes) {

        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                if (processRandomNumberInBingoCardAndCheckIfNumberIsShooted(keyValueIndexCardAndCardArray, randomNumberCandidate, row, column, listOfWinnerIndexes)) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class BingoCardServiceImpl implements BingoService {

    static final int ROW     = 5;
    static final int COLUMNN = 5;

    private static final Logger LOGGER = Logger.getLogger(BingoCardServiceImpl.class.getName());

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
        LOGGER.info(getStringBuilderBingo5x5Card(arrayToBePrinted).toString());
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

    public Pair<Integer, int [][]> getWinner(int cardAmountToTest,
                                             Map<Integer, int [][] > mapBasicBingoCardCardIndexAndCardArray,
                                             Set<Integer> allGeneratedNumbersSet,
                                             List<Pair<Integer, Integer>> listOfWinnerIndexes) {

        Set<Integer> alreadyGeneratedIntegersCacheSet         = new HashSet();
        Map<Integer, int [][] > mapBingoCardIndexAndCardArray = new HashMap();

        for (int i = 0; i <cardAmountToTest ; i++) {
            mapBingoCardIndexAndCardArray.put(i, generateBingo5x5Card());
        }

        // copy all generated cards before calculate game
        mapBingoCardIndexAndCardArray.keySet().forEach(
                cardIndex -> mapBasicBingoCardCardIndexAndCardArray.put(cardIndex,copyOf(mapBingoCardIndexAndCardArray.get(cardIndex)))
        );

        boolean bingo             = false;
        int winnerBingoCardIndex  = 0;
        int [][] winnerBingoCard  = null;

        Set<Integer> allGeneratedNumbers = new HashSet<>();

        // each number will be removed from card if it is hitted
        while (!bingo) {

            int randomNumberCandidate = generateRandomNumberFromRange(1, 75);

            // bingo has only unique numbers from range(1,75), cache already generated numbers
            while(alreadyGeneratedIntegersCacheSet.contains(randomNumberCandidate)) {
                randomNumberCandidate = generateRandomNumberFromRange(1,75);
            }

            alreadyGeneratedIntegersCacheSet.add(randomNumberCandidate);
            allGeneratedNumbers.add(randomNumberCandidate);

            Set<Map.Entry<Integer,int[][]>> entrySetBingoCard = mapBingoCardIndexAndCardArray.entrySet();

            for (Map.Entry<Integer, int[][]> keyValueIndexCardAndCardArray: entrySetBingoCard) {
                if(IterateThrowBingoCardWrapper.processIterateThrowBingoCard(keyValueIndexCardAndCardArray, randomNumberCandidate, listOfWinnerIndexes)) {
                    winnerBingoCardIndex = IterateThrowBingoCardWrapper.winnerBingoCardIndex;
                    winnerBingoCard      = IterateThrowBingoCardWrapper.winnerBingoCard;
                    bingo = true;
                }
            }
        }

        for (int [][] basicSet : mapBasicBingoCardCardIndexAndCardArray.values()) {
            LOGGER.info("random card");
            printBingo5x5Card(basicSet);
        }

        LOGGER.info("winner bingo card");
        printBingo5x5Card(mapBasicBingoCardCardIndexAndCardArray.get(winnerBingoCardIndex));

        LOGGER.info("numbers generated until bingo " + allGeneratedNumbers.toString());
        allGeneratedNumbersSet.addAll(allGeneratedNumbers);

        return new Pair<>(winnerBingoCardIndex, winnerBingoCard);
    }

    public int generateRandomNumberFromSpecificRange(int min, int max) {
        return RandomHelper.generateRandomNumberFromRange(min,max);
    }

}
