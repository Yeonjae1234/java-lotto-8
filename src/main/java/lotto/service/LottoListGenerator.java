package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

import java.util.ArrayList;

public class LottoListGenerator {

    public ArrayList<Lotto> generateLottoList(long purchaseAmount, int MONEY_UNIT, LottoGenerator lottoGenerator) {
        long lottoCount = purchaseAmount / MONEY_UNIT;
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
        return lottos;
    }
}
