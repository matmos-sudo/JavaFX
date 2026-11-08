package org.example.bankaccount;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;

public class HelloController {
    @FXML private TextField startBalanceField;
    @FXML private Label balanceLabel;
    @FXML private ComboBox<String> typeCombo;
    @FXML private TextField sumField;
    @FXML private TextArea transactionsArea;

    private BankAccount account;
    private int employeeIdCounter = 1;

    public void initialize() {
        account = new BankAccount(0.0);
        typeCombo.getItems().addAll("Deposit", "Withdraw");
        typeCombo.setValue("Deposit");
        balanceLabel.setText("0.00 €");
    }

    @FXML
    public void createAccount() {
        try {
            double startBalance = Double.parseDouble(startBalanceField.getText());
            account = new BankAccount(startBalance);
            balanceLabel.setText(String.format("%.2f €", account.getBalance()));
            transactionsArea.appendText("Account created with initial balance: " + String.format("%.2f €", startBalance) + "\n");
        } catch (Exception e) {
            transactionsArea.appendText("Invalid starting balance!\n");
        }
    }

    @FXML
    public void runOne() {
        try {
            String type = typeCombo.getValue();
            double sum = Double.parseDouble(sumField.getText());
            if (sum <= 0) {
                return;
            }
            Employee emp = new Employee(employeeIdCounter++, account, type, sum, transactionsArea, balanceLabel);
            Thread t = new Thread(emp);
            t.start();
        } catch (Exception e) {
            transactionsArea.appendText("Invalid sum!\n");
        }
    }

    @FXML
    public void runFive() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            String type = rand.nextBoolean() ? "Deposit" : "Withdraw";
            double sum = (rand.nextInt(100) + 1) * 10.0;
            Employee emp = new Employee(employeeIdCounter++, account, type, sum, transactionsArea, balanceLabel);
            Thread t = new Thread(emp);
            t.start();
        }
    }
}
