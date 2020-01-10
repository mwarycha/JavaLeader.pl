package controllers;

import bingo.model.BingoRestModel;
import javafx.util.Pair;
import service.BingoCardServiceImpl;
import service.BingoService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import static helpers.WinnerPatternHelper.getHorizontalIndexesPattern;

@Path("/bingo")
@RequestScoped
public class RestBingoController {

    @Inject
    private BingoRestModel bingoRestModel;

    //  A servlet is created once and all requests flow through that instance.
    Map<Integer, int [][] > mapBasicBingoCardCardIndexAndCardArray = new HashMap();
    Set<Integer> allGeneratedNumbersSet                            = new HashSet<>();

    @GET
    @Path("/get/{game}")
    @Produces(MediaType.APPLICATION_JSON)
    public BingoRestModel getBingoData(@PathParam("game") Integer game) {

        BingoService bingoService = new BingoCardServiceImpl();

        Pair<Integer, int[][]> bingo = bingoService.getWinner(
                game,
                mapBasicBingoCardCardIndexAndCardArray,
                allGeneratedNumbersSet,
                getHorizontalIndexesPattern());

        int [][] bingoWinnerCard = bingo.getValue();

        bingoRestModel.setWinnerBingoCardIndex(bingo.getKey());
        bingoRestModel.setAllGeneratedNumbersSet(allGeneratedNumbersSet);
        bingoRestModel.setMapBasicBingoCardCardIndexAndCardArray(mapBasicBingoCardCardIndexAndCardArray);
        bingoRestModel.setBingoWinnerCard(bingoWinnerCard);

        return bingoRestModel;
    }
}