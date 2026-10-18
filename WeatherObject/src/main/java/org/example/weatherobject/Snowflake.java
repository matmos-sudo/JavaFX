package org.example.weatherobject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Snowflake extends WeatherObject {
    double smerX = 1.5;
    int krok = 0;

    public Snowflake(AnchorPane plocha, double x, double y){
        super(plocha, x, y);
        tvar = new Circle(6);
        tvar.setFill(Color.WHITE);
        tvar.setStroke(Color.DEEPSKYBLUE);
        tvar.setLayoutX(x);
        tvar.setLayoutY(y);
        plocha.getChildren().add(tvar);

        t = new Timeline(new KeyFrame(Duration.millis(50), event -> {
            pohyb();
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
    }

    @Override
    public void pohyb(){
        y = y + 1.5;
        x = x + smerX;
        krok++;
        if(krok >= 15){
            smerX = -smerX;
            krok = 0;
        }
        tvar.setLayoutX(x);
        tvar.setLayoutY(y);
        if(y > 400){
            t.stop();
            plocha.getChildren().remove(tvar);
        }
    }
}
