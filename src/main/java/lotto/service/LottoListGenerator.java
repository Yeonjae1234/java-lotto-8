package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoListGenerator {

    public List<Lotto> generateLottoList(long purchaseAmount, int MONEY_UNIT, LottoGenerator lottoGenerator) {
        long lottoCount = purchaseAmount / MONEY_UNIT;
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(lottoGenerator.generateLotto());
        }
        return List.copyOf(lottos);
    }
}
