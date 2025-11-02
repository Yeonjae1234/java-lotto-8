package lotto.domain;

import lotto.service.LottoGenerator;
import lotto.service.LottoListGenerator;
import lotto.service.ReturnRateCalculator;

import java.util.ArrayList;
import java.util.Map;

public class PurchaseAmount {

    public static final int MONEY_UNIT = 1000;
    public static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 " + MONEY_UNIT + "원 단위여야 합니다.";

    private long money;

    public PurchaseAmount(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }
    }

    public ArrayList<Lotto> generateLottoList(LottoListGenerator lottoListGenerator, LottoGenerator lottoGenerator) {
        return lottoListGenerator.generateLottoList(money, MONEY_UNIT,lottoGenerator);
    }

    public double calculateReturnRate(Map<Rank,Integer> totalResult, ReturnRateCalculator returnRateCalculator){
        return returnRateCalculator.calculateReturnRate(totalResult, money);
    }

}
