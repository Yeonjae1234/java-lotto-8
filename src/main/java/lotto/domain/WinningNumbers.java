package lotto.domain;

import lotto.validator.Validator;

public class WinningNumbers {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void validate(Lotto winningLotto, int bonusNumber) {
        Validator validator = new Validator();
        winningLotto.bonusNumberValidate(validator, bonusNumber);
    }

    public Rank countMatchNumbers(Lotto lotto) {
        int count = lotto.countMatchNumbers(winningLotto);
        boolean bonusMatch = lotto.matchBonusNumber(bonusNumber);
        return Rank.valueOf(count, bonusMatch);
    }
}
