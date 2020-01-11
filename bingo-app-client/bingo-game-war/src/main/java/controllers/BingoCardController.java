package controllers;

import service.BingoService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.inject.Inject;

@WebServlet(name = "bingo-jsp", urlPatterns = {"/showBingoCardsWithJsp"})
public class BingoCardController extends HttpServlet {

    @Inject
    private BingoService bingoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("winnerBingoCardIndex"   , bingoService.getWinnerBingoCardIndex());
        request.setAttribute("winnerBingoCard"        , bingoService.getWinnerBingoCardArray());
        request.setAttribute("allBingoCards"          , bingoService.getIndexCardToBingoCardArrayMap());
        request.setAttribute("allGeneratedNumbersSet" , bingoService.getAllGeneratedNumbersInSet());

        forwardToBingoJSP(request, response);
    }

    private void forwardToBingoJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/bingo.jsp").forward(request, response);
    }
}