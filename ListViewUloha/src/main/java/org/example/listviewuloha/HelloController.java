package org.example.listviewuloha;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private ListView<ShoppingItems> myList;
    @FXML private TextField text1;
    @FXML private TextField text2;
    @FXML private Label totalCount;

    public void add(){
        String name = text1.getText();
        int qty = Integer.parseInt(text2.getText());
        ShoppingItems item = new ShoppingItems(name,qty);
        myList.getItems().add(item);
        this.updateCounter();
        text1.clear();
        text2.clear();
    }

    public void delete(){
        ShoppingItems selected = myList.getSelectionModel().getSelectedItem();
        myList.getItems().remove(selected);
        this.updateCounter();
        text1.clear();
        text2.clear();

    }

    public void updateCounter(){
        int count = myList.getItems().size();
        totalCount.setText(String.valueOf(count));

    }

    public void edit(){
        ShoppingItems selected = myList.getSelectionModel().getSelectedItem();
        String name = text1.getText();
        int qty = Integer.parseInt(text2.getText());
        selected.setName(name);
        selected.setNumber(qty);
        myList.refresh();
        text1.clear();
        text2.clear();
    }
}
