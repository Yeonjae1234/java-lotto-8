package lotto.domain;

import java.util.List;

public class Person {
    private List<Lotto> lottoList;
    private PurchaseAmount purchaseAmount;

    public Person(List<Lotto> lottoList, PurchaseAmount purchaseAmount) {
        this.lottoList = lottoList;
        this.purchaseAmount = purchaseAmount;
    }
}
