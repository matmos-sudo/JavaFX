package org.example.lopta;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Ball {
    boolean Moving = true;
    Timeline t;
    Circle Ball;

    public Ball(){
        Ball = new Circle(50);
        Ball.setCenterX(50);
        Ball.setCenterY(50);
        KeyValue Xval = new KeyValue(Ball.translateXProperty(),250);
        KeyValue Yval = new KeyValue(Ball.centerYProperty(),150);
        t = new Timeline(new KeyFrame(Duration.seconds(2),Xval,Yval));
        t.setAutoReverse(true);
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
        Ball.setOnMouseClicked(event -> {if(t.getStatus() == Animation.Status.RUNNING){ t.pause();}else{ t.play();}});

    }
    public Circle getBall(){
        return this.Ball;
    }

    public void SpeedUp(){
        double a = t.getRate();
        t.setRate(a+0.2);
    }

    public void SlowDown(){
        double a = t.getRate();
        if(a-0.2 >= 0){
            t.setRate(a-0.2);
        }
    }


}
