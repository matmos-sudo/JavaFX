package org.example.demo1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {
    private int stav =0;
    private GraphicsContext gc;
    private boolean automatika = false;
    private Timeline t;

    public Semafor(){
        super(200,400);
        setLayoutX(250);
        this.gc = this.getGraphicsContext2D();
        vykresli(Color.RED, Color.ORANGE,Color.GREEN);
        setOnMousePressed(MouseEvent -> zmenStav());
        t = new Timeline(new KeyFrame(Duration.seconds(1),e->zmenStav()));
        t.setCycleCount(Timeline.INDEFINITE);

    }

    private void vykresli(Color r, Color o, Color g){
        gc.clearRect(0,0,getWidth(),getHeight());
        gc.setFill(Color.GRAY);
        gc.fillRect(0,0,150,400);
        gc.setFill(r);
        gc.fillOval(30,30,80,80);
        gc.setFill(o);
        gc.fillOval(30,130,80,80);
        gc.setFill(g);
        gc.fillOval(30,210,80,80);
    }

    public void prepni(){
        if(automatika){t.stop(); automatika = false;}
        else{t.play(); automatika = true;}
    }

    public void zmenStav(){
        if(stav == 3) stav = 0;
        else stav++;
        switch(stav){
            case 0:
                vykresli(Color.RED,Color.BLACK,Color.BLACK);
                break;
            case 1:
                vykresli(Color.RED,Color.ORANGE,Color.BLACK);
                break;
            case 2:
                vykresli(Color.BLACK,Color.BLACK,Color.GREEN);
                break;
            case 3:
                vykresli(Color.BLACK,Color.ORANGE,Color.BLACK);
                break;

        }
    }
}
