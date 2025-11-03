package lotto.service;

import lotto.domain.*;

import java.util.Map;

public class Game {
    private WinningNumbers winningNumbers;
    private TotalResult totalResult;
    private Person person;

    public Game(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void runGame(PurchaseAmount purchaseAmount,LottoListGenerator lottoListGenerator
            ,LottoGenerator lottoGenerator,WinningChecker winningChecker){
        person = new Person(purchaseAmount,lottoListGenerator,lottoGenerator);
        Map<Rank,Integer> rankCount = person.checkTotalResult(winningChecker, winningNumbers);
        double returnRate = person.calculateReturnRate(rankCount, new ReturnRateCalculator());
        totalResult = new TotalResult(rankCount, returnRate);
    }

    public TotalResultSnapshot makeSnapshot(){
        return totalResult.makeSnapshot();
    }

    public LottoListDTO makeLottoListDTO(){
        return person.makeLottoListDTO();
    }
}
