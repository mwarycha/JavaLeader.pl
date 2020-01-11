package controllers;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import service.BingoService;
import utils.BingoHelper;

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
    BingoService bingoService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BingoHelper.NUMBER_OF_BINGO_GAMES = getRequestNumberOfBingoGames(request);
        BingoHelper.refresh();

        request.setAttribute("winnerBingoCardIndex"   , bingoService.getWinnerBingoCardIndex());
        request.setAttribute("winnerBingoCard"        , bingoService.getWinnerBingoCardArray());
        request.setAttribute("allBingoCards"          , bingoService.getIndexCardToBingoCardArrayMap());
        request.setAttribute("allGeneratedNumbersSet" , bingoService.getAllGeneratedNumbersInSet());

        forwardToBingoJSP(request, response);
    }

    private void forwardToBingoJSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/bingo.jsp").forward(request, response);
    }

    private int getRequestNumberOfBingoGames(HttpServletRequest request) {
        return Integer.parseInt(request.getParameter("game"));
    }

    public BingoService getServiceBeanFromWeldContext() {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        return container.instance().select(BingoService.class).get();
    }
}