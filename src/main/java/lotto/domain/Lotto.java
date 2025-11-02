package lotto.domain;

import lotto.validator.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator validator = new Validator();
        validate(numbers,validator);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers, Validator validator) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            validator.checkLottoNumber(number);
        }
        validator.checkDuplication(numbers);
    }

    // TODO: 추가 기능 구현
}
