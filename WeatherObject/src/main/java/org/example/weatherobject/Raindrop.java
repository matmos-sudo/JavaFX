package org.example.weatherobject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Raindrop extends WeatherObject {

    public Raindrop(AnchorPane plocha, double x, double y){
        super(plocha, x, y);
        tvar = new Rectangle(4, 15);
        tvar.setFill(Color.DODGERBLUE);
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
        y = y + 5;
        tvar.setLayoutY(y);
        if(y > 400){
            t.stop();
            plocha.getChildren().remove(tvar);
        }
    }
}
