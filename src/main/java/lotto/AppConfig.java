package lotto;

import lotto.service.LottoGenerator;
import lotto.service.LottoListGenerator;
import lotto.service.WinningChecker;
import lotto.validator.Validator;
import lotto.view.View;

public class AppConfig {
    final Validator validator = new Validator();
    final View view = new View(validator);
    final LottoGenerator lottoGenerator = new LottoGenerator();
    final LottoListGenerator lottoListGenerator = new LottoListGenerator();
    final WinningChecker winningChecker = new WinningChecker();

    public Controller controller() {
        return new Controller(view, lottoListGenerator, lottoGenerator, winningChecker);
    }
}
