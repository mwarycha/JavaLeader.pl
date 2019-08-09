package cardTests;

import cardTests.testConfiguration.ParameterRule;
import cardTests.testConfiguration.WeldJUnit4Runner;
import helpers.PrinterHelper;

import javafx.util.Pair;
import service.BingoService;
import java.util.*;

import org.junit.runner.RunWith;
import org.junit.Test;
import javax.inject.Inject;
import org.junit.Rule;

import static helpers.RandomHelper.generateRandomNumberFromRange;
import static helpers.WinnerPatternHelper.getHorizontalIndexesPattern;
import static helpers.WinnerPatternHelper.getVerticalIndexesPattern;
import static org.junit.Assert.assertEquals;

@RunWith(WeldJUnit4Runner.class)
public class WinnerBingoTest {

    @Inject
    BingoService bingoService;

    // generate data in order to test program with all winner patterns
    List<List<Pair<Integer, Integer>>> patternLists = new ArrayList();

    {
        patternLists.add(getVerticalIndexesPattern());
        patternLists.add(getHorizontalIndexesPattern());
    }

    public @Rule ParameterRule rule = new ParameterRule(patternLists);

    Map<Integer, int [][] > mapBasicBingoCardCardIndexAndCardArray = new HashMap();

    private boolean checkWinner(int[][] bingoCard) {
        final int BINGO_CARD_WINNER_INDEXES_AMOUNT = 5;

        List<Pair<Integer,Integer>> pairList = rule.getParameter();

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

        final int BINGO_CARD_AMOUNT_TEST_SIZE = 100;

        int [][] winnerBingoCard = getWinner(BINGO_CARD_AMOUNT_TEST_SIZE);

        PrinterHelper.printLog("verify winner bingo card " + bingoService.getStringBuilderBingo5x5Card(winnerBingoCard).toString());

        List<Pair<Integer,Integer>> pairList = rule.getParameter();

        for(Pair<Integer,Integer> pair : pairList) {
                assertEquals(0, winnerBingoCard[pair.getKey()][pair.getValue()]);
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

        Set<Integer> alreadyGeneratedIntegersCacheSet = new HashSet();

        Map<Integer, int [][] > mapBingoCardIndexAndCardArray = new HashMap();

        for (int i = 0; i <cardAmountToTest ; i++) {
            mapBingoCardIndexAndCardArray.put(i, bingoService.generateBingo5x5Card());
        }

        // copy all generated cards before calulate game
        mapBingoCardIndexAndCardArray.keySet().forEach(
                cardIndex -> mapBasicBingoCardCardIndexAndCardArray.put(cardIndex,(copyOf(mapBingoCardIndexAndCardArray.get(cardIndex))))
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

                for (int row = 0; row < 5; row++) {

                    for (int column = 0; column < 5; column++) {

                        if (keyValueIndexCardAndCardArray.getValue()[row][column] == randomNumberCandidate) {
                            keyValueIndexCardAndCardArray.getValue()[row][column] = 0;
                            if(checkWinner(keyValueIndexCardAndCardArray.getValue())) {

                                // index of winner card
                                winnerBingoCardIndex = keyValueIndexCardAndCardArray.getKey();

                                // array of winner card
                                winnerBingoCard      = keyValueIndexCardAndCardArray.getValue();
                                bingo = true;
                            }
                        }
                    }
                }
            }
        }

        for (int [][] basicSet : mapBasicBingoCardCardIndexAndCardArray.values()) {
            PrinterHelper.printLog("random card");
            bingoService.printBingo5x5Card(basicSet);
            System.out.print(System.lineSeparator());
        }

        PrinterHelper.printLog("winner bingo card");
        bingoService.printBingo5x5Card(mapBasicBingoCardCardIndexAndCardArray.get(winnerBingoCardIndex));

        PrinterHelper.printLog("numbers generated until bingo " + allGeneratedNumbers.toString());
        return winnerBingoCard;
    }
}
