module org.example.lopta {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lopta to javafx.fxml;
    exports org.example.lopta;
}