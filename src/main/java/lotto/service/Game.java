package lotto.service;

import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

public class Game {
    private WinningNumbers winningNumbers;
    private PurchaseAmount purchaseAmount;
    private LottoListGenerator lottoListGenerator;

    public Game(WinningNumbers winningNumbers, PurchaseAmount purchaseAmount, LottoListGenerator lottoListGenerator) {
        this.winningNumbers = winningNumbers;
        this.purchaseAmount = purchaseAmount;
        this.lottoListGenerator = lottoListGenerator;
    }

    public void runGame(){
        purchaseAmount.generateLottoList(lottoListGenerator);
    }
}
