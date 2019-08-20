package controllers;

import javafx.util.Pair;
import service.BingoService;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.annotation.WebServlet;
import javax.inject.Inject;

import static helpers.WinnerPatternHelper.getHorizontalIndexesPattern;

@WebServlet(name = "bingo", urlPatterns = {"/showBingoCardsWithServlet"})
public class ShowBingoCardController extends HttpServlet {

    @Inject
    private BingoService bingoService;

    //  A servlet is created once and all requests flow through that instance.
    Map<Integer, int [][] > mapBasicBingoCardCardIndexAndCardArray = new HashMap();
    Set<Integer> allGeneratedNumbersSet                            = new HashSet<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // clear bingo game between request
        mapBasicBingoCardCardIndexAndCardArray = new HashMap();
        allGeneratedNumbersSet                 = new HashSet();

        PrintWriter out = response.getWriter();

        Pair<Integer, int[][]> bingo = bingoService.getWinner(getRequestNumberOfBingoGames(request), mapBasicBingoCardCardIndexAndCardArray, allGeneratedNumbersSet, getHorizontalIndexesPattern());

        out.println(generateStringBuilderBingoAllCards());

        // winner card
        out.println(bingoService.getStringBuilderBingo5x5Card(bingo.getValue()));

        out.close();
    }

    private StringBuilder generateStringBuilderBingoAllCards() {
        StringBuilder stringBuilderBingoCard = new StringBuilder();
        for (Map.Entry<Integer, int[][]> keyValueIndexCardAndCardArray: mapBasicBingoCardCardIndexAndCardArray.entrySet()) {
            stringBuilderBingoCard.append(bingoService.getStringBuilderBingo5x5Card(keyValueIndexCardAndCardArray.getValue()));
        }
        return stringBuilderBingoCard;
    }

    private int getRequestNumberOfBingoGames(HttpServletRequest request) {
        return Integer.parseInt(request.getParameter("game"));
    }

}