package org.example.robot;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Robot {
    boolean automaticky = false;
    Timeline t;
    Rectangle robot;
    String smer = "D";
    double rychlost = 10;

    public Robot(){
        robot = new Rectangle(50, 30);
        robot.setX(100);
        robot.setY(100);
        robot.setFill(Color.BLUE);
        robot.setFocusTraversable(true);

        t = new Timeline(new KeyFrame(Duration.millis(50), event -> {
            automatickyPohyb();
        }));
        t.setCycleCount(Timeline.INDEFINITE);

        robot.setOnMouseClicked(event -> {
            prepniRezim();
        });
    }

    public Rectangle getRobot(){
        return this.robot;
    }

    public void prepniRezim(){
        if(t.getStatus() == Animation.Status.RUNNING){
            t.pause();
            automaticky = false;
        }else{
            t.play();
            automaticky = true;
        }
    }

    public void otoc(String novySmer){
        smer = novySmer;
        if(smer.equals("W")){
            robot.setWidth(30);
            robot.setHeight(50);
            robot.setFill(Color.GREEN);
        }else if(smer.equals("S")){
            robot.setWidth(30);
            robot.setHeight(50);
            robot.setFill(Color.RED);
        }else if(smer.equals("A")){
            robot.setWidth(50);
            robot.setHeight(30);
            robot.setFill(Color.ORANGE);
        }else if(smer.equals("D")){
            robot.setWidth(50);
            robot.setHeight(30);
            robot.setFill(Color.BLUE);
        }

        if(robot.getX() + robot.getWidth() > 600){
            robot.setX(600 - robot.getWidth());
        }
        if(robot.getY() + robot.getHeight() > 400){
            robot.setY(400 - robot.getHeight());
        }
    }

    public void hore(){
        if(!automaticky){
            otoc("W");
            if(robot.getY() - rychlost >= 0){
                robot.setY(robot.getY() - rychlost);
            }else{
                robot.setY(0);
            }
        }
    }

    public void dole(){
        if(!automaticky){
            otoc("S");
            if(robot.getY() + robot.getHeight() + rychlost <= 400){
                robot.setY(robot.getY() + rychlost);
            }else{
                robot.setY(400 - robot.getHeight());
            }
        }
    }

    public void dolava(){
        if(!automaticky){
            otoc("A");
            if(robot.getX() - rychlost >= 0){
                robot.setX(robot.getX() - rychlost);
            }else{
                robot.setX(0);
            }
        }
    }

    public void doprava(){
        if(!automaticky){
            otoc("D");
            if(robot.getX() + robot.getWidth() + rychlost <= 600){
                robot.setX(robot.getX() + rychlost);
            }else{
                robot.setX(600 - robot.getWidth());
            }
        }
    }

    public void automatickyPohyb(){
        if(smer.equals("D")){
            if(robot.getX() + robot.getWidth() + rychlost <= 600){
                robot.setX(robot.getX() + rychlost);
            }else{
                robot.setX(600 - robot.getWidth());
                otoc("A");
            }
        }else if(smer.equals("A")){
            if(robot.getX() - rychlost >= 0){
                robot.setX(robot.getX() - rychlost);
            }else{
                robot.setX(0);
                otoc("D");
            }
        }else if(smer.equals("W")){
            if(robot.getY() - rychlost >= 0){
                robot.setY(robot.getY() - rychlost);
            }else{
                robot.setY(0);
                otoc("S");
            }
        }else if(smer.equals("S")){
            if(robot.getY() + robot.getHeight() + rychlost <= 400){
                robot.setY(robot.getY() + rychlost);
            }else{
                robot.setY(400 - robot.getHeight());
                otoc("W");
            }
        }
    }
}
