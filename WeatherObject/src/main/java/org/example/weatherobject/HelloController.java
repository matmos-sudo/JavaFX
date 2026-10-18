package org.example.weatherobject;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.Random;

public class HelloController {
    @FXML private AnchorPane Border;
    ArrayList<WeatherObject> objekty = new ArrayList<>();
    Random random = new Random();

    public void initialize(){
        pridajOblak();
        pridajKvapku();
        pridajVlocku();
    }

    @FXML
    public void pridajOblak(){
        double x = random.nextInt(550) + 40;
        double y = random.nextInt(60) + 25;
        Cloud c = new Cloud(Border, x, y);
        objekty.add(c);
    }

    @FXML
    public void pridajKvapku(){
        double x = random.nextInt(620) + 10;
        double y = random.nextInt(200) + 20;
        Raindrop r = new Raindrop(Border, x, y);
        objekty.add(r);
    }

    @FXML
    public void pridajVlocku(){
        double x = random.nextInt(620) + 10;
        double y = random.nextInt(200) + 20;
        Snowflake s = new Snowflake(Border, x, y);
        objekty.add(s);
    }

    @FXML
    public void zastavDazd(){
        for(WeatherObject o : objekty){
            if(o instanceof Raindrop){
                o.zastav();
            }
        }
    }

    @FXML
    public void modreOblaky(){
        for(WeatherObject o : objekty){
            if(o instanceof Cloud){
                ((Cloud) o).zmenFarbuNaModru();
            }
        }
    }

    @FXML
    public void posunVsetkoDolava(){
        for(WeatherObject o : objekty){
            o.posunDolava();
        }
    }
}
