module org.example.robot {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.robot to javafx.fxml;
    exports org.example.robot;
}
