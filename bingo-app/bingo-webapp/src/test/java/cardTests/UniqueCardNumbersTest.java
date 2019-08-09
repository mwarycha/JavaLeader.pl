package cardTests;

import cardTests.testConfiguration.WeldJUnit4Runner;
import service.BingoService;
import java.util.*;

import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

//https://memorynotfound.com/java-se-unit-testing-cdi-junit-jboss-weld-se/
@RunWith(WeldJUnit4Runner.class)
public class UniqueCardNumbersTest {

    @Inject
    private BingoService bingoService;

    @Test
    public void testBingoCardUniqueNumbers() {

        int BINGO_CARD_SIZE_NUMBERS_AMOUNT = 25;

        int [][] bingoCard = bingoService.generateBingo5x5Card();

        String createStringFromArray = Arrays.deepToString(bingoCard)
                .replaceAll("\\[", "")
                .replaceAll("\\]", "");

        String [] createStringFromArraySplit = createStringFromArray.split(",");
        Set<Integer> uniqueIntegers          = new HashSet(Arrays.asList(createStringFromArraySplit));

        assertEquals(BINGO_CARD_SIZE_NUMBERS_AMOUNT, uniqueIntegers.size());

    }
}
