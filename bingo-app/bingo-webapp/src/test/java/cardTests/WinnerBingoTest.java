package cardTests;

import cardTests.testConfiguration.WeldJUnit4Runner;
import helpers.PrinterHelper;


import javafx.util.Pair;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import service.BingoService;
import java.util.*;

import org.junit.runner.RunWith;
import org.junit.Test;
import javax.inject.Inject;
import org.junit.Rule;

import static helpers.RandomHelper.generateRandoNumberFromRange;
import static org.junit.Assert.assertEquals;

class ParameterRule implements MethodRule {

    private int parameterIndex = 0;

    public  List<List<Pair<Integer, Integer>>> parameters;

    public ParameterRule( List<List<Pair<Integer, Integer>>> someParameters){
        parameters = someParameters;
    }

    public List<Pair<Integer, Integer>> getParameter(){
        return parameters.get(parameterIndex);
    }

    @Override
    public Statement apply(Statement statement, FrameworkMethod frameworkMethod, Object o) {
        return new Statement (){
            public void evaluate(){
                for (int i = 0; i < parameters.size(); i++){
                    PrinterHelper.printLog("\nwinners pattern indexes" + parameters.get(i).toString() + "\n");
                    parameterIndex = i;
                    try {
                        statement.evaluate();
                    } catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
            }
        };
    }
}

@RunWith(WeldJUnit4Runner.class)
public class WinnerBingoTest {

    List<List<Pair<Integer, Integer>>> patternLists = new ArrayList();

    {
        patternLists.add(getVerticalIndexesPattern());
        patternLists.add(getHorizontalIndexesPattern());
    }

    public @Rule ParameterRule rule = new ParameterRule(
           patternLists
    );

    @Inject
    BingoService bingoService;

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

        final int BINGO_CARD_AMOUNT_TEST_SIZE = 1000;

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

            int randomNumberCandidate = generateRandoNumberFromRange(1, 75);

            // bingo has only unique numbers from range(1,75), cache already generated numbers
            while(alreadyGeneratedIntegersCacheSet.contains(randomNumberCandidate)) {
                randomNumberCandidate = generateRandoNumberFromRange(1,75);
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

    public List<Pair<Integer, Integer>> getVerticalIndexesPattern() {
        List<Pair<Integer, Integer>> pairs = new ArrayList();
        pairs.add(new Pair(0,2));
        pairs.add(new Pair(1,2));
        pairs.add(new Pair(2,2));
        pairs.add(new Pair(3,2));
        pairs.add(new Pair(4,2));
        return pairs;
    }

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
