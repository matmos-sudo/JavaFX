package org.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public float mgram(float kg){
        return kg*1000000;
    }

    public float gram(float kg){
        return kg*1000;
    }

    public float ton(float kg){
        return kg/1000;
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Button b1 = new Button("Calculate");
        b1.setLayoutY(100);
        b1.setLayoutX(20);
        Label kg = new Label("KG:");
        kg.setLayoutX(20);
        kg.setLayoutY(140);
        Label g = new Label("G:");
        g.setLayoutX(20);
        g.setLayoutY(180);
        Label mg = new Label("MG:");
        mg.setLayoutX(20);
        mg.setLayoutY(220);
        Label t = new Label("T:");
        t.setLayoutX(20);
        t.setLayoutY(260);
        TextField displej = new TextField("0");
        displej.setEditable(true);
        displej.setLayoutX(20);
        displej.setLayoutY(50);
        displej.setPrefSize(230, 40);
        b1.setOnAction(event -> {int parser = Integer.parseInt(displej.getText());
                                            float GRAM = gram(parser);
                                            float MGRAM = mgram(parser);
                                            float TON = ton(parser);
                                            kg.setText(kg.getText()+String.valueOf(parser));
                                            g.setText(g.getText()+String.valueOf(GRAM));
                                            mg.setText(mg.getText()+String.valueOf(MGRAM));
                                            t.setText(t.getText()+String.valueOf(TON));});
        Scene scene = new Scene(root, 270, 360);
        root.getChildren().addAll(kg,g,t,mg,displej,b1);
        scene.setFill(Color.AQUA);
        stage.setTitle("Calc");
        stage.setScene(scene);
        stage.show();

    }
}