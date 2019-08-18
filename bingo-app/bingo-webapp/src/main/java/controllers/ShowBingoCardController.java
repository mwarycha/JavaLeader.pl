package controllers;

import service.BingoService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.inject.Inject;

import static helpers.RandomHelper.generateRandomNumberFromRange;
import static helpers.WinnerPatternHelper.checkWinner;

@WebServlet(name = "bingo", urlPatterns = {"/showBingoCardsWithServlet"})
public class ShowBingoCardController extends HttpServlet {

    @Inject
    private BingoService bingoService;

    //  A servlet is created once and all requests flow through that instance.
    Set<int[][]> bingoCardSet = new HashSet();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // clear bingo game between request
        bingoCardSet = new HashSet();

        int numberOfGames = Integer.parseInt(request.getParameter("game"));
        PrintWriter out   = response.getWriter();

        out.println(generateStringBuilderBingoCards(numberOfGames));

        int [][] bingoCard = runGame(bingoCardSet);

        out.println(bingoService.getStringBuilderBingo5x5Card(bingoCard));

        out.close();
    }

    private StringBuilder generateStringBuilderBingoCards(int numberOfGames) {

        StringBuilder stringBuilderBingoCard = new StringBuilder();

        int gameIter = 0;

        while (numberOfGames > gameIter) {

            int[][] bingoCard = bingoService.generateBingo5x5Card();
            bingoCardSet.add(bingoCard);

            stringBuilderBingoCard.append(bingoService.getStringBuilderBingo5x5Card(bingoCard));

            gameIter += 1;
        }

        return stringBuilderBingoCard;

    }

    private int[][] runGame(Set<int[][]> bingoCardSet) {

        Set<Integer> alreadyGeneratedIntegers = new HashSet();
        boolean bingo                         = true;

        int [][] winnerBingoCard = null;

        while (bingo) {

            int randomNumberCandidate =  generateRandomNumberFromRange(1, 75);

            // bingo has only unique numbers from range(1,75)
            while(alreadyGeneratedIntegers.contains(randomNumberCandidate)) {
                randomNumberCandidate = generateRandomNumberFromRange(1,75);
            }
            alreadyGeneratedIntegers.add(randomNumberCandidate);

            for (int[][] bingoCard : bingoCardSet) {

                for (int row = 0; row < 5; row++) {

                    for (int column = 0; column < 5; column++) {

                        if (bingoCard[row][column] == randomNumberCandidate) {
                            bingoCard[row][column] = 0;
                            if(checkWinner(bingoCard)) {
                                // bingo!
                                winnerBingoCard = bingoCard.clone();
                                bingo = false;
                            }
                        }
                    }
                }
            }

        }
        return winnerBingoCard;
    }

}