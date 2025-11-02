package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.WinningNumbers;
import lotto.validator.Validator;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        View view = new View(new Validator());
        Controller controller = new Controller(view);
        WinningNumbers winningNumbers = controller.makeWinningNumbers();
    }
}
