module org.example.weatherobject {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.weatherobject to javafx.fxml;
    exports org.example.weatherobject;
}