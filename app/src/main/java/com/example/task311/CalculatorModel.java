package com.example.task311;


public class CalculatorModel {
    private int firstArg;
    private int secondArg;

    private StringBuilder inputStr = new StringBuilder();
    private int actionSelected;

    private State state;
    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public CalculatorModel(){
        state = State.firstArgInput;
    }

    public void onNumPresses(int buttonId){
        if(state == State.resultShow){
            state = State.firstArgInput;
            inputStr.setLength(0);
        }

        if(inputStr.length() < 9) {
            switch (buttonId) {
                case R.id.btn_zero:
                    if(inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.btn_one:
                    inputStr.append("1");
                    break;
                case R.id.btn_two:
                    inputStr.append("2");
                    break;
                case R.id.btn_three:
                    inputStr.append("3");
                    break;
                case R.id.btn_four:
                    inputStr.append("4");
                    break;
                case R.id.btn_five:
                    inputStr.append("5");
                    break;
                case R.id.btn_six:
                    inputStr.append("6");
                    break;
                case R.id.btn_seven:
                    inputStr.append("7");
                    break;
                case R.id.btn_eight:
                    inputStr.append("8");
                    break;
                case R.id.btn_nine:
                    inputStr.append("9");
                    break;
            }
        }

    }

    public void onActionPressed(int actionId){
        if(actionId == R.id.btn_equally && state == State.secondArgInput){
            secondArg = Integer.parseInt(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch (actionSelected) {
                case R.id.btnPlus:
                    inputStr.append(firstArg+secondArg);
                    break;
                case R.id.btnMinus:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.btnMultip:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.btn_division:
                    inputStr.append(firstArg/secondArg);
                    break;
            }
        } else if (inputStr.length() > 0 && state == State.firstArgInput) {
            firstArg = Integer.parseInt(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            switch (actionId){
                case R.id.btnPlus:
                    actionSelected = R.id.btnPlus;
                    break;
                case R.id.btnMinus:
                    actionSelected = R.id.btnMinus;
                    break;
                case R.id.btnMultip:
                    actionSelected = R.id.btnMultip;
                    break;
                case R.id.btn_division:
                    actionSelected = R.id.btn_division;
                    break;
            }
        }

    }

    public String getText() {
        return inputStr.toString();
    }

}
