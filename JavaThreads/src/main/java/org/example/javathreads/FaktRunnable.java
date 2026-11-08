package org.example.javathreads;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class FaktRunnable implements Runnable {
    private int inputNum;
    private TextArea textArea;
    private ProgressBar progressBar;

    public FaktRunnable(int inputNum, TextArea textArea, ProgressBar progressBar){
        this.inputNum = inputNum;
        this.textArea = textArea;
        this.progressBar = progressBar;
    }

    @Override
    public void run(){
        if(inputNum <= 0){
            return;
        }
        long sum = 1;
        for(int n = 1; n <= inputNum; n++){
            try{
                sum *= n;
                int pom = n;
                long pomSum = sum;
                Platform.runLater(new Runnable() {
                    @Override
                    public void run(){
                        textArea.appendText(pomSum + "\n");
                        progressBar.setProgress((double) pom / inputNum);
                    }
                });
                Thread.sleep(200);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
