package org.example.javathreads;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

public class FibRunnable implements Runnable{
    private int inputNum;
    private TextArea textArea;
    private ProgressBar progressBar;

    public FibRunnable(int inputNum, TextArea textArea, ProgressBar progressBar){
        this.inputNum = inputNum;
        this.textArea = textArea;
        this.progressBar = progressBar;
    }

    @Override
    public void run(){
        if(inputNum <= 0){
            return;
        }
        long a = 0;
        long b = 1;
        for(int n = 1; n <= inputNum; n++){
            try{
                long val = b;
                long next = a + b;
                a = b;
                b = next;
                int pom = n;
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
