package lotto.view;

import lotto.validator.Validator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    public static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public Validator validator;

    public View(Validator validator) {
        this.validator = validator;
    }


    public Integer inputPurchaseAmonut(){
        try{
            System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
            String userInput = readLine();
            return validator.CheckInteger(userInput);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchaseAmonut();
        }
    }
}
