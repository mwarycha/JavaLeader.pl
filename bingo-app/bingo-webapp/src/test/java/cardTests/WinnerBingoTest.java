package cardTests;

import cardTests.testConfiguration.WeldJUnit4Runner;
import helpers.PrinterHelper;
import javafx.util.Pair;
import service.BingoService;
import java.util.*;

import org.junit.runner.RunWith;
import org.junit.Test;
import javax.inject.Inject;

import static helpers.RandomHelper.generateRandoNumberFromRange;
import static org.junit.Assert.assertEquals;

@RunWith(WeldJUnit4Runner.class)
public class WinnerBingoTest {

    @Inject
    BingoService bingoService;

    Set<int [][]> basicBingoCardSet  = new HashSet<>();

    private boolean checkWinner(int[][] bingoCard) {

        final int BINGO_CARD_WINNER_INDEXES_AMOUNT = 5;

        List<Pair<Integer,Integer>> pairList = bingoService.getHorizontalIndexesPattern();

        int winner = 0;

        for(Pair<Integer,Integer> pair : pairList) {
            if (bingoCard[pair.getKey()][pair.getValue()] == 0) {
                winner +=1;
            }
        }

        return winner == BINGO_CARD_WINNER_INDEXES_AMOUNT ? true : false;

    }

    @Test
    public void testWinnerBingoCard() {

        final int BINGO_CARD_AMOUNT_TEST_SIZE = 5;

        int [][] winnerBingoCard = getWinner(BINGO_CARD_AMOUNT_TEST_SIZE);

        List<Pair<Integer,Integer>> pairList = bingoService.getHorizontalIndexesPattern();

        for(Pair<Integer,Integer> pair : pairList) {
                assertEquals(winnerBingoCard[pair.getKey()][pair.getValue()], 0);
        }
    }

    private int[][] copyOf(int[][] originalArray) {
        int[][] newArray = new int[originalArray.length][originalArray[0].length];
        for (int x = 0; x < originalArray.length; x++) {
            for (int y = 0; y < originalArray[0].length; y++) {
                newArray[x][y]=originalArray[x][y];
            }
        }
        return newArray;
    }

    public int [][] getWinner(int cardAmountToTest) {

        Set<Integer> alreadyGeneratedIntegers = new HashSet();
        Set<int [][]> bingoCardSet            = new  HashSet();

        for (int i = 0; i <cardAmountToTest ; i++) {
            bingoCardSet.add(bingoService.generateBingo5x5Card());
        }

        bingoCardSet.forEach(card -> basicBingoCardSet.add(copyOf(card)));

        boolean bingo            = false;
        int [][] winnerBingoCard = null;

        Set<Integer> allNumbers = new HashSet<>();

        while (!bingo) {

            int randomNumberCandidate =  generateRandoNumberFromRange(1, 75);

            // bingo has only unique numbers from range(1,75)
            while(alreadyGeneratedIntegers.contains(randomNumberCandidate)) {
                randomNumberCandidate = generateRandoNumberFromRange(1,75);
            }
            alreadyGeneratedIntegers.add(randomNumberCandidate);
            allNumbers.add(randomNumberCandidate);

            for (int[][] bingoCard : bingoCardSet) {

                for (int row = 0; row < 5; row++) {

                    for (int column = 0; column < 5; column++) {

                        if (bingoCard[row][column] == randomNumberCandidate) {
                            bingoCard[row][column] = 0;
                            if(checkWinner(bingoCard)) {
                                winnerBingoCard = bingoCard;
                                bingo = true;
                            }
                        }
                    }
                }
            }
        }

        for (int [][] basicSet : basicBingoCardSet) {
            PrinterHelper.printLog("random card");
            bingoService.printBingo5x5Card(basicSet);
            System.out.print(System.lineSeparator());
        }

        PrinterHelper.printLog("winner bingo card");
        bingoService.printBingo5x5Card(winnerBingoCard);

        PrinterHelper.printLog(allNumbers.toString());
        return winnerBingoCard;
    }

}
