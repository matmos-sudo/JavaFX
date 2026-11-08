package org.example.javathreads;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class PowRunnable implements Runnable{
    private int inputNum;
    private TextArea textArea;
    private ProgressBar progressBar;

    public PowRunnable(int inputNum, TextArea textArea, ProgressBar progressBar){
        this.progressBar = progressBar;
        this.inputNum = inputNum > 0 ? inputNum : 1;
        this.textArea = textArea;
    }

    @Override
    public void run(){
        if(inputNum <= 0){
            return;
        }
        for(int n = 1; n <= inputNum; n++){
            try{
                int pom = n;
                long val = (long) Math.pow(pom, 2);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run(){
                        textArea.appendText(val + "\n");
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
