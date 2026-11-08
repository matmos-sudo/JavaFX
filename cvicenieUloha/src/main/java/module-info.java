module org.example.cvicenieuloha {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.cvicenieuloha to javafx.fxml;
    exports org.example.cvicenieuloha;
}