package lotto.domain;

public class PurchaseAmount {

    public static final int MONEY_UNIT = 1000;
    public static final String MONEY_UNIT_ERROR_MESSAGE = "[ERROR] 구입 금액은 " + MONEY_UNIT + "원 단위여야 합니다.";

    private int money;

    public PurchaseAmount(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(MONEY_UNIT_ERROR_MESSAGE);
        }
    }

}
