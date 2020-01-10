package bingo.model;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BingoRestModel {

    Map<Integer, int [][] > mapBasicBingoCardCardIndexAndCardArray;
    Set<Integer> allGeneratedNumbersSet;
    int [][] bingoWinnerCard;
    Integer winnerBingoCardIndex;

    @JsonProperty("indexCardToBingoCardMap")
    public Map<Integer, int[][]> getMapBasicBingoCardCardIndexAndCardArray() {
        return mapBasicBingoCardCardIndexAndCardArray;
    }

    public void setMapBasicBingoCardCardIndexAndCardArray(Map<Integer, int[][]> mapBasicBingoCardCardIndexAndCardArray) {
        this.mapBasicBingoCardCardIndexAndCardArray = mapBasicBingoCardCardIndexAndCardArray;
    }

    @JsonProperty("allGeneratedNumbers")
    public Set<Integer> getAllGeneratedNumbersSet() {
        return allGeneratedNumbersSet;
    }

    public void setAllGeneratedNumbersSet(Set<Integer> allGeneratedNumbersSet) {
        this.allGeneratedNumbersSet = allGeneratedNumbersSet;
    }

    @JsonProperty("winnerBingoCard")
    public int[][] getBingoWinnerCard() {
        return bingoWinnerCard;
    }

    public void setBingoWinnerCard(int[][] bingoWinnerCard) {
        this.bingoWinnerCard = bingoWinnerCard;
    }

    @JsonProperty("winnerBingoIndex")
    public Integer getWinnerBingoCardIndex() {
        return winnerBingoCardIndex;
    }

    public void setWinnerBingoCardIndex(Integer winnerBingoCardIndex) {
        this.winnerBingoCardIndex = winnerBingoCardIndex;
    }
}
