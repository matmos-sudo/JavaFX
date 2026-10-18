package org.example.weatherobject;

import javafx.animation.Timeline;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Shape;

public class WeatherObject {
    double x;
    double y;
    Shape tvar;
    Timeline t;
    AnchorPane plocha;

    public WeatherObject(AnchorPane plocha, double x, double y){
        this.plocha = plocha;
        this.x = x;
        this.y = y;
    }

    public void pohyb(){
    }

    public void posunDolava(){
        x = x - 20;
        tvar.setLayoutX(x);
    }

    public void zastav(){
        if(t != null){
            t.stop();
        }
    }
}
