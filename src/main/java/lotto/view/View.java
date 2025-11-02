package lotto.view;

import lotto.validator.Validator;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    public static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public Validator validator;

    public View(Validator validator) {
        this.validator = validator;
    }


    public Integer inputPurchaseAmonut(){
        try{
            System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
            String userInput = readLine();
            int result = validator.checkInteger(userInput);
            validator.checkPositive(result);
            return result;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchaseAmonut();
        }
    }

    public ArrayList<Integer> inputWinningNumbers(){
        try {
            System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
            String userInput = readLine();
            ArrayList<Integer> splitUserInput = validator.checkWinningNumbersInputForm(userInput);
            for (int number : splitUserInput) {
                validator.checkPositive(number);
            }
            return splitUserInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }
}
