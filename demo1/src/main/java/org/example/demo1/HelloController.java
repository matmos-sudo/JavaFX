package org.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML private Pane root;
    Semafor s;

    @FXML protected  void Draw(){
        System.out.println("Draw button was clicked!");
        s = new Semafor();
        root.getChildren().add(s);
    }
    @FXML protected void Manual(){
        s.zmenStav();
    }
    @FXML protected void Automatic(){
        s.prepni();
    }

}
