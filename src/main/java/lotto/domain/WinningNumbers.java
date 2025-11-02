package lotto.domain;

import lotto.validator.Validator;

import java.util.List;

public class WinningNumbers {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto,bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void validate(Lotto winningLotto, int bonusNumber) {
        Validator validator = new Validator();
        winningLotto.bonusNumberValidate(validator,bonusNumber);
    }
}
