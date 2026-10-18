package org.example.weatherobject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.util.Duration;

public class Cloud extends WeatherObject {
    double rychlost = 1.5;

    public Cloud(AnchorPane plocha, double x, double y){
        super(plocha, x, y);
        tvar = new Ellipse(35, 18);
        tvar.setFill(Color.GRAY);
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
        x = x + rychlost;
        if(x >= 615 || x <= 35){
            rychlost = -rychlost;
        }
        tvar.setLayoutX(x);
    }

    public void zmenFarbuNaModru(){
        tvar.setFill(Color.BLUE);
    }
}
