package com.example.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CalculatorController {
    @FXML
    private TextField input1;

    @FXML
    private TextField input2;

    @FXML
    private Text resultEle;

    @FXML
    public void onClickAdd() {
        double num1 = Double.parseDouble(input1.getText());
        double num2 = Double.parseDouble(input2.getText());
        resultEle.setText(String.format(num1 + " plus " + num2 + " equals " + (num1 + num2)));
    }

    @FXML
    public void onClickSubtract() {
        double num1 = Double.parseDouble(input1.getText());
        double num2 = Double.parseDouble(input2.getText());
        resultEle.setText(String.format(num1 + " substract " + num2 + " equals " + (num1 - num2)));
    }

    @FXML
    public void onClickMultiply() {
        double num1 = Double.parseDouble(input1.getText());
        double num2 = Double.parseDouble(input2.getText());
        resultEle.setText(String.format(num1 + " multiply " + num2 + " equals " + (num1 * num2)));
    }

    @FXML
    public void onClickDivide() {
        double num1 = Double.parseDouble(input1.getText());
        double num2 = Double.parseDouble(input2.getText());
        if (num2 == 0) {
            resultEle.setText("Can't divide by 0");
            return;
        }
        resultEle.setText(String.format(num1 + " divide by " + num2 + " equals " + (num1 / num2)));
    }

    @FXML
    public void onClickClear() {
        input1.clear();
        input2.clear();
        resultEle.setText("No result");
    }
}
