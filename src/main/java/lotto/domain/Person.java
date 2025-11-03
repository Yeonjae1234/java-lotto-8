package lotto.domain;

import lotto.service.LottoGenerator;
import lotto.service.LottoListGenerator;
import lotto.service.ReturnRateCalculator;
import lotto.service.WinningChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Person {
    private List<Lotto> lottoList;
    private PurchaseAmount purchaseAmount;

    public Person(PurchaseAmount purchaseAmount, LottoListGenerator lottoListGenerator, LottoGenerator lottoGenerator) {
        this.purchaseAmount = purchaseAmount;
        this.lottoList = purchaseAmount.generateLottoList(lottoListGenerator, lottoGenerator);
    }

    public Map<Rank, Integer> checkTotalResult(WinningChecker winningChecker, WinningNumbers winningNumbers){
        return winningChecker.checkTotalResult(lottoList,winningNumbers);
    }

    public double calculateReturnRate(Map<Rank, Integer> totalResult, ReturnRateCalculator returnRateCalculator) {
        return purchaseAmount.calculateReturnRate(totalResult, returnRateCalculator);
    }

    public LottoListDTO makeLottoListDTO(){
        List<LottoSnapshot> item = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            item.add(lotto.makeLottoSnapshot());
        }
        return new LottoListDTO(item);
    }
}
