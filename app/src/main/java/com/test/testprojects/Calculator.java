package com.test.testprojects;


public class Calculator {
    private String CurrentOperaton;
    private Double OneOperand;
    private Double TwoOperand;
    private Double Result;

    void enterNumber(String num){
        if(OneOperand == null) {
            OneOperand = Double.parseDouble(num);
        }else {
            TwoOperand = Double.parseDouble(num);
        }
    }

    void setCurrentOperaton(String op){
        CurrentOperaton = op;
    }

    boolean isOperationNotNull(){
        return CurrentOperaton != null;
    }

    boolean isOneOperandNotNull(){
        return OneOperand != null;
    }

    boolean isTwoOperandNotNull(){
        return TwoOperand != null;
    }

    String calculate(){
        double res = -1;
        switch (CurrentOperaton){
            case "+":
                res = OneOperand + TwoOperand;
                break;
            case "-":
                res = OneOperand - TwoOperand;
                break;
            case "*":
                res = OneOperand * TwoOperand;
                break;
            case "/":
                res = OneOperand / TwoOperand;
                break;
        }
        Result = res;

        return Result.toString();
    }

    void clearTwoOperand(){
        TwoOperand = null;
    }

    void clearOneOperand(){
        OneOperand = null;
    }

    void clearResult(){
        Result = null;
    }

    void clearOperation(){
        CurrentOperaton = null;
    }

    boolean isResultNotNull(){
        return Result != null;
    }

    Double getResult(){
        return Result;
    }


    public String getCurrentOperaton() {
        return CurrentOperaton;
    }

    public Double getOneOperand() {
        return OneOperand;
    }

    public Double getTwoOperand() {
        return TwoOperand;
    }
}
