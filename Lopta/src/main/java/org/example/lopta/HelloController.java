package org.example.lopta;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML private AnchorPane Border;
    Ball ball;

    public void initialize(){
        ball = new Ball();
        Border.getChildren().add(ball.getBall());
        Border.setFocusTraversable(true);
        Border.requestFocus();
        Border.setOnKeyPressed(event -> {if(event.getCode() == KeyCode.F){ball.SpeedUp();}else if(event.getCode() == KeyCode.S){ball.SlowDown();}});
    }
}
