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
    Set<Integer> allGeneratedNumbersSet                            = new HashSet<>();

    @Test
    public void testWinnerBingoCard() {

        final int BINGO_CARD_AMOUNT_TEST_SIZE = 2;

        Pair<Integer, int[][]> bingo = bingoService.getWinner(BINGO_CARD_AMOUNT_TEST_SIZE, mapBasicBingoCardCardIndexAndCardArray, allGeneratedNumbersSet,rule.getParameter());
        PrinterHelper.printLog("verify winner bingo card " + bingoService.getStringBuilderBingo5x5Card(bingo.getValue()).toString());

        List<Pair<Integer,Integer>> pairList = rule.getParameter();

        for(Pair<Integer,Integer> pair : pairList) {
                assertEquals(0, bingo.getValue()[pair.getKey()][pair.getValue()]);
        }
    }

}
