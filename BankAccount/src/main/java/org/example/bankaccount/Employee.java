package org.example.bankaccount;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Employee implements Runnable {
    private int id;
    private BankAccount account;
    private String type;
    private double amount;
    private TextArea transactionsArea;
    private Label balanceLabel;

    public Employee(int id, BankAccount account, String type, double amount, TextArea transactionsArea, Label balanceLabel) {
        this.id = id;
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.transactionsArea = transactionsArea;
        this.balanceLabel = balanceLabel;
    }

    public int getId() {
        return id;
    }

    public BankAccount getAccount() {
        return account;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int)(Math.random() * 200) + 100);
        } catch (Exception e) {
        }
        boolean success = true;
        if (type.equalsIgnoreCase("Deposit") || type.equalsIgnoreCase("Vklad")) {
            account.deposit(amount);
        } else {
            success = account.withdraw(amount);
        }
        double currentBalance = account.getBalance();
        boolean finalSuccess = success;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (finalSuccess) {
                    transactionsArea.appendText("Employee " + id + ": " + type + " " + String.format("%.2f", amount) + " €. New balance: " + String.format("%.2f", currentBalance) + " €\n");
                } else {
                    transactionsArea.appendText("Employee " + id + ": Cannot withdraw " + String.format("%.2f", amount) + " € (Insufficient funds). Balance: " + String.format("%.2f", currentBalance) + " €\n");
                }
                balanceLabel.setText(String.format("%.2f €", currentBalance));
            }
        });
    }
}
