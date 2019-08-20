package controllers;

import javafx.util.Pair;
import service.BingoService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import javax.servlet.annotation.WebServlet;
import javax.inject.Inject;

import static helpers.WinnerPatternHelper.getHorizontalIndexesPattern;

@WebServlet(name = "bingo-jsp", urlPatterns = {"/showBingoCardsWithJsp"})
public class ShowBingoCardControllerWithForwardToJsp extends HttpServlet {

    @Inject
    private BingoService bingoService;

    Map<Integer, int [][] > mapBasicBingoCardCardIndexAndCardArray = new HashMap();
    Set<Integer> allGeneratedNumbersSet                            = new HashSet<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // clear bingo game between request
        mapBasicBingoCardCardIndexAndCardArray = new HashMap();
        allGeneratedNumbersSet                 = new HashSet();

        Pair<Integer, int[][]> bingo = bingoService.getWinner(
                getRequestNumberOfBingoGames(request),
                mapBasicBingoCardCardIndexAndCardArray,
                allGeneratedNumbersSet,
                getHorizontalIndexesPattern());

        int [][] bingoWinnerCard     = bingo.getValue();

        request.setAttribute("winnerBingoCardIndex"   , bingo.getKey());
        request.setAttribute("winnerBingoCard"        , bingoWinnerCard);
        request.setAttribute("allBingoCards"          , mapBasicBingoCardCardIndexAndCardArray);
        request.setAttribute("allGeneratedNumbersSet" , allGeneratedNumbersSet);

        request.getRequestDispatcher("/WEB-INF/bingo.jsp").forward(request, response);

    }

    private int getRequestNumberOfBingoGames(HttpServletRequest request) {
        return Integer.parseInt(request.getParameter("game"));
    }
}