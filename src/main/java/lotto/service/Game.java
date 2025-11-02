package lotto.service;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Map;

public class Game {
    private WinningNumbers winningNumbers;
    private PurchaseAmount purchaseAmount;
    private LottoListGenerator lottoListGenerator;
    private LottoGenerator lottoGenerator;
    private WinningChecker winningChecker;

    public Game(WinningNumbers winningNumbers, PurchaseAmount purchaseAmount
            , LottoListGenerator lottoListGenerator, LottoGenerator lottoGenerator,WinningChecker winningChecker) {
        this.winningNumbers = winningNumbers;
        this.purchaseAmount = purchaseAmount;
        this.lottoListGenerator = lottoListGenerator;
        this.winningChecker = winningChecker;
    }

    public void runGame(){
        ArrayList<Lotto> lottoList = purchaseAmount.generateLottoList(lottoListGenerator, lottoGenerator);
        Person person = new Person(lottoList, purchaseAmount);
        Map<Rank,Integer> totalResult = person.checkTotalResult(winningChecker, winningNumbers);
        double returnRate = person.calculateReturnRate(totalResult, new ReturnRateCalculator());
    }
}
