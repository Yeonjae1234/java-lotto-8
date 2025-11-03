package lotto.service;

import lotto.domain.*;

import java.util.Map;

public class Game {
    private WinningNumbers winningNumbers;
    private LottoListGenerator lottoListGenerator;
    private LottoGenerator lottoGenerator;
    private WinningChecker winningChecker;
    private TotalResult totalResult;
    private Person person;

    public Game(WinningNumbers winningNumbers, PurchaseAmount purchaseAmount
            , LottoListGenerator lottoListGenerator, LottoGenerator lottoGenerator,WinningChecker winningChecker) {
        this.winningNumbers = winningNumbers;
        this.lottoListGenerator = lottoListGenerator;
        this.winningChecker = winningChecker;
    }

    public void runGame(PurchaseAmount purchaseAmount){
        person = new Person(purchaseAmount,lottoListGenerator,lottoGenerator);
        Map<Rank,Integer> rankCount = person.checkTotalResult(winningChecker, winningNumbers);
        double returnRate = person.calculateReturnRate(rankCount, new ReturnRateCalculator());
        totalResult = new TotalResult(rankCount, returnRate);
    }
}
