package org.example.cvicenieuloha;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField tex1;
    @FXML private ListView<String> list;

    private ObservableList<String> zoznam = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        list.setItems(zoznam);
    }

    @FXML private void add() {
        String name = tex1.getText();
        if(!name.isEmpty()){
            zoznam.add(name);
        }
    }

    @FXML private void remove(){
        zoznam.remove(list.getSelectionModel().getSelectedIndex());
    }

    @FXML private void update(){

    }

}

