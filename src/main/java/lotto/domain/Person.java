package lotto.domain;

import lotto.service.ReturnRateCalculator;
import lotto.service.WinningChecker;

import java.util.List;
import java.util.Map;

public class Person {
    private List<Lotto> lottoList;
    private PurchaseAmount purchaseAmount;

    public Person(List<Lotto> lottoList, PurchaseAmount purchaseAmount) {
        this.lottoList = lottoList;
        this.purchaseAmount = purchaseAmount;
    }

    public Map<Rank, Integer> checkTotalResult(WinningChecker winningChecker, WinningNumbers winningNumbers){
        return winningChecker.checkTotalResult(lottoList,winningNumbers);
    }

    public double calculateReturnRate(Map<Rank, Integer> totalResult, ReturnRateCalculator returnRateCalculator) {
        return purchaseAmount.calculateReturnRate(totalResult, returnRateCalculator);
    }
}
