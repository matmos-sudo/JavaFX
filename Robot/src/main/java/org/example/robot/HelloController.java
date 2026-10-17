package org.example.robot;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML private AnchorPane Border;
    Robot robot;

    public void initialize(){
        robot = new Robot();
        Border.getChildren().add(robot.getRobot());
        Border.setFocusTraversable(true);
        Border.requestFocus();
        Border.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.W){
                robot.hore();
            }else if(event.getCode() == KeyCode.S){
                robot.dole();
            }else if(event.getCode() == KeyCode.A){
                robot.dolava();
            }else if(event.getCode() == KeyCode.D){
                robot.doprava();
            }
        });
    }
}
