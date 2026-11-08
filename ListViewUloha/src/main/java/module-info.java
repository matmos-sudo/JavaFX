module org.example.listviewuloha {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.listviewuloha to javafx.fxml;
    exports org.example.listviewuloha;
}