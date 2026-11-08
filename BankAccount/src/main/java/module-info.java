module org.example.bankaccount {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.bankaccount to javafx.fxml;
    exports org.example.bankaccount;
}
