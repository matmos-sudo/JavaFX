package org.example.javathreads;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField inputField;
    @FXML private ProgressBar fibProgress, powProgress, faktProgress;
    @FXML private TextArea faktArea, powArea, fibArea;

    public void initialize(){
        fibProgress.setProgress(0.0);
        powProgress.setProgress(0.0);
        faktProgress.setProgress(0.0);
    }

    public void runThreads(){
        try {
            String NUM = inputField.getText();
            int num = Integer.parseInt(NUM);
            if(num <= 0){
                return;
            }
            faktArea.clear();
            powArea.clear();
            fibArea.clear();
            faktProgress.setProgress(0.0);
            powProgress.setProgress(0.0);
            fibProgress.setProgress(0.0);

            FaktRunnable fakt = new FaktRunnable(num, faktArea, faktProgress);
            PowRunnable pow = new PowRunnable(num, powArea, powProgress);
            FibRunnable fib = new FibRunnable(num, fibArea, fibProgress);

            Thread t1 = new Thread(fakt);
            Thread t2 = new Thread(pow);
            Thread t3 = new Thread(fib);

            t1.start();
            t2.start();
            t3.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
