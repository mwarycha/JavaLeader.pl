package controllers;

import helpers.PrinterHelper;
import javafx.util.Pair;
import service.BingoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.inject.Inject;

import static helpers.RandomHelper.generateRandomNumberFromRange;
import static helpers.UtilsHelper.copyOf;
import static helpers.WinnerPatternHelper.checkWinner;

@WebServlet(name = "bingo-jsp", urlPatterns = {"/showBingoCardsWithJsp"})
public class ShowBingoCardControllerWithForwardToJsp extends HttpServlet {

    @Inject
    private BingoService bingoService;

    Map<Integer, int [][] > mapBasicBingoCardCardIndexAndCardArray = new HashMap();
    Set<Integer> allGeneratedNumbersSet                            = new HashSet<>();

    final static Logger logger = Logger.getLogger(ShowBingoCardControllerWithForwardToJsp.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // clear bingo game between request
        mapBasicBingoCardCardIndexAndCardArray = new HashMap();
        allGeneratedNumbersSet                 = new HashSet();

        int numberOfGames            = Integer.parseInt(request.getParameter("game"));
        Pair<Integer, int[][]> bingo = getWinner(numberOfGames);
        int [][] bingoWinnerCard     = bingo.getValue();

        request.setAttribute("winnerBingoCardIndex"   , bingo.getKey());
        request.setAttribute("winnerBingoCard"        , bingoWinnerCard);
        request.setAttribute("allBingoCards"          , mapBasicBingoCardCardIndexAndCardArray);
        request.setAttribute("allGeneratedNumbersSet" , allGeneratedNumbersSet);

        request.getRequestDispatcher("/WEB-INF/bingo.jsp").forward(request, response);

    }

    public Pair<Integer, int [][]> getWinner(int cardAmountToTest) {

        Set<Integer> alreadyGeneratedIntegersCacheSet = new HashSet();

        Map<Integer, int [][] > mapBingoCardIndexAndCardArray = new HashMap();

        for (int i = 0; i <cardAmountToTest ; i++) {
            mapBingoCardIndexAndCardArray.put(i, bingoService.generateBingo5x5Card());
        }

        // copy all generated cards before calculate game
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
            //PrinterHelper.printLog("random card");
            logger.info("random card");
            bingoService.printBingo5x5Card(basicSet);
            System.out.print(System.lineSeparator());
        }

        PrinterHelper.printLog("winner bingo card");
        bingoService.printBingo5x5Card(mapBasicBingoCardCardIndexAndCardArray.get(winnerBingoCardIndex));

        //PrinterHelper.printLog("numbers generated until bingo " + allGeneratedNumbers.toString());
        logger.info("numbers generated until bingo " + allGeneratedNumbers.toString());
        allGeneratedNumbersSet.addAll(allGeneratedNumbers);

        return new Pair<>(winnerBingoCardIndex, winnerBingoCard);
    }

}