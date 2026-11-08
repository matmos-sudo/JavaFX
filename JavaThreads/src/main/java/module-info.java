module org.example.javathreads {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javathreads to javafx.fxml;
    exports org.example.javathreads;
}